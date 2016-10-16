
public class Destroyer extends Ship {
	  private static String name = "Destroyer";
	  private static int length=2;
	  public Destroyer(int x, int y, boolean horizontal)
	  {
		  //int x, int y, int length, String name, boolean horizontal
	    super(x, y, length,name, horizontal);
	  }
}