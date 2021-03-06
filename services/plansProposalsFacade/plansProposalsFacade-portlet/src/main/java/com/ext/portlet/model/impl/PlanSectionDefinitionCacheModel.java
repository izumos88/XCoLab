package com.ext.portlet.model.impl;

import com.ext.portlet.model.PlanSectionDefinition;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PlanSectionDefinition in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see PlanSectionDefinition
 * @generated
 */
public class PlanSectionDefinitionCacheModel implements CacheModel<PlanSectionDefinition>,
    Externalizable {
    public long id;
    public String type;
    public String adminTitle;
    public String title;
    public String defaultText;
    public String helpText;
    public int characterLimit;
    public long focusAreaId;
    public long tier;
    public String allowedContestTypeIds;
    public String allowedValues;
    public String additionalIds;
    public boolean locked;
    public boolean contestIntegrationRelevance;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(29);

        sb.append("{id=");
        sb.append(id);
        sb.append(", type=");
        sb.append(type);
        sb.append(", adminTitle=");
        sb.append(adminTitle);
        sb.append(", title=");
        sb.append(title);
        sb.append(", defaultText=");
        sb.append(defaultText);
        sb.append(", helpText=");
        sb.append(helpText);
        sb.append(", characterLimit=");
        sb.append(characterLimit);
        sb.append(", focusAreaId=");
        sb.append(focusAreaId);
        sb.append(", tier=");
        sb.append(tier);
        sb.append(", allowedContestTypeIds=");
        sb.append(allowedContestTypeIds);
        sb.append(", allowedValues=");
        sb.append(allowedValues);
        sb.append(", additionalIds=");
        sb.append(additionalIds);
        sb.append(", locked=");
        sb.append(locked);
        sb.append(", contestIntegrationRelevance=");
        sb.append(contestIntegrationRelevance);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public PlanSectionDefinition toEntityModel() {
        PlanSectionDefinitionImpl planSectionDefinitionImpl = new PlanSectionDefinitionImpl();

        planSectionDefinitionImpl.setId(id);

        if (type == null) {
            planSectionDefinitionImpl.setType(StringPool.BLANK);
        } else {
            planSectionDefinitionImpl.setType(type);
        }

        if (adminTitle == null) {
            planSectionDefinitionImpl.setAdminTitle(StringPool.BLANK);
        } else {
            planSectionDefinitionImpl.setAdminTitle(adminTitle);
        }

        if (title == null) {
            planSectionDefinitionImpl.setTitle(StringPool.BLANK);
        } else {
            planSectionDefinitionImpl.setTitle(title);
        }

        if (defaultText == null) {
            planSectionDefinitionImpl.setDefaultText(StringPool.BLANK);
        } else {
            planSectionDefinitionImpl.setDefaultText(defaultText);
        }

        if (helpText == null) {
            planSectionDefinitionImpl.setHelpText(StringPool.BLANK);
        } else {
            planSectionDefinitionImpl.setHelpText(helpText);
        }

        planSectionDefinitionImpl.setCharacterLimit(characterLimit);
        planSectionDefinitionImpl.setFocusAreaId(focusAreaId);
        planSectionDefinitionImpl.setTier(tier);

        if (allowedContestTypeIds == null) {
            planSectionDefinitionImpl.setAllowedContestTypeIds(StringPool.BLANK);
        } else {
            planSectionDefinitionImpl.setAllowedContestTypeIds(allowedContestTypeIds);
        }

        if (allowedValues == null) {
            planSectionDefinitionImpl.setAllowedValues(StringPool.BLANK);
        } else {
            planSectionDefinitionImpl.setAllowedValues(allowedValues);
        }

        if (additionalIds == null) {
            planSectionDefinitionImpl.setAdditionalIds(StringPool.BLANK);
        } else {
            planSectionDefinitionImpl.setAdditionalIds(additionalIds);
        }

        planSectionDefinitionImpl.setLocked(locked);
        planSectionDefinitionImpl.setContestIntegrationRelevance(contestIntegrationRelevance);

        planSectionDefinitionImpl.resetOriginalValues();

        return planSectionDefinitionImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        type = objectInput.readUTF();
        adminTitle = objectInput.readUTF();
        title = objectInput.readUTF();
        defaultText = objectInput.readUTF();
        helpText = objectInput.readUTF();
        characterLimit = objectInput.readInt();
        focusAreaId = objectInput.readLong();
        tier = objectInput.readLong();
        allowedContestTypeIds = objectInput.readUTF();
        allowedValues = objectInput.readUTF();
        additionalIds = objectInput.readUTF();
        locked = objectInput.readBoolean();
        contestIntegrationRelevance = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);

        if (type == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(type);
        }

        if (adminTitle == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(adminTitle);
        }

        if (title == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(title);
        }

        if (defaultText == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(defaultText);
        }

        if (helpText == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(helpText);
        }

        objectOutput.writeInt(characterLimit);
        objectOutput.writeLong(focusAreaId);
        objectOutput.writeLong(tier);

        if (allowedContestTypeIds == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(allowedContestTypeIds);
        }

        if (allowedValues == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(allowedValues);
        }

        if (additionalIds == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(additionalIds);
        }

        objectOutput.writeBoolean(locked);
        objectOutput.writeBoolean(contestIntegrationRelevance);
    }
}
