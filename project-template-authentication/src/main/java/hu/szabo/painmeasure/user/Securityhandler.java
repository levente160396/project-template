package hu.szabo.painmeasure.user;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class Securityhandler implements AuthenticationSuccessHandler {

	@Autowired
	UserRepository userRepository;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException {

		User userByUsername = userRepository.getUserByUsername(authentication.getName());

		response.sendRedirect(request.getContextPath() + "/dashboard.xhtml");
		
		userByUsername.setLastLogin(new Date());
		userRepository.save(userByUsername);
	}
}
