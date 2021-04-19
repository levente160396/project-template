package hu.szabo.painmeasure.user;

import org.springframework.security.core.AuthenticationException;

public class UserInactiveEcxeption extends AuthenticationException {

	private static final long serialVersionUID = -6281458258580183636L;

	public UserInactiveEcxeption(String msg) {
		super(msg);
	}

	public UserInactiveEcxeption(String msg, Throwable t) {
		super(msg, t);
	}
}
