
public interface Connect4Grid {
	public final int COLUMNSIZE = 7;
	public final int ROWSIZE = 6;
	public final char EMPTY = ' ';
	public final char RED = 'X';
	public final char YELLOW = 'O';
	public void emptyGrid();
	public String toString();
	public boolean isValidColumn(Integer column);
	public boolean isColumnFull(Integer column);
	public void dropPiece(ConnectPlayer player, Integer column);
	public boolean didLastPieceConnect4(char lastPiece);		//not as per spec
	public boolean isGridFull();
}
