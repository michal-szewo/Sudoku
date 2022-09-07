package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.SudokuModel;
import view.SudokuView;

public class NewGameListener implements ActionListener{
	private SudokuModel m_model;
	private SudokuView m_view;
	
	public NewGameListener(SudokuController contr) {
		m_model = contr.getSudokuModel();
		m_view = contr.getSudokuView();
	}
	
	public void actionPerformed(ActionEvent e) {
		m_model.changeBoard();
		m_view.fillBoard(m_model.getBoard());
	}
}