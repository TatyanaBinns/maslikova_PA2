package maslikova_p1;

import java.util.Scanner;

public class Encrypt {

	public static int encrypt(int input) {
		// each digit
		int a = input / 1000;
		int b = input % 1000 / 100;
		int c = input % 100 / 10;
		int d = input % 10;
		// each digit + 7 %10
		a = (a + 7) % 10;
		b = (b + 7) % 10;
		c = (c + 7) % 10;
		d = (d + 7) % 10;

		// swap 1st digit with third, second digit with fourth; order will be
		// third, fourth, first, second; cdab

		return c * 1000 + d * 100 + a * 10 + b;
	}

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		// read in 4 digit integer
		// store in variable
		int input = scnr.nextInt();

		// encrypt
		// print encrypted integer
		System.out.println(Encrypt.encrypt(input));
		scnr.close();
	}
}
