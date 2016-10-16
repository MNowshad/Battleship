import java.util.Scanner;

public class BattleshipGame {
     
	public static void main(String[] args) {
		
		gameBattle();

	}
	
	public static void gameBattle() {
		
		Scanner in = new Scanner (System.in);
		System.out.println("Welcome to the Battleship Game");
		System.out.println("Enter the board size");
		int size =in.nextInt();
		System.out.println("Enter number of ship ");
		int numOfShip =in.nextInt();
		in.nextLine();
		System.out.println("Enter first player's Name");
		String player1= in.nextLine();
		Player p1 = new Player(player1,size,numOfShip);
		p1.startGame(in);
		
		System.out.println("Enter Second player's Name");
		String player2= in.nextLine();
		Player p2 = new Player(player2,size,numOfShip);
		
		p2.startGame(in);
		
		
		while(true) {
			Boolean res1=false;
			while(!res1){
				System.out.println(player1 + " : move : i.e A1/B2/C1 ");
				String pos1 = in.next();
				res1=p2.gameSteps(pos1);
				if(!res1) System.out.println("Wrong position entered");
				
		}
			
			if(p2.fleetSize()<=0) {
				System.out.println(player1 + " has won the game !");
			    break;	
			}
			Boolean res2=false;
			while(!res2) {
				System.out.println(player2 + " : move : i.e A1/B2/C1 ");
				String pos2= in.next();
				res2=p1.gameSteps(pos2);
				if(!res2) System.out.println("Wrong position entered");
			}
			
			if(p1.fleetSize()<=0) {
				System.out.println(player2 + "  has won the game !");
			    break;	
			}
		
			
		}
	    in.close();
	}
	

}

