import java.util.Scanner;

public class Player {

	private int[][] board;
	int rowNumber = 0, columnNumber = 0, compareRow, compareColumn, shipPartOne, shipPartTwo;
	int shipCounter = 1;
	int placement;

	public Player() {
		board = new int[12][12];
	}

	public void printBoard() {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++)
				if (board[i][j] == 0){
					System.out.print("~  ");
				}
				else if (board[i][j] == 3){
					System.out.print("*  ");
				}
				else if (board[i][j] == 2){
					System.out.print("X  ");
				}
				else{
				System.out.print(board[i][j] + "  ");
				}
			
			System.out.println();
		}
	}

	public void shipPlacement() {

		do {
			// ====User Input asking for row and column number====
			Scanner userInput = new Scanner(System.in);
			System.out.println("Enter a row number: ");
			rowNumber = userInput.nextInt();
			System.out.println("Enter a column number: ");
			columnNumber = userInput.nextInt();
			shipPartOne = board[rowNumber][columnNumber] = 1;

			GameBoard.gameBoard(board); // update board
			System.out.println();

			System.out.println("Enter the position of ship part 2: Up(1), Down(2), Right(3), Left(4)");
			placement = userInput.nextInt();

			try {
				if (placement == 1) {
					shipPartTwo = board[rowNumber - 1][columnNumber] = 1;
				} else if (placement == 2) {
					shipPartTwo = board[rowNumber + 1][columnNumber] = 1;
				} else if (placement == 3) {
					shipPartTwo = board[rowNumber][columnNumber + 1] = 1;
				} else if (placement == 4) {
					shipPartTwo = board[rowNumber][columnNumber - 1] = 1;
				}

				GameBoard.gameBoard(board); // update board
				System.out.println();
				shipCounter++;

			} catch (ArrayIndexOutOfBoundsException e) {

				System.out.println("This will place you ship outside of the board. Please try again");
				shipPlacement();
			}
		} while (shipCounter == 2);
	}

	public void fire() {

		Scanner userInput = new Scanner(System.in);
		System.out.println("PLAYER ONE: Time to Fire! Enter a row number: ");
		compareRow = userInput.nextInt();
		System.out.println("Enter a column number: ");
		compareColumn = userInput.nextInt();

		if (compareRow <= 12 && compareColumn <= 12) {
			if (board[compareRow][compareColumn] == 1) {
				System.out.println("HIT");
				board[compareRow][compareColumn] = 2;
				fire();
			} else {
				System.out.println("MISS");
				board[compareRow][compareColumn] = 3;	
			}
		}

	}
}