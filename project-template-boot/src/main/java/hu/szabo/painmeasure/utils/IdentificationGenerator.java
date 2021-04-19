package hu.szabo.painmeasure.utils;

import java.util.Random;

/**
 * @author Szabó Levente
 *
 *         This class used to generate random identification.
 */
public class IdentificationGenerator {

	private IdentificationGenerator() {
	}

	public static String generateIdentification() {
		int leftLimit = 97;
		int rightLimit = 122;
		int targetStringLength = 10;
		Random random = new Random();

		return random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
	}
}
