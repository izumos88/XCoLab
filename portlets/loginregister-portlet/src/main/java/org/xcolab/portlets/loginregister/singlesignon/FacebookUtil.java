package org.xcolab.portlets.loginregister.singlesignon;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.util.UriComponentsBuilder;

import org.xcolab.client.admin.enums.ConfigurationAttributeKey;
import org.xcolab.util.RequestUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URL;

import javax.portlet.PortletRequest;

public final class FacebookUtil {

    private static final Log _log = LogFactoryUtil.getLog(FacebookUtil.class);

    public static final String FB_PROFILE_PIC_URL_FORMAT_STRING =
            "https://graph.facebook.com/%d/?fields=picture.type(large)";
    public static final String AUTH_URL = "https://graph.facebook.com/oauth/authorize";
    public static final String REDIRECT_URL = "/web/guest/loginregister/-/login/SSO/facebook/";

    private static final String GRAPH_URL = "https://graph.facebook.com";
    private static final String TOKEN_URL = "https://graph.facebook.com/oauth/access_token";

    private FacebookUtil() {
    }

    /**
     * Get the real image URL
     */
    public static String getFacebookPictureURLString(String fbProfilePictureURL) {
        try {
            //TODO: this doesn't work -> requires token!
            // Get real facebook image URL
            InputStream is = new URL(fbProfilePictureURL).openStream();
            StringWriter writer = new StringWriter();
            IOUtils.copy(is, writer, "UTF-8");
            String json = writer.toString();

            JSONObject fbJson = JSONFactoryUtil.createJSONObject(json);
            return fbJson.getJSONObject("picture").getJSONObject("data").getString("url");
        } catch (JSONException | IOException e) {
            _log.error("Error while getting facebook picture url", e);
        }

        return null;
    }

    public static String getAccessToken(PortletRequest request, String code) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(TOKEN_URL)
                .queryParam("client_id", ConfigurationAttributeKey.FACEBOOK_APPLICATION_ID.getStringValue())
                .queryParam("redirect_uri", getAuthRedirectURL(request))
                .queryParam("client_secret", ConfigurationAttributeKey.FACEBOOK_APPLICATION_SECRET.getStringValue())
                .queryParam("code", code);
        final String requestResult = RequestUtils.post(uriBuilder, null, String.class);
        //TODO: copied from liferay - this could be nicer
        if (StringUtils.isNotEmpty(requestResult)) {
            int x = requestResult.indexOf("access_token=");
            if (x >= 0) {
                int y = requestResult.indexOf(38, x);
                if (y < x) {
                    y = requestResult.length();
                }

                return requestResult.substring(x + 13, y);
            }
        }

        return null;
    }

    public static JSONObject getGraphResources(String path, String accessToken, String fields) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(GRAPH_URL + path)
                .queryParam("access_token", accessToken)
                .queryParam("fields", fields);
        final String json = RequestUtils.getUnchecked(uriBuilder, String.class);
        try {
            return JSONFactoryUtil.createJSONObject(json);
        } catch (JSONException e) {
            return null;
        }
    }

    public static String getAuthRedirectURL(PortletRequest request) {
        return FacebookUtil.getDomain(request) + FacebookUtil.REDIRECT_URL;
    }

    public static String getDomain(PortletRequest request) {
        final boolean isStandardPort =
                (request.getScheme().equals("http") && request.getServerPort() == 80)
                        || (request.getScheme().equals("https") && request.getServerPort() == 443);
        return request.getScheme() + "://" + request.getServerName()
                + (!isStandardPort ? ":" + request.getServerPort() : "");
    }

}
