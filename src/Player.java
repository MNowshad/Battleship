
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
 
	private  String playerName =null;
	private  int boardSize=0;
	private  char [][] board; 
	private  List<Ship> fleet;
	private  int numOfShip=0;
	
	public Player (String name, int size, int numOfShip ) {
	 playerName=name;
	 boardSize=size;
	 board = new char[size][size];
	 this.numOfShip=numOfShip;
	 fleet = new ArrayList<Ship>();
	 
	}
	
	public void startGame(Scanner in) {
		Board bd = new Board(board,playerName);
		bd.initializeBoard();
		Fleet ft = new Fleet(numOfShip,board,fleet);
		makeFleet(ft,in);
		bd.displayBoard();
		
		
	}
 
	public void makeFleet(Fleet ft, Scanner in){
		System.out.println("Prepare your fleet"); 
		Board bd = new Board(board,playerName);
		while(numOfShip>0){
			System.out.println("Add ship: Enter ship# (1-AirCarrier, 2-Battleship, 3-Cruiser,4-Submarine, 5-Destroyer), position (A1/B2), ishorizontal (true/false)"); 
			int shipSerial= in.nextInt();
			String pos = in.next();
			Boolean isHorizontal = in.nextBoolean(); 
			if(ft.addShip(shipSerial, pos, isHorizontal)) {
				numOfShip--;
			}
			System.out.println("Current board position");
			bd.displayBoard();
		}
		in.nextLine();
		
		
	}
	
	public boolean gameSteps(String pos) {
		char c=pos.toUpperCase().charAt(0);
		int x= (c-65)>0? c-65 : 0 ;
		int y= Integer.parseInt(pos.substring(1))-1;
		
		if (!(x>=0 && x<board.length && y>=0 && y<board.length)) return false;
		
		Board bd =new Board (board,playerName);
		char res =bd.printGuessResult(x,y);
		Fleet ft = new Fleet(board,fleet);
		
		switch(res) {
		case '-' :
			System.out.println("Guess Output : Miss");
			
			break;
		case 'X':
		case 'o' :
			System.out.println("Guess Output : Already Taken");
			break;
		default :
			String shipName= ft.getShipName(res);
			Ship sh = ft.getShip(shipName, x, y);
			sh.DecreaseHoleCount();
			if(sh.holeRemainingCount()<=0) 
			{
				fleet.remove(sh);
				System.out.println("Guess output: Sunk, Shipname : " + shipName);
			}
			else {
				System.out.println("Guess Output :Hit ,Shipname : " + shipName );
			}
	
	}
		return true;
}
	public int fleetSize () {
		
		return fleet.size();
	}
	


	
	
}
