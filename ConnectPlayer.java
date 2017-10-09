
public abstract class ConnectPlayer {
	protected char piece;
	protected Connect4Grid2DArray grid;
	public abstract char getPiece();
	public abstract void makeMove(Integer column);
	public abstract boolean winner();
	public void makeMove() {
		// TODO Auto-generated method stub
		
	}
}
