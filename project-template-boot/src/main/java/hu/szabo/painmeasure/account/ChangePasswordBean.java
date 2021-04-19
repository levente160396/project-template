package hu.szabo.painmeasure.account;

import java.io.IOException;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;

import hu.szabo.painmeasure.user.UserService;
import hu.szabo.painmeasure.utils.CommonMessageUtils;
import hu.szabo.painmeasure.utils.StringUtils;
import lombok.Data;

/**
 * @author Szabó Levente
 *
 *         This class used to changed password;
 */

@Data
@Named
@Scope("view")
public class ChangePasswordBean implements Serializable {

	private static final long serialVersionUID = -1832820834050236123L;

	private static final Logger LOGGER = LoggerFactory.getLogger(ChangePasswordBean.class);

	@Inject
	private UserService userService;

	@Inject
	private AccountBean accountBean;

	private String oldPassword;

	private String firstNewPassword;

	private String secondNewPassword;

	public void saveNewPassword() {
		if (!validatePassword()) {
			return;
		}

		userService.saveNewPassword(firstNewPassword, accountBean.getCurrentUser().getId());

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
							+ "/dashboard.xhtml");
		} catch (IOException e) {
			LOGGER.error("Failed to redirect to dashboard.xhtml!", e.getMessage(), e);
		}
	}

	private Boolean validatePassword() {

		if (!userService.checkOldPassword(oldPassword, accountBean.getCurrentUser().getId())) {
			CommonMessageUtils.addFacesMessage(FacesMessage.SEVERITY_ERROR,
					CommonMessageUtils.RB.getString("checkpassword.old.password.failed"));
			return Boolean.FALSE;
		}
		if (!firstNewPassword.equals(secondNewPassword)) {
			CommonMessageUtils.addFacesMessage(FacesMessage.SEVERITY_ERROR,
					CommonMessageUtils.RB.getString("checkpassword.new.password.not.same"));
			return Boolean.FALSE;
		}

		if (!StringUtils.checkPassword(firstNewPassword)) {
			CommonMessageUtils.addFacesMessage(FacesMessage.SEVERITY_ERROR,
					CommonMessageUtils.RB.getString("checkpassword.new.password.uppercase.digits"));
			return Boolean.FALSE;
		}

		return Boolean.TRUE;
	}
}
