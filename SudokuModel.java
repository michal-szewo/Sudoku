import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SudokuModel {
	private Integer[][] board;
	public static final int N = 9;
	//private ArrayList<int[]> invalidFields = null;
	private boolean[][] invalidFields = new boolean[N][N];
	private static int initBoardCounter = 0;
	
	
	public SudokuModel() {
		board = initiateBoard();
		for(int i = 0; i < N; i++)
		    {
		        for(int j = 0; j < N; j++)
		        {
		        	invalidFields[i][j] = false;
		        }
		    }
	}
	
	
	
	public Integer[][] initiateBoard(){  
		Integer[][] f = {{4,2,null,8,1,null,5,6,7}, {5,null,6,4,7,2,null,3,8}, {7,null,3,6,5,null,2,null,1},
             {6,7,2,1,null,4,8,5,9}, {null,9,5,2,8,6,1,null,4}, {8,4,1,7,9,null,6,2,3}, 
             {1,null,8,3,6,7,4,9,2}, {9,3,4,null,null,8,null,1,6}, {null,6,7,9,4,1,3,8,null}};
		Integer[][] f1 = {{null,2,9,8,1,3,5,6,7}, {5,1,6,4,7,2,9,3,8}, {7,8,3,6,5,9,2,4,1},
             {6,7,2,1,3,4,8,5,9}, {3,9,5,2,8,6,1,7,4}, {8,4,1,7,9,5,6,2,null}, 
             {1,5,8,3,6,7,4,9,2}, {9,3,4,5,2,8,7,1,6}, {2,6,7,9,4,1,3,8,5}};
		
		Integer[][] f2 = {
	            { 3, null, 6, 5, null, 8, 4, null, null },
	            { 5, 2, null, null, null, null, null, null, null },
	            { null, 8, 7, null, null, null, null, 3, 1 },
	            { null, null, 3, null, 1, null, null, 8, null },
	            { 9, null, null, 8, 6, 3, null, null, 5 },
	            { null, 5, null, null, 9, null, 6, null, null },
	            { 1, 3, null, null, null, null, 2, 5, null },
	            { null, null, null, null, null, null, null, 7, 4 },
	            { null, null, 5, 2, null, 6, 3, null, null }
	        };
		ArrayList<Integer[][]> merged = new ArrayList<>();
		merged.add(f);
		merged.add(f1);
		merged.add(f2);
		
		/*
		 * Random rand = new Random(); int r= rand.nextInt(merged.size());
		 */
		
		int counter = initBoardCounter;
		
		if (initBoardCounter < merged.size()-1) {
			
			initBoardCounter++;
			return merged.get(counter);
		}
		else
		{
			
			initBoardCounter = 0;
			return merged.get(counter);
		}
		
	
	}
	public void changeBoard() {
		board = initiateBoard();
	}
	public Integer[][] getBoard() {
		return board;
	}
	
	//walidacja
	
	public static boolean isNumeric(String text) {
		
		try {
	         Integer.parseInt(text);
	         return true;
	      } catch (NumberFormatException e) {
	         return false;
	      }
	}
	
	public static boolean isNumberInRange(Integer number) {
		
		if (number<=1 || number <=9) return true;
		return false;
	}
	
	/*
	 * public static boolean isInRange(Integer[][] board) {
	 * 
	 * 
	 * for(int i = 0; i < N; i++) { for(int j = 0; j < N; j++) {
	 * 
	 * 
	 * if (board[i][j] <= 0 || board[i][j] > 9) {
	 * 
	 * return false; } } } return true; }
	 */
	// walidacja poprawnie wypelnionej planszy
		
	
		public boolean[][] getInvalidFields(Integer[][] board)
		{
			for(int i = 0; i < N; i++)
		    {
		        for(int j = 0; j < N; j++)
		        {
		        	invalidFields[i][j] = false;
		        }
		    }
		   
		 
		    // Tablica dla unikatowych wartosci
		    // od 1 do N
		    boolean[] unique = new boolean[N + 1];
		 
		    // Weryfikacja horyzontalna
		    for(int i = 0; i < N; i++)
		    {

		        Arrays.fill(unique, false);

		        for(int j = 0; j < N; j++)
		        {
		            
		            int Z = board[i][j];
		 
		            
		            if (unique[Z])
		            {	
		            	for(int x = 0; x < N;x++) invalidFields[i][x] = true;
		                break;
		                
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
		            	for(int x = 0; x < N;x++) invalidFields[x][i] = true;
		                break;
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
		            block:
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
		                    	for(int x = i; x < i+3;x++) {
		                    		for(int y = j;y < j+3;y++) {
		                    			invalidFields[x][y] = true;
		                    		}
		                    		
		                    	}
				                break block;
		                    }
		                    unique[Z] = true;
		                }
		            }
		        }
		    }
		 
		    // jesli wszystko ok
		    return invalidFields;
		}
	
	public boolean isValidSudoku(Integer[][] board) {
		boolean[][] SudokuBoard = this.getInvalidFields(board);
		 for(int i = 0; i < N; i++)
		    {
		        for(int j = 0; j < N; j++)
		        {
		        	if(SudokuBoard[i][j]==true) return false;
		        }
		    }
		return true;
	}
		
	/*
	 * public static void main(String[] args) throws Exception { SudokuModel s = new
	 * SudokuModel(); Integer[][] list = s.initiateBoard(); for(int i = 0; i < 9 ;
	 * i++ ) { for(int y = 0; y < 9 ; y++ ) { System.out.print(list[i][y]); }
	 * System.out.println(); System.out.println("------------"); }
	 * 
	 * System.out.println(); System.out.println(); System.out.println();
	 * 
	 * SudokuModel s1 = new SudokuModel(); Integer[][] list1 = s1.initiateBoard();
	 * for(int i = 0; i < 9 ; i++ ) { for(int y = 0; y < 9 ; y++ ) {
	 * System.out.print(list1[i][y]); } System.out.println();
	 * System.out.println("------------"); } System.out.println();
	 * System.out.println(); System.out.println();
	 * 
	 * SudokuModel s2 = new SudokuModel(); Integer[][] list2 = s2.initiateBoard();
	 * for(int i = 0; i < 9 ; i++ ) { for(int y = 0; y < 9 ; y++ ) {
	 * System.out.print(list2[i][y]); } System.out.println();
	 * System.out.println("------------"); }
	 * 
	 * //System.out.println(sudokuCheck(f)); //System.out.println(sudokuCheck(f1));
	 * 
	 * 
	 * }
	 * 
	 */
	
}
