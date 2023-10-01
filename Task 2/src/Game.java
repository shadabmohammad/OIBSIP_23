import java.util.Random;

// Game class
class Game {

	int systemInput;
	int userInput;
	int noOfGuesses = 0;

	// generating random number in default constructor
	Game() {
		Random random = new Random();
		this.systemInput = random.nextInt(100) + 1;
	}

	// method to take user guesses
	public boolean takeUserInput() {
		if (noOfGuesses < 10) {
			System.out.print("Guess the number : ");
			this.userInput = GuessTheNumber.takeIntegerInput(100);
			noOfGuesses++;
			return false;
		} else {
			System.out.println("Number of attempts finished...Better luck next time\n");
			return true;
		}
	}

	// method to check user guess status
	public boolean isCorrectGuess() {

		if (systemInput == userInput) {
			System.out.println("Congratulations, you guessed the number " + systemInput +
					" in " + noOfGuesses + " guesses");
			switch (noOfGuesses) {
				case 1:
					System.out.println("Your score is 100");
					break;
				case 2:
					System.out.println("Your score is 90");
					break;
				case 3:
					System.out.println("Your score is 80");
					break;
				case 4:
					System.out.println("Your score is 70");
					break;
				case 5:
					System.out.println("Your score is 60");
					break;
				case 6:
					System.out.println("Your score is 50");
					break;
				case 7:
					System.out.println("Your score is 40");
					break;
				case 8:
					System.out.println("Your score is 30");
					break;
				case 9:
					System.out.println("Your score is 20");
					break;
				case 10:
					System.out.println("Your score is 10");
					break;
			}
			System.out.println();
			return true;
		} else if (noOfGuesses < 10 && userInput > systemInput) {
			if (userInput - systemInput > 10) {
				System.out.println("Too High");
			} else {
				System.out.println("Little High");
			}
		} else if (noOfGuesses < 10 && userInput < systemInput) {
			if (systemInput - userInput > 10) {
				System.out.println("Too low");
			} else {
				System.out.println("Little low");
			}
		}
		return false;
	}
}
