

public class Cruiser extends Ship {
	  private static String name = "Cruiser";
	  private static int length=3;
	  public Cruiser(int x, int y, boolean horizontal)
	  {
		  //int x, int y, int length, String name, boolean horizontal
	    super(x, y, length,name, horizontal);
	  }
}
