package hu.szabo.painmeasure.utils;

/**
 * @author Szabó Levente
 *
 *         Use this class, if you want to log e-mail address
 */

public class LoggerUtils {

	private LoggerUtils() {
	}

	public static String logEmail(String email) {
		String emailFirstFourChar;
		StringBuilder emailAdressLogs = new StringBuilder();
		if (email.length() > 4) {
			emailFirstFourChar = email.substring(0, 4);
			emailAdressLogs.append(emailFirstFourChar);
			for (int i = 0; i < email.length() - 4; i++) {
				emailAdressLogs.append("*");
			}

			return emailAdressLogs.toString();
		} else {
			emailAdressLogs.append("The email address is to short to log out!");
			return emailAdressLogs.toString();
		}
	}
}
