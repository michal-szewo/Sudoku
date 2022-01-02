import javax.swing.*;


public class Start {
	public static final int GRID_ROWS = 3;
	public static final int GRID_COLUMNS = 3;
	public static final int BOARD_ROWS = 9;
	public static final int BOARD_COLUMNS = 9;
	
	public static void main(String[] args) {
		// strona https://stackoverflow.com/questions/5831388/what-is-the-controller-in-java-swing
			
	       	SudokuModel      model      = new SudokuModel();
	        SudokuView       view       = new SudokuView(model);
	        SudokuController controller = new SudokuController(model, view);

	        view.setVisible(true);
	    

	}

}
