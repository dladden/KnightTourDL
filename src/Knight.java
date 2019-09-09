//imports
import java.util.*;
/*
 * This class will represent a knight and will reandomise its position on the two dimansional array so
 * the starting point is random everytime. It will aslo have the setters and getters.
 * 
 * @author Denys Ladden
 * @version Sep 4, 2019
 * Knight Tour Project
 * Fall 2019
 */
public class Knight {

	Random rand = new Random();//generating Random Object 
	//position of the knight
	private int x;
	private int y;
	
	public Knight(int new_x, int new_y) {
		
		x = new_x;
		y = new_y;
		
	}//end constructor
	
	public Knight() {
	
		randPosition();// TODO Auto-generated constructor stub
	}

	public void randPosition() {//randomise position
		
	y = rand.nextInt(8);
	x = rand.nextInt(8);
}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Knight [rand=" + rand + ", x=" + x + ", y=" + y + "]";
	}
	
	
	
}//end class
