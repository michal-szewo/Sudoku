import java.util.Arrays;

public class Verify {
	
	static int N = 9;
	 
	//sprawdzamy, czy liczby w zasiegu
	public static boolean isInRange(Integer[][] board)
	{
	     
	    
	    for(int i = 0; i < N; i++)
	    {
	        for(int j = 0; j < N; j++)
	        {
	             
	           
	            if (board[i][j] <= 0 ||
	                board[i][j] > 9)
	            {
	               
	            	return false;
	            }
	        }
	    }
	    return true;
	}
	
	// walidacja wypelnionej planszy
	public static boolean isValidSudoku(Integer[][] board)
	{
	     
	   
	    if (isInRange(board) == false)
	    {
	        return false;
	    }
	 
	    // Tablica dla unikatowych wartosci
	    // od 1 do N
	    boolean[] unique = new boolean[N+1];
	 
	    // Weryfikacja horyzontalna
	    for(int i = 0; i < N; i++)
	    {

	        Arrays.fill(unique, false);

	        for(int j = 0; j < N; j++)
	        {
	            
	            int Z = board[i][j];
	 
	            
	            if (unique[Z])
	            {
	                return false;
	            }
	            unique[Z] = true;
	        }
	    }
	 
	    // Weryfikacja w pionie 
	    for(int i = 0; i < N; i++)
	    {
	       
	        Arrays.fill(unique, false);
	 
	        // przejscie przez wszystkie wiersze kolumny
	        for(int j = 0; j < N; j++)
	        {
	             
	            
	            int Z = board[j][i];
	 
	            
	            if (unique[Z])
	            {
	                return false;
	            }
	            unique[Z] = true;
	        }
	    }
	 
	    // Weryfikacja blokowa
	    // size 3 * 3 in board[][] array
	    for(int i = 0; i < N - 2; i += 3)
	    {
	         
	        // j to pierwsza kolumna kazdego bloku 3x3

	        for(int j = 0; j < N - 2; j += 3)
	        {
	             
	           
	            Arrays.fill(unique, false);
	 
	            // Przejdz przez biezacy blok
	            for(int k = 0; k < 3; k++)
	            {
	                for(int l = 0; l < 3; l++)
	                {
	                     
	                    // Numer wiersza biezacego bloku
	                    int X = i + k;
	 
	                    // Numer kolumny biezacego bloku
	                    int Y = j + l;
	 
	                    int Z = board[X][Y];
	                 
	                    if (unique[Z])
	                    {
	                        return false;
	                    }
	                    unique[Z] = true;
	                }
	            }
	        }
	    }
	 
	    // jesli wszystko ok
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
    System.out.println(isValidSudoku(f2));
}
}
