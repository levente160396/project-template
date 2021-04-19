package hu.szabo.painmeasure.account;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import hu.szabo.painmeasure.utils.JSFUtil;
import lombok.Data;

@Data
@Named
@Scope("view")
public class RegistrationController {

	
	public void redirectToRegistration() {
		JSFUtil.redirectRelative("/registration.xhtml");
	}
	
	public void redirectToLogin() {
		JSFUtil.redirectRelative("/login.xhtml");
	}
}
