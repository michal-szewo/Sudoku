package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.SudokuModel;
import view.SudokuView;

class VerifyListener implements ActionListener{
	private SudokuModel m_model;
	private SudokuView m_view;
		
    public VerifyListener(SudokuController contr) {
    		m_model = contr.getSudokuModel();
    		m_view = contr.getSudokuView();
	}

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
    			m_view.showOption("Na czerwono zaznaczono wartoœci spoza zakresu 1-9.");
    		else{
    			if (m_model.isValidSudoku(convertedValues))
    				m_view.showMessage("Gratulacje!!! Rozwi¹za³eœ Sudoku.","Wygrana");
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
    				m_view.showOption("W zaznaczonych obszarach Sudoku wykryto zdublowane wartoœci.");
    			};

    		}
    	}
    }