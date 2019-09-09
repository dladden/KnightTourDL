//imports
import java.util.*;

/*
 * A Heuristic class which will choose a lowest accesibility position on the grid to increase chances of 
 * full tour run, while continuosly reduce accesabilty of vistied squares, and print results. 
 * 
 * @author Denys Ladden
 * @version Sep 4, 2019
 * Knight Tour Project
 * Fall 2019
 */
public class Heuristic {
	
	Knight KnightObj = new Knight();//Instentiating the Knight object
	
	Random rand = new Random();

	ArrayList <Integer> accesibilityNumber = new ArrayList <Integer>();
	private int moves = 0;//counter
	private int grid [][] = new int [8][8]; //tow dimensional aray used as a grid
	ArrayList <String> tourRuns = new ArrayList <String>();
	
	boolean SwitchOff[] = new boolean[8];//will contain the 
	boolean halt = false;//Will indicate if the knight stopped
	
	private int d1;//x direction1
	private int d2;//y direction2 
	
	/*
	 * Heuristic Constructor
	 */
	public Heuristic() {//
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				
				newTour();
			}
		}
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
	 * Direction Accesibility will check if the 8 directions are available
	 */
	public void directionAccesibility() {
		accesibilityNumber = new ArrayList <Integer>();
		for(int d = 0; d < 8; d++) {
			direction(d);	
			if((KnightObj.getX()+d1) >= 0 && (KnightObj.getX()+d1)<= 7 
					&& (KnightObj.getY()+d2) >= 0 && (KnightObj.getY()+d2) <= 7
							&& (grid[KnightObj.getX()+d1][KnightObj.getY()+d2]) == 0){
				accesibilityNumber.add(d);
			
			}//end if
			else {
				setSwitchOff(d);
			}
			
		}//end for
		if(checkSwitchOff() == false) {
			
			tourRuns.add(", "+moves);
			tourRuns.add(", ["+KnightObj.getX()+ ","+KnightObj.getY()+"]");
			tourEnd();
			moves = 64;//
			halt = true;
		}//end if
		
		
	}//end directionAccesibility!
	
	/*
	 * 
	 */
	public void resetGrid() {
		for(int x=0; x<8; x++) {
			for(int y=0; y<8; y++) {
				grid[x][y] = 0;
			}//end for
		
			}for(int x=2; x<6; x++) {
				for(int y=2; y<6; y++) {
					grid[x][y] = 8;
				}
			}//end for
		
		}//end reset
	
	/*
	 * This method will do most of the work, It will choose form the 8 cases of whoch move to make
	 * and then test the position for available space and store the data in the array
	 */
	public void move() {
	
	directionAccesibility();
		if(checkSwitchOff() == true) {
			int d = rand.nextInt(accesibilityNumber.size());
			direction(accesibilityNumber.get(d));
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
	
	
	
	
}//end CLASS
