//imports:

/*
 * Main class will have a loot which will test noheuristic and heuristic classes 
 * 
 * @author Denys Ladden
 * @version Sep 4, 2019
 * Knight Tour Project
 * Fall 2019
 */
public class Application {

	public static void main(String[] args) {
		
		/*
		 * Instantiate Noheuristic object Test and runs a for loop 
		 */
		NoHeuristic Test = new NoHeuristic();
		for(int i =0; i<1000; i++) {
			Test = new NoHeuristic();
		
		}//end for
		/*
		 * Instantiate Heuristic object Test and prints it
		 */
		System.out.println();
		Heuristic TestHeuristic = new Heuristic();
		System.out.println();
		
		
		
	}//end main

}//end calss
