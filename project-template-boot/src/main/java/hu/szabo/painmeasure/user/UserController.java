package hu.szabo.painmeasure.user;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import lombok.Data;

/**
 * @author Szabó Levente
 *
 *         This class used to manage view in user menu.
 */

@Data
@Named
@Scope("view")
public class UserController implements Serializable {

	private static final long serialVersionUID = 3949103988576462228L;

	@Inject
	private UserBean userBean;

	private UserView userView;

	public enum UserView {
		ALL_USER, EDIT_USER, 
	}

	@PostConstruct
	void init() {

		userView = UserView.ALL_USER;
	}

	public void backAllUser() {
		userView = UserView.ALL_USER;
	}

	public void saveUser() {
		if (userBean.saveUser()) {
			userView = UserView.ALL_USER;
		}
	}

	public void editUser(Long userId) {
		userBean.editUser(userId);

		userView = UserView.EDIT_USER;
	}

	public void deleteUser(Long userId) {
		userBean.deleteUser(userId);
	}
}
