package view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class MenuPane extends JPanel {

	    
        public MenuPane(SudokuView view) {
        	
        	
        	view.newBtn = new JButton("Nowa gra");
            view.checkBtn = new JButton("Sprawdź");
            view.infoBtn = new JButton("O grze");
        	
            setBorder(new EmptyBorder(4, 4, 4, 4));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.weightx = 1;
            
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(20,20,20,20);
            
            
            
            add(view.newBtn, gbc);
            gbc.gridy++;
            add(view.checkBtn, gbc);
            gbc.gridy++;
            add(view.infoBtn, gbc);

        }
        
      
    }