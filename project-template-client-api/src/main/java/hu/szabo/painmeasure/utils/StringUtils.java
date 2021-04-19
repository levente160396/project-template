package hu.szabo.painmeasure.utils;

/**
 * @author Szabó Levente
 *
 *
 */

public class StringUtils {

	private StringUtils() {
	}

	public static String insertString(String originalString, String stringToBeInserted, int index) {
		StringBuilder str = new StringBuilder(originalString);

		return str.insert(index, stringToBeInserted).toString();
	}

	public static boolean checkPassword(String str) {
		char ch;
		boolean capitalFlag = false;
		boolean lowerCaseFlag = false;
		boolean numberFlag = false;
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			if (Character.isDigit(ch)) {
				numberFlag = true;
			} else if (Character.isUpperCase(ch)) {
				capitalFlag = true;
			} else if (Character.isLowerCase(ch)) {
				lowerCaseFlag = true;
			}
			if (numberFlag && capitalFlag && lowerCaseFlag)
				return true;
		}
		return false;
	}
}
