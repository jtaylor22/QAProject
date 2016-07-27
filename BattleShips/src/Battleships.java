public class Battleships {

	public static void main(String[] args) {
		// int[][] board = new int[12][12];
		// int[][] board2 = new int[12][12];
		// GameBoard.gameBoard(board); // call the gameBoard method
		// System.out.println();
		// GameBoard.gameBoard(board2);
		int playGame = 1;
		Player p1 = new Player();
		Player p2 = new Player();
		System.out.println("=============PLAYER ONE==============");
		p1.printBoard();
		System.out.println();
		System.out.println("=============PLAYER TWO==============");
		p2.printBoard();

		p1.shipPlacement();
		p2.shipPlacement();

		System.out.println("===========================THE FINAL BOARD==============================");
		System.out.println();

		p1.printBoard();
		System.out.println();
		p2.printBoard();
		// call the shipPlacement method

		do{
		p1.fire();
		p1.printBoard();
		System.out.println();
		p2.printBoard();
		
		p2.fire();
		p2.printBoard();
		System.out.println();
		p1.printBoard();
		} while (playGame == 1);
		
	}
}