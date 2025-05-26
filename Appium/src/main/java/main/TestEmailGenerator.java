package main;

import java.util.Random;

public class TestEmailGenerator {
	public static void main(String[] args) {

		String randomEmail = generateRandomEmailForTesting();
		System.out.println("Generated Email for Testing: " + randomEmail);

	}

	public static String generateRandomEmailForTesting() {
		String characters = "abcdefghijklmnopqrstuvwxyz";
		Random random = new Random();
		StringBuilder username = new StringBuilder();

		// Generate a random username with 10 characters
		for (int i = 0; i < 6; i++) {
			username.append(characters.charAt(random.nextInt(characters.length())));
		}

		// Fixed domain for testing
		String domain = "yopmail.com";

		// Combine username and domain
		return username + "@" + domain;
	}
}
