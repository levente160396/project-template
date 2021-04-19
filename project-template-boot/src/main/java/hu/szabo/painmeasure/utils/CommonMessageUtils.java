package hu.szabo.painmeasure.utils;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 * @author Szabó Levente
 *
 *         This class used to create message for user.
 */
public class CommonMessageUtils {

	public static final ResourceBundle RB = ResourceBundle.getBundle("hu.pain.messages");

	private CommonMessageUtils() {
	}

	public static String getMessage(String key) {
		String message = null;
		try {
			message = FacesContext.getCurrentInstance().getApplication()
					.getResourceBundle(FacesContext.getCurrentInstance(), "msg").getString(key);
		} catch (Exception e) {
			message = "" + key + "";
		}
		return message;
	}

	public static void addFacesMessage(FacesMessage.Severity severity, String key) {
		String message = getMessage(key);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, message, message));
	}

	public static void addFacesMessage(FacesMessage.Severity severity, String key, String details) {
		String message = getMessage(key);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(severity, message + details, message + details));
	}

	public static void addFacesMessage(String clientId, FacesMessage.Severity severity, String key) {
		String message = getMessage(key);
		FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(severity, message, message));
	}

	public static void addPlainFacesMessage(FacesMessage.Severity severity, String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, message, message));
	}

	public static void throwValidatorException(FacesMessage.Severity severity, String key) {
		String message = getMessage(key);
		throw new ValidatorException(new FacesMessage(severity, message, message));
	}
}
