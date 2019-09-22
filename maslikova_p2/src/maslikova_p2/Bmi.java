package maslikova_p2;

import java.util.Scanner;

public class Bmi {
	public static void main(String[] bob) {
		// ask user which formula to use, read in input

		double mult = 1.0;
		Scanner scnr = new Scanner(System.in);
		System.out.print("Would you like bmi calculated using kg (metric units, kilograms and meters) or lb "
				+ "(imperial units, pounds and inches)? ");
		if (scnr.next().equals("lb"))
			mult = 703.0;

		// ask user for weight and height, read in input
		System.out.println("Please enter in your weight.");
		double weight = scnr.nextDouble();

		System.out.println("Please enter in your height.");
		double height = scnr.nextDouble();

		// calculate Bmi
		double calcBmi = mult * (weight / (height * height));

		// print bmi

		System.out.print("Your BMI is " + calcBmi);
		// display bmi categories

		if (calcBmi < 18.5)
			System.out.println("(Underweight)");
		else if ((calcBmi >= 18.5) && (calcBmi < 25))
			System.out.println("(Normal weight)");
		else if ((calcBmi >= 25) && (calcBmi < 30))
			System.out.println("(Overweight)");
		else
			System.out.println("(Obesity)");

		// display bmi categories and their values from website.
		System.out.println("\nBMI Categories:");
		System.out.println("Underweight = <18.5");
		System.out.println("Normal weight = 18.5–24.9");
		System.out.println("Overweight = 25–29.9");
		System.out.println("Obesity = BMI of 30 or greater");
	}
}
