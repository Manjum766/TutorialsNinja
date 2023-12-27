package com.VRJD.TutorialsNinja.Utilities;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

public class CommonUtils {

	public static final int PAGE_LOAD_TIME = 15;
	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int EXPLICIT_WAIT_BASIC_TIME = 30;

	/**
	 * Method for decoding the encrypted value to Base64 value
	 * 
	 * @param value
	 * @return
	 */
	public String decodeBase64Value(String value) {
		try {
			byte[] decoded = Base64.getDecoder().decode(value);
			String decodedValue = new String(decoded, StandardCharsets.UTF_8);
			return decodedValue;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Method for Generating Random Unique Email
	 * 
	 * @return
	 */
	public String getEmailWithTimeStamp() {
		Date date = new Date();
		return "varadaraj" + date.toString().replace(" ", "_").replace(":", "_") + "@gmail.com";
	}

	/**
	 * Method for Generating Random String for Unique Email
	 * 
	 * @return
	 */
	public static String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(15);
		return (generatedString);
	}

}
