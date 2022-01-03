
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.*;


public class SudokuView extends JFrame {
	private SudokuModel m_model;
	private JTextField[][] fields;
    private JPanel[] panels;
    JButton newBtn;
    JButton checkBtn;
    Font f = new Font("Calibri", Font.BOLD, 25);
    public static final int GRID_ROWS = 3;
	public static final int GRID_COLUMNS = 3;
	public static final int BOARD_ROWS = 9;
	public static final int BOARD_COLUMNS = 9;
    
	public SudokuView(SudokuModel model) {
	

	m_model = model;
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	setLayout(new BorderLayout());
	getContentPane().add(new MenuPane(), BorderLayout.AFTER_LINE_ENDS);
	getContentPane().add(new SudokuBoard());
	this.fillBoard(m_model.getBoard());
	
	
    pack();
    setVisible(true);
	}


	public class MenuPane extends JPanel {

        public MenuPane() {
            setBorder(new EmptyBorder(4, 4, 4, 4));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.weightx = 1;
            
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(20,20,20,20);
            
            newBtn = new JButton("Nowa gra");
            checkBtn = new JButton("Sprawdź");
            
            add(newBtn, gbc);
            gbc.gridy++;
            add(checkBtn, gbc);

        }
    }
	 
	 
	 public class SudokuBoard extends JPanel {



	        public SudokuBoard() {
	            
	            
	            panels = new JPanel[9];
	            fields = new JTextField[BOARD_ROWS][BOARD_COLUMNS];

	            setLayout(new GridLayout(GRID_ROWS, GRID_COLUMNS,2,2));
	            
	            //panele agreguj�ce kratki liczbowe
	            for (int i=0 ; i < 9 ; i++) {
		            JPanel panel = new JPanel(new GridLayout(3, 3));
		            //panel.setBorder(new CompoundBorder(new LineBorder(Color.GRAY, 2), new EmptyBorder(2, 2, 2, 2)));
		            panel.setBorder(new LineBorder(Color.GRAY, 2));
		            panels[i] = panel;
		            add(panel);
	            }
	            
	            //kratki liczbowe (bloki)
	            for (int row = 0; row < BOARD_ROWS; row++) {
	            	
	            	for (int col = 0; col < BOARD_COLUMNS; col++) {
	            		
	            		JTextField field = new JTextField();
	            		field.setHorizontalAlignment(SwingConstants.CENTER);
	            		field.setPreferredSize(new Dimension(60, 60));
	            		field.setFont(f);
	            		
	            		
	            		fields[row][col] = field;
	            		
	            		//przypisanie kratki do panelu grupuj�cego
	            		int block = (((row / 3) * 3) + (col / 3));
	            		
	            		panels[block].add(field);
	            	}
	            }
	            
				
	        }
	        }
	 
	 //Miejsce na metody
	 public void fillBoard(Integer[][] board) {
		 
		 this.eraseInvalidFields();
		 for (int row = 0; row < BOARD_ROWS; row++) {
         	
         	for (int col = 0; col < BOARD_COLUMNS; col++) {
         		if (board[row][col] ==null)
         			{fields[row][col].setText("");	
         		}
         			else {
         		fields[row][col].setText(board[row][col].toString());
         		}
         	}
         	}
	 }
	 
	 
	 public void showMessage(String Message) {
        JOptionPane.showMessageDialog(this, Message);
    }
	 public void showConfirm(String errMessage) {
	        int confirm = JOptionPane.showConfirmDialog(this, errMessage , null, JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
	        if (confirm == JOptionPane.YES_OPTION)
	        {
	            this.eraseInvalidFields();
	        }
	    }
	 
		/*
		 * public void addVerifyRangeListener(ActionListener vrl) { for (int row = 0;
		 * row < BOARD_ROWS; row++) {
		 * 
		 * for (int col = 0; col < BOARD_COLUMNS; col++) {
		 * fields[row][col].addActionListener(vrl); } }
		 * 
		 * }
		 */
	 
	 public String[][] getBoardValues(){
		 String[][] inputValues = new String[BOARD_ROWS][BOARD_COLUMNS];
		 
		 for (int row = 0; row < BOARD_ROWS; row++) {
	         	
	         	for (int col = 0; col < BOARD_COLUMNS; col++) {
	         		inputValues[row][col] = fields[row][col].getText();
	         	}
		 }
	     return inputValues;
	 }
	 
	 public void markInvalidField(int row, int col) {
		 fields[row][col].setBackground(Color.RED);
	 }
	 public void eraseInvalidFields() {
		 for (int row = 0; row < BOARD_ROWS; row++) {
	         	
	         	for (int col = 0; col < BOARD_COLUMNS; col++) {
	         		fields[row][col].setBackground(Color.WHITE);
	         	}
		 }
		 
	 }
		 
	 public void addNewGameListener(ActionListener ngl) {
		 newBtn.addActionListener(ngl);
	 }
	
	 public void addVerifyListener(ActionListener vl) {
		checkBtn.addActionListener(vl);
	 }
		
	 
}
