import java.util.Scanner;
import javax.swing.JOptionPane;
public class Connect4Game {
	private static Connect4Grid2DArray grid;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		grid = new Connect4Grid2DArray();
		grid.emptyGrid();
		System.out.print("Input a character to reresent you in the Connect 4 game: ");
		char input = scan.nextLine().charAt(0);
		C4HumanPlayer player = new C4HumanPlayer(grid, input);
		System.out.print("Input a character to reresent the computer in the Connect 4 game: ");
		input = scan.nextLine().charAt(0);
		AIPlayer computer = new AIPlayer(grid, input);
		Integer column;
		int playAgain;
		//do
	    //{
			do
			{
				grid.toString();
				do
				{
				System.out.print("Input the column you wish to drop a piece in: ");
				column = scan.nextInt();
				column = column - 1;
				if(!grid.isValidColumn(column) || grid.isColumnFull(column))
					System.out.println("Your column is either full or not on the board. Please retry.");
				}while(!grid.isValidColumn(column) || grid.isColumnFull(column));
				player.makeMove(column);
				if(!grid.didLastPieceConnect4(player.getPiece()))
					computer.makeMove();
			}while(!grid.isGridFull() && !grid.didLastPieceConnect4(player.getPiece()) && 
					!grid.didLastPieceConnect4(computer.getPiece()));
			grid.toString();
			if(player.winner())
				System.out.println("You win!");
			else
				if(computer.winner())
					System.out.println("Computer Wins!");
				else
					System.out.println("Stalemate.");
		//	playAgain = JOptionPane.showConfirmDialog(null, "Would you like to play again?", "Answer", JOptionPane.YES_NO_OPTION);
		//}while(playAgain == JOptionPane.YES_OPTION);
	}
	
}
