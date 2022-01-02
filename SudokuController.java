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
    }
    
    class NewGameListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		m_model.changeBoard();
    		m_view.fillBoard(m_model.getBoard());
    	}
    }
    
    class VerifyListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		
    	}
    }
    
    
  
}
