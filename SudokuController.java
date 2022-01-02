import java.awt.event.*;


public class SudokuController {

    private SudokuModel m_model;
    private SudokuView  m_view;

    //========================================================== constructor
    /** Constructor */
    public SudokuController(SudokuModel model, SudokuView view) {
        m_model = model;
        m_view  = view;

        //... Add listeners to the view.
        view.addNewGameListener(new NewGameListener());
        view.addVerifyListener(new VerifyListener());
        //view.addVerifyRangeListener(new VerifyRangeListener());
    }
    
    class NewGameListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		m_model.changeBoard();
    		m_view.fillBoard(m_model.getBoard());
    	}
    }
    
    class VerifyListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		String[][] inputValues = m_view.getBoardValues();
    		Integer[][] convertedValues = new Integer[9][9];
    		boolean[][] invalidFields;
    		boolean outOfRange = false;
    		
    		
    		m_view.eraseInvalidFields();
    		
    		for (int row = 0; row < 9; row++) {
    			  for (int col = 0; col < 9; col++) {
    				  
    				  if (SudokuModel.isNumeric(inputValues[row][col]))
    				  {
    					  convertedValues[row][col] = Integer.parseInt(inputValues[row][col]);
    					  if (!SudokuModel.isNumberInRange(convertedValues[row][col])) {
        					  outOfRange = true;
        					  m_view.markInvalidField(row, col);
        				  }

    				  }
    				  else {
    					  outOfRange = true;
    					  m_view.markInvalidField(row, col);
    					  
    				  }
			  
    			  }
    		}
    		
    		if (outOfRange)
    			m_view.showMessage("Na czerwono zaznaczono wartoœci spoza zakresu 1-9.");
    		else{
    			if (m_model.isValidSudoku(convertedValues))
    				m_view.showMessage("Gratulacje!!! Rozwi¹za³eœ Sudoku.");
    			else
    			{
    			
	    			invalidFields = m_model.getInvalidFields(convertedValues);
	    				for (int row = 0; row < 9; row++) {
	    					for (int col = 0; col < 9; col++) {
	    						if(invalidFields[row][col] == true) {
	    							m_view.markInvalidField(row, col);
			       				  }
	    					}
	    				}
    				m_view.showMessage("W zaznaczonych obszarach Sudoku wykryto zdublowane wartosci.");
    			};

    		}
    	}
    
	/*
	 * class VerifyRangeListener implements ActionListener{ public void
	 * actionPerformed(ActionEvent e) { String[][] values; values =
	 * m_view.getBoardValues(); Integer[][] convertedValues = new Integer[9][9];
	 * 
	 * try { for (int row = 0; row < 9; row++) {
	 * 
	 * for (int col = 0; col < 9; col++) { convertedValues[row][col] =
	 * Integer.parseInt(values[row][col]); }
	 * 
	 * } } catch (NumberFormatException e1) {
	 * m_view.showError("Nieprawid³owa wartoœæ");
	 * 
	 * }
	 * 
	 * } }
	 */
  
    }
}
