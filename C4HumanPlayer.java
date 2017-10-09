
public class C4HumanPlayer extends ConnectPlayer {
	public C4HumanPlayer(Connect4Grid2DArray grid, char piece)
	{
		this.grid = grid;
		this.piece = piece;
	}
	public char getPiece() {
		
		return this.piece;
	}

	
	public boolean winner() {
		if(grid.didLastPieceConnect4(this.piece))
			return true;
		return false;
	}
	public void makeMove(Integer column) {
		grid.dropPiece(this, column);
		
	}

}
