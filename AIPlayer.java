import java.util.Random;
public class AIPlayer extends ConnectPlayer {
	private Connect4Grid2DArray grid;
	public AIPlayer(Connect4Grid2DArray grid, char piece)
	{
		this.grid = grid;
		this.piece = piece;
	}
	
	public char getPiece() {
		return this.piece;
	}

	@Override
	public void makeMove() {
		Random randomGenerator = new Random();
		int column = 0;
		do
		{
			column = randomGenerator.nextInt(grid.returnRowSize() + 1);
		}while(grid.isColumnFull(column));
		grid.dropPiece(this, column);
	}

	@Override
	public boolean winner() {
		if(grid.didLastPieceConnect4(this.piece))
			return true;
		return false;
	}

	@Override
	public void makeMove(Integer column) {
		// TODO Auto-generated method stub
		
	}

}
