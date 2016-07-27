
public class GameBoard {

	public static void gameBoard(int[][] board) {

		boolean isOccupied = false;

		// ===
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++)
				if (board[i][j] == 0){
					System.out.print("~  ");
				}
				else{
				System.out.print(board[i][j] + "  ");
				}
			System.out.println();
		}
	}
}