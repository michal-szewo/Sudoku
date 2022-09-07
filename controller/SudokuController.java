package controller;
import java.awt.event.*;

import model.SudokuModel;
import view.SudokuView;


public class SudokuController {

    private SudokuModel m_model;
    private SudokuView  m_view;

    //========================================================== konstruktor
    
    public SudokuController(SudokuModel model, SudokuView view) {
        m_model = model;
        m_view  = view;

        
        view.addNewGameListener(new NewGameListener(this));
        view.addVerifyListener(new VerifyListener(this));
        view.addInfoListener(new InfoListener(this));
    }
    public SudokuModel getSudokuModel() {
    	return m_model;
    }
    public SudokuView getSudokuView() {
    	return m_view;
    }
    

    
}
