package hu.szabo.painmeasure.validator;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * @author Szabó Levente
 *
 *         This class used to create validation.
 */
public class Validate {

	private Validate() {
	}

	public static boolean isValidEmailAddress(String email) {
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}
}
