import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SudokuModel {
	 Integer[][] f = {{4,2,9,8,1,null,5,6,7}, {5,1,6,4,7,2,9,3,8}, {7,8,3,6,5,9,2,4,1},
             {6,7,2,1,null,4,8,5,9}, {3,9,5,2,8,6,1,null,4}, {8,4,1,7,9,5,6,2,3}, 
             {1,5,8,3,6,7,4,9,2}, {9,3,4,5,2,8,7,1,6}, {2,6,7,9,4,1,3,8,5}};
	 Integer[][] f1 = {{null,2,9,8,1,3,5,6,7}, {5,1,6,4,7,2,9,3,8}, {7,8,3,6,5,9,2,4,1},
             {6,7,2,1,3,4,8,5,9}, {3,9,5,2,8,6,1,7,4}, {8,4,1,7,9,5,6,2,null}, 
             {1,5,8,3,6,7,4,9,2}, {9,3,4,5,2,8,7,1,6}, {2,6,7,9,4,1,3,8,5}};
	 Integer[][] f2 = {{4,2,9,8,1,3,5,6,7}, {5,1,6,4,7,2,9,3,8}, {7,8,3,6,5,9,2,4,1},
             {6,7,2,1,3,4,8,5,9}, {3,9,5,2,8,6,1,7,4}, {8,4,1,7,9,5,6,2,3}, 
             {1,5,8,3,null,7,4,9,2}, {9,3,4,5,2,8,7,1,6}, {2,6,7,9,4,1,3,8,5}};
	ArrayList<Integer[][]> merged = new ArrayList<>();
	
	 
	
	
}
