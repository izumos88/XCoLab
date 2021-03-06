package com.ext.portlet.model.impl;

import com.ext.portlet.model.MessagingIgnoredRecipients;
import com.ext.portlet.service.MessagingIgnoredRecipientsLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the MessagingIgnoredRecipients service. Represents a row in the &quot;xcolab_MessagingIgnoredRecipients&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MessagingIgnoredRecipientsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MessagingIgnoredRecipientsImpl
 * @see com.ext.portlet.model.MessagingIgnoredRecipients
 * @generated
 */
public abstract class MessagingIgnoredRecipientsBaseImpl
    extends MessagingIgnoredRecipientsModelImpl
    implements MessagingIgnoredRecipients {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a messaging ignored recipients model instance should use the {@link MessagingIgnoredRecipients} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            MessagingIgnoredRecipientsLocalServiceUtil.addMessagingIgnoredRecipients(this);
        } else {
            MessagingIgnoredRecipientsLocalServiceUtil.updateMessagingIgnoredRecipients(this);
        }
    }
}
