
public abstract class Ship {

	  private int length = 1;
	  private boolean isHorizontal = true;
	  private int x;
	  private int y;
	  private int holeRemaining=1;
	  private String name=null;
	  
	  public Ship(int x, int y, int length, String name, boolean horizontal)
	  {
	    if (length > 0)
	    {
	      this.length = length;
	      this.holeRemaining=length;
	    }
	  
	    this.isHorizontal = horizontal;
	    this.x = x;
	    this.y = y;
	    this.name=name;
	    
	  }
	  public int shipLength() {
		  return this.length;
	  }
	  public int holeRemainingCount() {
		  return holeRemaining;
		  
	  }
	  public void DecreaseHoleCount() {
		  holeRemaining--;
	  }
	  
	  public int getX(){
		return x; 
	  }
	  public int getY(){
		  return y;
	  }
	  public String shipName(){
		  
		  return name;
	  }
	  
	  public Boolean isHorizontal () {
		  
		  return isHorizontal;
	  }
}
