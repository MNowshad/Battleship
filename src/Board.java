
public class Board {
  private  char [][] board;
  private  int boardSize;
  private  String playerName;

  public Board (char[][] board,String playerName) {
	  this.board=board;
	  this.boardSize=board.length;
	  this.playerName=playerName;
  }
  public Board (char[][] board) {
	  this.board=board;
	  this.boardSize=board.length;
	  
  }
	public void initializeBoard() {
		for(int i=0;i<boardSize;i++)
			for(int j=0;j<boardSize;j++) {
				board[i][j]='-';
				
			}
	}
	public char printGuessResult(int x, int y) {
		
		char c = getBoardPosition(x,y);
		switch(c) {
		case '-' :
			setBoardPosition( x,  y,'o');
			break;
		case 'X':
		case 'o' : 
			break;
		default:
			setBoardPosition(x,y, 'X');
			
			
		}
		return c;
		
	}
	public void displayBoard() {
		System.out.println(playerName +"'s Board : " + "\n");
		for(int i=0;i<boardSize;i++)
		{
			for(int j=0;j<boardSize;j++)
				
			{
				System.out.print(board[i][j] + "\t");
			}
			System.out.println();
		}
	} 

	public char getBoardPosition(int x, int y) {
		
		return board[x][y];
	} 
	public void setBoardPosition(int x, int y,char ch) {
		
		 board[x][y]=ch;
	} 
 
}
