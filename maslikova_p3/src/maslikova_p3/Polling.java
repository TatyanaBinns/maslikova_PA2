package maslikova_p3;

import java.util.Scanner;

public class Polling {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);
		String[] topics = { "Healthcare", "Education", "Immigration", "Housing", "Clean Energy" };
		int[][] responses = new int[topics.length][10];

		// For each topic:
		// Print the topic, and prompt the user for a value 1-10
		// Increment that element in the responses array
		// prompt user to rate each topic
		// get topic ratings from user
		// user input phase occurs within a loop
		boolean keepGoing = true;

		while (keepGoing) {
			System.out.println("\n\n========Beginning of Survey========");
			for (int i = 0; i < topics.length; i++) {
				System.out.println(
						"How would you rate the importance of " + topics[i] + " on a scale of 1 (least) to 10 (most)?");
				if (!scnr.hasNextInt())
					break;
				int resp = scnr.nextInt();
				while (resp < 1 || resp > 10) {
					System.out.println("Error, please input a number between 1 and 10");
					resp = scnr.nextInt();
				}
				responses[i][resp - 1]++;
			}
			System.out.println(
					"End of Survey reached, enter \"break\" to display a summary and stop entering responses.");
			if (scnr.next().equals("break"))
				keepGoing = false;
		}
		// display tabular report as a 5x10 table
		// include per-topic average in report

		int maxLen = 0;
		for (String s : topics)
			if (s.length() > maxLen)
				maxLen = s.length();

		System.out.printf("%-" + maxLen + "s: ", "Topics");
		for (int i = 1; i <= 10; i++)
			System.out.printf(" %3d", i);
		System.out.println();
		System.out.println();
		for (int topicIndex = 0; topicIndex < topics.length; topicIndex++) {
			System.out.printf("%-" + maxLen + "s: ", topics[topicIndex]);
			for (int respIndex = 0; respIndex < responses[topicIndex].length; respIndex++)
				System.out.printf(" %3d", responses[topicIndex][respIndex]);

			int score = 0, entries = 0;
			for (int j = 0; j < responses[topicIndex].length; j++) {
				score += responses[topicIndex][j] * (j + 1);
				entries += responses[topicIndex][j];
			}

			System.out.printf(" Average: %.2f\n", 1.0 * score / entries);
		}
		// display issue with highest point total
		// display issue with lowest point total
		String mostImportant = topics[0];
		int mostImportantScore = Integer.MIN_VALUE;
		String leastImportant = topics[0];
		int leastImportantScore = Integer.MAX_VALUE;

		for (int i = 0; i < topics.length; i++) {
			int score = 0;
			for (int j = 0; j < responses[i].length; j++)
				score += responses[i][j] * (j + 1);
			if (score > mostImportantScore) {
				mostImportantScore = score;
				mostImportant = topics[i];
			}
			if (score < leastImportantScore) {
				leastImportantScore = score;
				leastImportant = topics[i];
			}
		}

		System.out.println(
				"\nThe most important issue was " + mostImportant + " with a total score of " + mostImportantScore);
		System.out.println(
				"The least important issue was " + leastImportant + " with a total score of " + leastImportantScore);

	}

}
