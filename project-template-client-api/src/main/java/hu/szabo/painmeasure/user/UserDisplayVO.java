package hu.szabo.painmeasure.user;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class UserDisplayVO implements Serializable {

	private static final long serialVersionUID = -2064408561954768662L;

	private Long id;

	private String username;

	private String firstName;

	private String lastName;

	private String email;

	private Boolean isActive;

	private Role role;
	
	private Date lastLogin;
}
