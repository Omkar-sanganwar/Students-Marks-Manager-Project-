package com.aug242;

import java.util.Scanner;

public class StudentMarksManager {

	private int[] marks;
	private int count;

	public StudentMarksManager(int numberOfSubjects) {
		marks = new int[numberOfSubjects];
		count = 0;
	}

	public void addMark(int mark) {
		if (mark >= 0 && mark <= 100) {
			if (count < marks.length) {
				marks[count] = mark;
				count++;
				System.out.println("Mark added successfully.");
			} else {
				System.out
						.println("Cannot add more marks. Maximum limit reached.");
			}
		} else {
			System.out
					.println("Invalid mark! Please enter a value between 0 and 100.");
		}
	}

	public double getAverageMark() {
		if (count == 0) {
			System.out.println("No marks available.");
			return 0.0;
		}

		int sum = 0;
		for (int i = 0; i < count; i++) {
			sum += marks[i];
		}
		return (double) sum / count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of subjects: ");
		int numberOfSubjects = scanner.nextInt();

		StudentMarksManager manager = new StudentMarksManager(numberOfSubjects);

		boolean continueProgram = true;
		while (continueProgram) {
			System.out.println("\nOptions:");
			System.out.println("1. Add Mark");
			System.out.println("2. Get Average Mark");
			System.out.println("3. Exit");
			System.out.print("Choose an option: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter mark: ");
				int mark = scanner.nextInt();
				manager.addMark(mark);
				break;
			case 2:
				double averageMark = manager.getAverageMark();
				if (averageMark > 0) {
					System.out.println("Average Mark: " + averageMark);
				}
				break;
			case 3:
				continueProgram = false;
				System.out.println("Exiting the program.");
				break;
			default:
				System.out
						.println("Invalid choice! Please select a valid option.");
			}
		}
		scanner.close();
	}
}
