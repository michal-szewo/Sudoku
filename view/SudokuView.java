package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.AttributeSet.ColorAttribute;

import model.SudokuModel;

import java.awt.event.*;


public class SudokuView extends JFrame {
	private SudokuModel m_model;
	JTextField[][] fields;
    JPanel[] panels;
    JButton newBtn;
    JButton checkBtn;
    JButton infoBtn;
    
    
    public static final Font f = new Font("Calibri", Font.BOLD, 25);
    public static final int GRID_ROWS = 3;
	public static final int GRID_COLUMNS = 3;
	public static final int BOARD_ROWS = 9;
	public static final int BOARD_COLUMNS = 9;
    
	public SudokuView(SudokuModel model) {
	

	m_model = model;
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	setLayout(new BorderLayout());
	getContentPane().add(new MenuPane(this), BorderLayout.AFTER_LINE_ENDS);
	getContentPane().add(new SudokuBoard(this));
	this.fillBoard(m_model.getBoard());
	
	this.setMinimumSize(new Dimension(600, 500));
    pack();
    setVisible(true);
	}


	
	 
	 
	 
	 
	 //Miejsce na metody
	 public void fillBoard(Integer[][] board) {
		 
		 this.eraseInvalidFields();
		 for (int row = 0; row < BOARD_ROWS; row++) {
         	
         	for (int col = 0; col < BOARD_COLUMNS; col++) {
         		if (board[row][col] ==null)
         			{	
         				fields[row][col].setEditable(true);
         				fields[row][col].setText("");
         				
         				//fields[row][col].setBorder(new LineBorder(Color.BLACK, 1));
         				
         		}
         			else {
         		fields[row][col].setText(board[row][col].toString());
         		fields[row][col].setEditable(false);
         		
         		//fields[row][col].setBorder(new LineBorder(Color.GRAY, 1));
         		}
         	}
         	}
	 }
	 
	 
	 public void showMessage(String Message, String Title) {
        JOptionPane.showMessageDialog(this, Message, Title, JOptionPane.INFORMATION_MESSAGE);
	 }
	 public void showConfirm(String Message) {
	        int confirm = JOptionPane.showConfirmDialog(this, Message , null, JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
	        if (confirm == JOptionPane.YES_OPTION)
	        {
	            this.eraseInvalidFields();
	        }
	    }
	 
	
	 public void showOption(String Message) {
		 Object[] options = {"Usuń zaznaczenie",
                 "Pozostaw zaznaczenie"
                 };
	        int n = JOptionPane.showOptionDialog(this,
	        		Message,
	        		"Błędne pola", JOptionPane.YES_NO_OPTION,
	        	    JOptionPane.QUESTION_MESSAGE,
	        	    null,     //do not use a custom Icon
	        	    options,  //the titles of buttons
	        	    options[0]);
	        if (n == JOptionPane.YES_OPTION)
	        {
	            this.eraseInvalidFields();
	        }
	    }
	 
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
   	 public void addInfoListener(ActionListener in) {
   			infoBtn.addActionListener(in);
   		 }	
	 
}
