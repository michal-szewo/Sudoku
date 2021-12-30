
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;



public class Window extends JFrame {
	public Window() {
		
		
		  
         // frame.add(new SudokuBoard());
		
          
      
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	setLayout(new BorderLayout());
	getContentPane().add(new MenuPane(), BorderLayout.AFTER_LINE_ENDS);
	getContentPane().add(new SudokuBoard());
	
	
	/*
	 * JSplitPane jSplitPane = new JSplitPane(); JPanel leftPanel = new JPanel();
	 * leftPanel.setLayout(new GridLayout(3,3)); JPanel rightPanel = new JPanel();
	 * rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.PAGE_AXIS));
	 * jSplitPane.setLeftComponent(leftPanel);
	 * jSplitPane.setRightComponent(rightPanel); jSplitPane.setSize(800, 600);
	 * 
	 * JButton newGameBtn = new JButton("Nowa gra"); JButton resetBtn = new
	 * JButton("Wyczyœæ"); JButton infoBtn = new JButton("Sprawd");
	 * rightPanel.add(newGameBtn); rightPanel.add(resetBtn);
	 * rightPanel.add(infoBtn);
	 * 
	 * getContentPane().add(jSplitPane, BorderLayout.CENTER);
	 */
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

            add(new JButton("Solve"), gbc);
            gbc.gridy++;
            add(new JButton("New"), gbc);
            gbc.gridy++;
            add(new JButton("Hint"), gbc);
            gbc.gridy++;
            add(new JButton("Reset"), gbc);

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
	            //setBorder(new EmptyBorder(4, 4, 4, 4));
	            
	            panels = new JPanel[9];
	            fields = new JTextField[BOARD_ROWS][BOARD_COLUMNS];

	            setLayout(new GridLayout(GRID_ROWS, GRID_COLUMNS,2,2));
	            
	            //panele agreguj¹ce kratki liczbowe
	            for (int i=0 ; i < 9 ; i++) {
		            JPanel panel = new JPanel(new GridLayout(3, 3));
		            //panel.setBorder(new CompoundBorder(new LineBorder(Color.GRAY, 2), new EmptyBorder(2, 2, 2, 2)));
		            panel.setBorder(new LineBorder(Color.GRAY, 2));
		            panels[i] = panel;
		            add(panel);
	            }
	            //kratki liczbowe
	            for (int row = 0; row < BOARD_ROWS; row++) {
	            	for (int col = 0; col < BOARD_COLUMNS; col++) {
	            		
	            		JTextField field = new JTextField(4);
	            		field.setHorizontalAlignment(SwingConstants.CENTER);
	            		field.setText("["+ row + "]["+ col + "]");
	            		fields[row][col] = field;
	            		
	            		//przypisanie do panelu grupuj¹cego
	            		int block = (((row / 3) * 3) + (col / 3));
	            		
	            		panels[block].add(field);
	            	}
	            }
	            
				/*
				 * for (int row = 0; row < GRID_ROWS; row++) { for (int col = 0; col <
				 * GRID_COLUMNS; col++) { JPanel panel = new JPanel(new GridLayout(3, 3, 2, 2));
				 * panel.setBorder(new CompoundBorder(new LineBorder(Color.GRAY, 2), new
				 * EmptyBorder(2, 2, 2, 2))); panels[row][col] = panel; add(panel);
				 * 
				 * for (int rowTxt = 0; rowTxt < GRID_ROWS; rowTxt++) { for (int colTxt = 0;
				 * colTxt < GRID_COLUMNS; colTxt++) { JTextField field = new JTextField(4);
				 * fields[rowTxt][] panel.add(fi)); } } //add(createBoard(fields, startRow,
				 * startCol)); } }
				 */
	        }
	        }

public static void main(String[] args) {
    SwingUtilities.invokeLater(Window::new);
}
}
