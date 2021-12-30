import java.util.Arrays;

public class Verify {
	
	static int N = 9;
	 
	// Function to check if all elements
	// of the board[][] array store
	// value in the range[1, 9]
	public static boolean isInRange(Integer[][] board)
	{
	     
	    // Traverse board[][] array
	    for(int i = 0; i < N; i++)
	    {
	        for(int j = 0; j < N; j++)
	        {
	             
	            // Check if board[i][j]
	            // lies in the range
	            if (board[i][j] <= 0 ||
	                board[i][j] > 9)
	            {
	               
	            	return false;
	            }
	        }
	    }
	    return true;
	}
	
	// Function to check if the solution
	// of sudoku puzzle is valid or not
	public static boolean isValidSudoku(Integer board[][])
	{
	     
	    // Check if all elements of board[][]
	    // stores value in the range[1, 9]
	    if (isInRange(board) == false)
	    {
	        return false;
	    }
	 
	    // Stores unique value
	    // from 1 to N
	    boolean[] unique = new boolean[N + 1];
	 
	    // Traverse each row of
	    // the given array
	    for(int i = 0; i < N; i++)
	    {
	         
	        // Initialize unique[]
	        // array to false
	        Arrays.fill(unique, false);
	 
	        // Traverse each column
	        // of current row
	        for(int j = 0; j < N; j++)
	        {
	             
	            // Stores the value
	            // of board[i][j]
	            int Z = board[i][j];
	 
	            // Check if current row
	            // stores duplicate value
	            if (unique[Z])
	            {
	                return false;
	            }
	            unique[Z] = true;
	        }
	    }
	 
	    // Traverse each column of
	    // the given array
	    for(int i = 0; i < N; i++)
	    {
	         
	        // Initialize unique[]
	        // array to false
	        Arrays.fill(unique, false);
	 
	        // Traverse each row
	        // of current column
	        for(int j = 0; j < N; j++)
	        {
	             
	            // Stores the value
	            // of board[j][i]
	            int Z = board[j][i];
	 
	            // Check if current column
	            // stores duplicate value
	            if (unique[Z])
	            {
	                return false;
	            }
	            unique[Z] = true;
	        }
	    }
	 
	    // Traverse each block of
	    // size 3 * 3 in board[][] array
	    for(int i = 0; i < N - 2; i += 3)
	    {
	         
	        // j stores first column of
	        // each 3 * 3 block
	        for(int j = 0; j < N - 2; j += 3)
	        {
	             
	            // Initialize unique[]
	            // array to false
	            Arrays.fill(unique, false);
	 
	            // Traverse current block
	            for(int k = 0; k < 3; k++)
	            {
	                for(int l = 0; l < 3; l++)
	                {
	                     
	                    // Stores row number
	                    // of current block
	                    int X = i + k;
	 
	                    // Stores column number
	                    // of current block
	                    int Y = j + l;
	 
	                    // Stores the value
	                    // of board[X][Y]
	                    int Z = board[X][Y];
	 
	                    // Check if current block
	                    // stores duplicate value
	                    if (unique[Z])
	                    {
	                        return false;
	                    }
	                    unique[Z] = true;
	                }
	            }
	        }
	    }
	 
	    // If all conditions satisfied
	    return true;
	}
	
	
	/* Alternatywny sposób
	 * public static boolean sudokuCheck(int[][] s) { // row checker for(int row =
	 * 0; row < 9; row++) for(int col = 0; col < 8; col++) for(int col2 = col + 1;
	 * col2 < 9; col2++) if(s[row][col]==s[row][col2]) return false;
	 * 
	 * // column checker for(int col = 0; col < 9; col++) for(int row = 0; row < 8;
	 * row++) for(int row2 = row + 1; row2 < 9; row2++)
	 * if(s[row][col]==s[row2][col]) return false;
	 * 
	 * // grid checker for(int row = 0; row < 9; row += 3) for(int col = 0; col < 9;
	 * col += 3) // row, col is start of the 3 by 3 grid for(int pos = 0; pos < 8;
	 * pos++) for(int pos2 = pos + 1; pos2 < 9; pos2++) if(s[row + pos%3][col +
	 * pos/3]==s[row + pos2%3][col + pos2/3]) return false;
	 * 
	 * return true; }
	 */
	
	


public static void main(String[] args) throws Exception {
    Integer[][] f = {{4,2,9,8,1,3,5,6,7}, {5,1,6,4,7,2,9,3,8}, {7,8,3,6,5,9,2,4,1},
                 {6,7,2,1,3,4,8,5,9}, {3,9,5,2,8,6,1,7,4}, {8,4,1,7,9,5,6,2,3}, 
                 {1,5,8,3,6,7,4,9,2}, {9,3,4,5,2,8,7,1,6}, {2,6,7,9,4,1,3,8,5}};
    Integer[][] f1 = {{4,2,7,8,1,3,5,6,7}, {5,1,6,4,7,2,9,3,8}, {7,8,3,6,5,9,2,4,1},
            {6,7,2,1,3,4,8,5,9}, {3,9,5,2,8,6,1,7,4}, {8,4,1,7,9,5,6,2,3}, 
            {1,5,8,3,6,7,4,9,2}, {9,3,4,5,2,8,7,1,6}, {2,6,7,9,4,1,3,8,5}};
    Integer[][] f2 = {{4,2,9,null,1,3,5,6,7}, {5,1,6,4,7,2,9,3,8}, {7,8,3,6,5,9,2,4,1},
            {6,7,2,1,3,4,8,5,9}, {3,9,5,2,8,6,1,7,4}, {8,4,1,7,9,5,6,2,3}, 
            {1,5,8,3,6,7,4,9,2}, {9,3,4,5,2,8,7,1,6}, {2,6,7,9,4,1,3,8,5}};
  
    //System.out.println(sudokuCheck(f));
    //System.out.println(sudokuCheck(f1));
    System.out.println(isValidSudoku(f));
    System.out.println(isValidSudoku(f1));
    System.out.println(isValidSudoku(f1));
}
}
