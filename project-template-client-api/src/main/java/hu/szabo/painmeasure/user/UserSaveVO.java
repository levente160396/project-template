package hu.szabo.painmeasure.user;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class UserSaveVO implements Serializable {

	private static final long serialVersionUID = -7770791017861588057L;

	private Long modifyId;

	private String username;

	private String firstName;

	private String lastName;

	private String email;

	private String password;

	private Boolean isActive;

	private Role role;
	
	private Date lastLogin;
}
