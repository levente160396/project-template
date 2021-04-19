package hu.szabo.painmeasure.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import hu.szabo.painmeasure.account.AccountBean;
import hu.szabo.painmeasure.utils.CommonMessageUtils;
import lombok.Data;

/**
 * @author Szabó Levente
 *
 *         This class used to manage user.
 */

@Data
@Named
@Scope("view")
public class UserBean implements Serializable {

	private static final long serialVersionUID = -4207554377041380289L;

	@Inject
	private UserService userService;

	@Inject
	private AccountBean accountBean;

	private List<UserDisplayVO> users;

	private UserSaveVO userSaveVO;

	private List<Role> roles;

	private String passwordChecker;

	@PostConstruct
	void init() {

		users = userService.findAllUsers();
		roles = new ArrayList<Role>(EnumSet.allOf(Role.class));
	}

	public Boolean saveUser() {

		if (null == userSaveVO.getModifyId() && !userSaveVO.getPassword().equals(passwordChecker)) {

			CommonMessageUtils.addFacesMessage(FacesMessage.SEVERITY_ERROR,
					CommonMessageUtils.RB.getString("userbean.password.checker"));

			return Boolean.FALSE;
		}

		if (null == userSaveVO.getModifyId()
				&& Boolean.TRUE.equals(userService.findByUsername(userSaveVO.getUsername()))) {
			CommonMessageUtils.addFacesMessage(FacesMessage.SEVERITY_ERROR,
					CommonMessageUtils.RB.getString("userbean.same.username"));

			return Boolean.FALSE;
		}

		userService.saveUser(userSaveVO);
		init();

		return Boolean.TRUE;
	}

	public void editUser(Long userId) {

		userSaveVO = userService.findUserSaveVOByUserId(userId);
	}

	public void deleteUser(Long userId) {

		userService.deleteUserById(userId);
		init();
	}
}
