package view;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import java.awt.Color;

public class SudokuBoard extends JPanel {
	private JTextField[][] fields;
    private JPanel[] panels;

	        public SudokuBoard() {
	            
	            
	            panels = new JPanel[9];
	            fields = new JTextField[SudokuView.BOARD_ROWS][SudokuView.BOARD_COLUMNS];
	            

	            setLayout(new GridLayout(SudokuView.GRID_ROWS, SudokuView.GRID_COLUMNS,4,4));
	            
	            //panele agregujące kratki liczbowe
	            for (int i=0 ; i < 9 ; i++) {
		            JPanel panel = new JPanel(new GridLayout(3, 3));
		            //panel.setBorder(new CompoundBorder(new LineBorder(Color.BLACK, 3), new EmptyBorder(2, 2, 2, 2)));
		            panel.setBorder(new LineBorder(Color.BLACK, 3));
		            panels[i] = panel;
		            add(panel);
	            }
	            
	            //kratki liczbowe (bloki)
	            for (int row = 0; row < SudokuView.BOARD_ROWS; row++) {
	            	
	            	for (int col = 0; col < SudokuView.BOARD_COLUMNS; col++) {
	            		
	            		JTextField field = new JTextField();
	            		field.setHorizontalAlignment(SwingConstants.CENTER);
	            		field.setPreferredSize(new Dimension(60, 60));
	            		field.setFont(SudokuView.f);
	            		
	            		
	            		
	            		fields[row][col] = field;
	            		
	            		//przypisanie kratki do panelu grupującego
	            		int block = (((row / 3) * 3) + (col / 3));
	            		
	            		panels[block].add(field);
	            		field.setBorder(new LineBorder(Color.BLACK, 1));
	            	}
	            }
	            
				
	        }
	        
	        public JTextField[][] getFields(){
	        	return fields;
	        }
	        public JPanel[] getPanels(){
	        	return panels;
	        }
	        
        }