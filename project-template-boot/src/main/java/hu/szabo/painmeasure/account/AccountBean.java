package hu.szabo.painmeasure.account;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import hu.szabo.painmeasure.user.Role;
import hu.szabo.painmeasure.user.UserDisplayVO;
import lombok.Data;

/**
 * @author Szabó Levente
 *
 *         This class used to manage Accounts.
 */

@Data
@Named
@Scope("session")
public class AccountBean implements Serializable {

	private static final long serialVersionUID = -5781012754006251880L;

	@Inject
	private AccountService accountService;

	public Role getRole() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (!(authentication instanceof AnonymousAuthenticationToken) && authentication != null) {
			return accountService.getRoleByUserName(authentication.getName());
		}

		return null;
	}

	public UserDisplayVO getCurrentUser() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (!(authentication instanceof AnonymousAuthenticationToken) && authentication != null) {
			return accountService.getUserDisplayVOByUserName(authentication.getName());
		}

		return null;

	}
}
