
public class Connect4Grid2DArray implements Connect4Grid{
	private static char[][] grid;
	//grid[row][column]
	private final int HOWMANYTOWIN = 4;
	public Connect4Grid2DArray()
	{
		grid = new char[ROWSIZE][COLUMNSIZE];
	}
	public void emptyGrid() {
		for(int i = 0; i < ROWSIZE; i++)
		{
			for(int j = 0; j < COLUMNSIZE; j++)
			{
				grid[i][j] = EMPTY;
			}
		}
	}
	
	public String toString(){
		for(int row = 0; row < ROWSIZE; row++)
		{
			for(int column = 0; column < COLUMNSIZE; column++)
			{
				System.out.print(" | " + grid[row][column]);
			}
			System.out.print(" |");
			System.out.println("");
			//prints out lines separating rows
			System.out.println("-------------------------------");
		}
		System.out.println("   1   2   3   4   5   6   7");
		return null;
	}

	public boolean isValidColumn(Integer column) {
		if(column < COLUMNSIZE && column >= 0)
		{
			return true;
		}
		return false;
	}

	public boolean isColumnFull(Integer column) {
		if(grid[0][column] != EMPTY)
			return true;
		
		return false;
	}

	public void dropPiece(ConnectPlayer player, Integer column) {
		if(isValidColumn(column) && !isColumnFull(column))
		{
			int row = ROWSIZE - 1;
			while(grid[row][column] != EMPTY)
			{
				row--;
			}
			grid[row][column] = player.getPiece();
		}
		
	}

	public boolean didLastPieceConnect4(char lastPiece) { //not as per spec
		if(connectVertically(HOWMANYTOWIN, lastPiece) || connectHorizontally(HOWMANYTOWIN, lastPiece) || 
				connectDiagonallyLeftRight(HOWMANYTOWIN, lastPiece) || connectDiagonallyRightLeft(HOWMANYTOWIN, lastPiece))
			return true;
		return false;
	}
	public boolean connectVertically(int howMany, char lastPiece)
	{
		int connected = 0;
		for(int col = 0; col < COLUMNSIZE; col++)
		{
			for(int row = 0; row < ROWSIZE; row++)
			{
				if(grid[row][col] == lastPiece)
				{
					connected++;
				}
				else
				{
					connected = 0;
				}
				if(connected == howMany)
					return true;
			}
		}
		return false;
	}
	public boolean connectHorizontally(int howMany, char lastPiece)
	{
		int connected = 0;
		for(int row = 0; row < ROWSIZE; row++)
		{
			for(int col = 0; col < COLUMNSIZE; col++)
			{
				if(grid[row][col] == lastPiece)
				{
					connected++;
				}
				else
				{
					connected = 0;
				}
				if(connected == howMany)
					return true;
			}
		}
		return false;
	}
	public boolean connectDiagonallyLeftRight(int howMany, char lastPiece) //draw out
	{
		//checks diagonally from left to right
		int connected = 0;
		int checkRow;
		int checkCol;
		//checks until hits bottom row
		for(int row = howMany - 1; row < ROWSIZE; row++)	//starts at howMany - 1 as cannot connect at least diagonally howMany otherwise
		{
			checkCol = 0;
			for(checkRow = row; checkRow >= 0 && checkCol <= COLUMNSIZE - 1; checkRow--)
			{
				if(grid[checkRow][checkCol] == lastPiece)
					connected++;
				else
					connected = 0;
				checkCol++;
				if(connected == howMany)
					return true;
			}
		}
		//checks after hit bottom row
		for(checkCol = 0; checkCol <= COLUMNSIZE - howMany; checkCol++) //***************
		{
			checkRow = ROWSIZE - 1;
			for(int col = checkCol; col <= COLUMNSIZE - 1 && checkRow >= 0; col = col + 1)
			{
				if(grid[checkRow][col] == lastPiece)
					connected++;
				else
					connected = 0;
				checkRow--;
				if(connected == howMany)
					return true;
			}
		}
		return false;
	}
	public boolean connectDiagonallyRightLeft(int howMany, char lastPiece)
	{
		int connected = 0;
		int checkRow;
		int checkCol;
		//checks until hits bottom row
		for(int row = howMany - 1; row < ROWSIZE; row++)		//starts at howMany - 1 as cannot connect howMany diagonally otherwise
		{
			checkCol = COLUMNSIZE - 1;
			for(checkRow = row; checkRow >= 0 && checkCol >= 0; checkRow--)
			{
				if(grid[checkRow][checkCol] == lastPiece)
					connected++;
				else
					connected = 0;
				checkCol--;
				if(connected == howMany)
					return true;
			}
		}
		//checks after hit bottom row
		for(checkCol = COLUMNSIZE - 1; checkCol >= howMany - 1; checkCol--) //***************
		{
			checkRow = ROWSIZE - 1;
			for(int col = checkCol; col >= 0 && checkRow >= 0; col = col - 1)
			{
				if(grid[checkRow][col] == lastPiece)
					connected++;
				else
					connected = 0;
				checkRow--;
				if(connected == howMany)
					return true;
			}
		}
		return false;
	}
	//how many connected 4,3,2 - how many same pieces are next to each other, diagonally, vertically etc
	//did last piece connect 3
	//search for pieces

	public boolean isGridFull() {
		for(int i = 0; i < ROWSIZE; i++)
		{
			for(int j = 0; j < COLUMNSIZE; j++)
			{
				if(grid[i][j] == EMPTY)
					return false;
			}
		}
		return true;
	}
	public int returnRowSize()
	{
		return ROWSIZE;
	}

}
