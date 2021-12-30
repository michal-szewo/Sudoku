
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;



public class Window extends JFrame {
	public Window() {
		
		
		  
         // frame.add(new SudokuBoard());
		
          
      
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	setLayout(new BorderLayout());
	getContentPane().add(new MenuPane(), BorderLayout.AFTER_LINE_ENDS);
	getContentPane().add(new SudokuBoard());
	
	
	
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
            
            
            add(new JButton("Nowa gra"), gbc);
            gbc.gridy++;
            add(new JButton("Sprawdü"), gbc);

        }
    }
	 
	 
	 public class SudokuBoard extends JPanel {

	        public static final int GRID_ROWS = 3;
	        public static final int GRID_COLUMNS = 3;
	        public static final int BOARD_ROWS = 9;
	        public static final int BOARD_COLUMNS = 9;
	        
	        
	        
	        private JTextField[][] fields;
	        private JPanel[] panels;

	        public SudokuBoard() {
	            
	            
	            panels = new JPanel[9];
	            fields = new JTextField[BOARD_ROWS][BOARD_COLUMNS];

	            setLayout(new GridLayout(GRID_ROWS, GRID_COLUMNS,2,2));
	            
	            //panele agregujπce kratki liczbowe
	            for (int i=0 ; i < 9 ; i++) {
		            JPanel panel = new JPanel(new GridLayout(3, 3));
		            //panel.setBorder(new CompoundBorder(new LineBorder(Color.GRAY, 2), new EmptyBorder(2, 2, 2, 2)));
		            panel.setBorder(new LineBorder(Color.GRAY, 2));
		            panels[i] = panel;
		            add(panel);
	            }
	            int counter = 0;
	            //kratki liczbowe
	            for (int row = 0; row < BOARD_ROWS; row++) {
	            	
	            	for (int col = 0; col < BOARD_COLUMNS; col++,counter++) {
	            		
	            		JTextField field = new JTextField();
	            		field.setHorizontalAlignment(SwingConstants.CENTER);
	            		field.setPreferredSize(new Dimension(100, 100));
	            		
	            		//field.setText("["+ row + "]["+ col + "]" + " " + counter);
	            		fields[row][col] = field;
	            		
	            		//przypisanie kratki do panelu grupujπcego
	            		int block = (((row / 3) * 3) + (col / 3));
	            		
	            		panels[block].add(field);
	            	}
	            }
	            
				
	        }
	        }

public static void main(String[] args) {
    SwingUtilities.invokeLater(Window::new);
}
}
