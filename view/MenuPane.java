package view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class MenuPane extends JPanel {
	private JButton newBtn;
    private JButton checkBtn;
    private JButton infoBtn;
	    
        public MenuPane() {
        	
        	
        	newBtn = new JButton("Nowa gra");
            checkBtn = new JButton("Sprawdź");
            infoBtn = new JButton("O grze");
        	
            setBorder(new EmptyBorder(4, 4, 4, 4));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.weightx = 1;
            
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(20,20,20,20);
            
            
            
            add(newBtn, gbc);
            gbc.gridy++;
            add(checkBtn, gbc);
            gbc.gridy++;
            add(infoBtn, gbc);

        }
        
        public JButton getCheckBtn() {
        	return checkBtn;
        }
        public JButton getNewBtn() {
        	return newBtn;
        }
        public JButton getInfoBtn() {
        	return infoBtn;
        }
        
      
    }