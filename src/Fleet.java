
import java.util.List;

public class Fleet {
	private  List<Ship> fleet;
	private  char [][] board;
	private  int numOfShip=0;
	public Fleet (int numOfShip, char[][] board,List<Ship> fleet) {
		this.numOfShip=numOfShip;
		this.fleet =fleet;
		this.board=board;
	}
	public Fleet ( char[][] board,List<Ship> fleet) {
		
		this.fleet =fleet;
		this.board=board;
	}
	public boolean addShip(int shipSerial, String pos, boolean isHorizontal ) {
		
		char c=pos.toUpperCase().charAt(0);
		int x= (c-65)>0? c-65 : 0 ;
		int y= Integer.parseInt(pos.substring(1))-1;
		char ch='-';
		int len =0;
		 
		if(this.fleet.size()<numOfShip) {
			Ship sp= null ;
			switch(shipSerial) {
			case 1 : 
				sp = new AirCarrier(x,y,isHorizontal);
				ch='A';
				
				break;
			case 2 :
				sp= new Battleship(x, y, isHorizontal);
				ch='B';
				
				break;
			case 3:
				sp = new Cruiser(x,y,isHorizontal);
				ch='C';
				break;
			case 4:
				sp=new Submarine(x, y, isHorizontal);
				ch='S';
				break;
			case 5: 
				sp=new Destroyer(x, y, isHorizontal);
				ch='D';
				break;
			default:
				
				System.out.println("Wrong Ship serial selected");
			
			}
			len = sp.shipLength();
			if(sp!=null && checkOverFlow(x,y,len, isHorizontal) && !isOccupied(x,y,len,isHorizontal)){
				fleet.add(sp);
				setShipPostion(x, y, sp.shipLength(),ch, isHorizontal);
			}
			else {
				System.out.println("Overlap/overflow exist with the position");
				return false;
			}
			
			
		}
		else {
			System.out.println("Maximum number of ship already added");
		}
		return true;
		
	}
	public boolean checkOverFlow (int x, int y,int len, boolean isHorizontal) {
		int X1=x;
		int X2=x;
		int Y1=y;
		int Y2=y;
		if(isHorizontal) {
			Y2=len+Y1-1;
		}
		else {
			X2=len+X1-1;
		}
		if((X1>=0 && X2< board.length) && (Y1>=0 && Y2<board.length) )
			return true;
		else return false;
		
	}
	public boolean isOccupied (int x, int y,int len, boolean isHorizontal) {
		int X1=x;
		int X2=x;
		int Y1=y;
		int Y2=y;
		if(isHorizontal) {
			Y2=len+Y1-1;
		}
		else {
			X2=len+X1-1;
		}
		Board bd = new Board(board);
		for (int i=X1;i<=X2;i++)
			for (int j=Y1;j<=Y2;j++)
			{
				char ch= bd.getBoardPosition(i, j);
				if(ch !='-') return true;
			}
		return false;
	}
	public void setShipPostion(int x, int y, int len, char ch, boolean isHorizontal) {
		
		if(isHorizontal)
		{
		 for(int i=0;i<len;i++)
			 board[x][y+i]=ch;
		}
		else {
			for(int i=0;i<len;i++)
				 board[x+i][y]=ch;
		}
		
	}
	
	public Ship getShip(String name, int x, int y) {
		Ship res =null;
		int X1;
		int X2;
		int Y1;
		int Y2;
		
		
		for (Ship sp: fleet) {
		   X1 = sp.getX();
		   Y1=sp.getY();
		   X2=X1;
		   Y2=Y1;
			int l = sp.shipLength();
			boolean isHorizontal= sp.isHorizontal();
			if(isHorizontal) {
				Y2= sp.getY()+l;
			}
			else {
				X2=sp.getX() +l;
			}
			if(sp.shipName().equals(name) && (x>=X1 && x<=X2)  && (y>=Y1 && y<=Y2) )
			{   res=sp;
				break;
			}
			
		}
		return res;
		
	}
	public String getShipName(char c) {
		String res=null;
		switch(c){
		case 'A' :
			res="AirCarrier";
			break;
		case 'B' :
			res="Battleship";
			break;
		case 'C' :
			res = "Cruiser";
			break;
		case 'D' :
			res ="Destroyer";
			break;
		case 'S':
		    res = "Submarine";
		    break;
		}
		return res;
	}

	
	
}
