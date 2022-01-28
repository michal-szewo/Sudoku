package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.SudokuModel;
import view.SudokuView;

class InfoListener implements ActionListener{
        	
	private SudokuModel m_model;
	private SudokuView m_view;
		
    public InfoListener(SudokuController contr) {
    		m_model = contr.getSudokuModel();
    		m_view = contr.getSudokuView();
	}
	
	public void actionPerformed(ActionEvent e) {
        		m_view.showMessage("Nazwa: Sudoku Java Swing\nAutor: Micha³ Szeworski","O grze");
        	}
    	}