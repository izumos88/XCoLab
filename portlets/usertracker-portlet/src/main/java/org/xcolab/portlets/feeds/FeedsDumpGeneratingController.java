package org.xcolab.portlets.feeds;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import au.com.bytecode.opencsv.CSVWriter;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.social.model.SocialActivity;
import com.liferay.portlet.social.model.SocialActivityFeedEntry;
import com.liferay.portlet.social.service.SocialActivityInterpreterLocalServiceUtil;
import com.liferay.portlet.social.service.SocialActivityLocalServiceUtil;
import com.liferay.util.portlet.PortletProps;

@Controller
@RequestMapping("view")
public class FeedsDumpGeneratingController {
	private DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	private byte[] generatedActivities = {};
	private int activitiesInGeneratedDump = 0;

	@RequestMapping(params = "action=generateDump")
	public void showFeed(ResourceRequest request, ResourceResponse response)
			throws SystemException, PortalException, IOException {
		generateActivitiesDump(request);
		response.setContentType("application/zip");
		response.getPortletOutputStream().write(generatedActivities);
		response.addProperty("Content-Disposition", "inline");
		response.addProperty("filename", "myfile.txt");
		
		// 
	}

	private synchronized void generateActivitiesDump(ResourceRequest request)
			throws IOException, SystemException {
		int currentCount = SocialActivityLocalServiceUtil
				.getSocialActivitiesCount();
		if (currentCount > activitiesInGeneratedDump) {
			// regenerate

			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ZipOutputStream zos = new ZipOutputStream(bos);

			zos.putNextEntry(new ZipEntry("activities.csv"));

			Writer fw = new OutputStreamWriter(zos);
			CSVWriter csvWriter = new CSVWriter(fw);

			for (SocialActivity activity : SocialActivityLocalServiceUtil
					.getSocialActivities(0, Integer.MAX_VALUE)) {
				try {
					User user = UserLocalServiceUtil.getUser(activity
							.getUserId());
					SocialActivityFeedEntry entry = SocialActivityInterpreterLocalServiceUtil
							.interpret(activity, (ThemeDisplay) request
									.getAttribute(WebKeys.THEME_DISPLAY));
					String body = entry.getBody();
					if (body != null && body.trim().length() > 0) {
						body = body.replace("/web/guest",
								"http://climatecolab.org/web/guest");
						csvWriter.writeNext(new String[] {
								df.format(new Date(activity.getCreateDate())),
								user.getScreenName(), body });
					}
				} catch (Throwable t) {
					// ignore
				}
			}
			fw.flush();
			zos.closeEntry();
			csvWriter.close();
			fw.close();

			generatedActivities = bos.toByteArray();
			activitiesInGeneratedDump = currentCount;
		}
	}

}