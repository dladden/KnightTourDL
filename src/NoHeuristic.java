//imports
import java.util.*;

/*
 * This Class will do all the heavylifting, using the Knight class it will randomise a starting point and the direction
 * and move the knight. 
 * 
 * @author Denys Ladden
 * @version Sep 4, 2019
 * Knight Tour Project
 * Fall 2019
 */
public class NoHeuristic{

	Knight KnightObj = new Knight();//Instentiating the Knight object
	
	Random rand = new Random();

	private int moves = 0;//counter
	private int grid [][] = new int [8][8]; 
	ArrayList <String> tourRuns = new ArrayList <String>();//will store the values for the cordinats and movements
	
	boolean SwitchOff[] = new boolean[8];//will contain the 
	boolean halt = false;//Will indicate if the knight stopped
	
	private int d1;
	private int d2;
	
	/*
	 * A NoHeuristic constroctor
	 */
	public NoHeuristic() {//
		newTour();
	}//end constructor
	/*
	 * SwitchOff checks if the knight cannot move
	 */
	public boolean checkSwitchOff() {
		
		boolean halt = false;
		for(int i = 0; i < 8; i++) {
			if(SwitchOff[i] == true) {
				
			}
		else {
			halt = true;
			
		}
		
	}//end for
		return halt;
}//end checkSwitchOff
	
	/*
	 * Sets switchoff to true
	 */
	public void setSwitchOff(int s) {
		
		SwitchOff[s] = true;
	}//setSwitch
		
	/*
	 * resets switchoff to false
	 */
	public void resetSwitchOff() {
		for(int i = 0; i < 8; i++) {
			SwitchOff[i] = false;
		}
		
	}//end resetSwitch
	
	/*
	 * Setting up the 8 moves that the knight able to move from
	 */
	public void direction(int d) {
		d1 = 0;
		d2 = 0;
		
		switch(d) {
		
		case 0:
			d1+=1;
			d2+=2;
			setSwitchOff(d);
		break;
		case 1:
			d1+=2;
			d2+=1;
			setSwitchOff(d);
		break;
		case 2:
			d1+=1;
			d2-=2;
			setSwitchOff(d);
		break;
		case 3:
			d1+=2;
			d1-=1;
			setSwitchOff(d);
		break;
		case 4:
			d1-=1;
			d2-=2;
			setSwitchOff(d);
		break;
		case 5:
			d1-=2;
			d2-=1;
			setSwitchOff(d);
		break;
		case 6:
			d1-=1;
			d2+=2;
			setSwitchOff(d);
		case 7:
			d1-=2;
			d2+=1;
			
			setSwitchOff(d);
			break;
		
		}//end switch stement	
		
	}//end direction
	
	/*
	 * the reset method will tkae the matrix of the two dimnesional array and
	 * using a nested for loop will from outer loop (x) move down the rows of matrix, 
	 * and the inner loop (y) moves along each row setting values to 0 in the arrays.
	 */
	public void resetGrid() {
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				grid [x] [y] = 0;
			}
		}//end grid reset
		
		resetSwitchOff();
	}//end RESET
	
	/*
	 * This method will do most of the work, It will choose form the 8 cases of whoch move to make
	 * and then test the position for available space and store the data in the array
	 */
	public void move() {
		int d = rand.nextInt(8);
		direction(d);
			if((KnightObj.getX()+d1) >= 0 && (KnightObj.getX()+d1)<= 7 
					&& (KnightObj.getY()+d2) >= 0 && (KnightObj.getY()+d2) <= 7
							&& (grid[KnightObj.getX()+d1][KnightObj.getY()+d2]) == 0){
				moves++;//if
				grid[KnightObj.getX()+d1][KnightObj.getY()+d2] = moves;
				KnightObj.setX(KnightObj.getX()+d1);
				KnightObj.setY(KnightObj.getY()+d2);
				
				resetSwitchOff();
			}else if(checkSwitchOff() == false) {
				
				tourRuns.add(", "+moves);
				tourRuns.add(", ["+KnightObj.getX()+ ","+KnightObj.getY()+"]");
				tourEnd();
				moves = 64;//
				halt = true;
			}//end else if 
			else {
			move();
			}

	}//end move
	
	
	
	/*
	 * New tour will reset the grid randomise the position and store the position in array
	 * as long as the moves dont reach 64 moves it will run the move method above
	 */
	public void newTour() {
		halt = false;//
		resetGrid();
		
		KnightObj.randPosition();
		tourRuns.add("["+KnightObj.getX()+","+KnightObj.getY()+"]");
		moves = 0;
			while(moves != 64) {//Continuosly checks if the moves are not at 64 
				move();			//exceute the code if not 
			}
		if(halt == false) {
			
			fullTour();
			
		}
	}//end newGame
	
	/*
	 * print out for ended tour 
	 */
	public void tourEnd() {
		
		for(String list : tourRuns) {//reiderates through the array tourRuns 
			System.out.print(list);  //and out puts it 
			
		}//for
		
		System.out.println();
		tourRuns = new ArrayList <String>();//
	}//tour end 
	
	/*
	 * print out for a complete version of the tour
	 */
    public void fullTour() {
		
    	tourRuns.add(", "+moves);
    	tourRuns.add(", ["+KnightObj.getX()+","+KnightObj.getY()+"]*");
    	
    	for(String list : tourRuns) {
    		System.out.print(list);
    	}
    	
    	System.out.println();
		tourRuns = new ArrayList <String>();//
	}//end FUll Tour
		
	
	
}//end class
