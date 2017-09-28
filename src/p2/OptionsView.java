package p2;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class OptionsView extends JPanel{
	private static final long serialVersionUID = 1L;
	private JRadioButton 	deepSearchRadioButton = new JRadioButton("Sökning på djupet"),
			wideSearchRadioButton = new JRadioButton("Sökning på bredden"),
			dijkstraSearchRadioButton = new JRadioButton("Dijkstra");
	private ButtonGroup buttonGroup = new ButtonGroup();
	
	public OptionsView(){
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Sökalternativ"));
		this.setLayout(new GridLayout(3, 1));
		
		this.setBackground(Color.WHITE);
		this.createRadioButtonGroup();
		this.addComponents();
	}
	
	private void createRadioButtonGroup(){
		deepSearchRadioButton.setSelected(true);
		buttonGroup.add(deepSearchRadioButton);
		buttonGroup.add(wideSearchRadioButton);
		buttonGroup.add(dijkstraSearchRadioButton);
	}
	
	private void addComponents(){
		this.add(deepSearchRadioButton);
		this.add(wideSearchRadioButton);
		this.add(dijkstraSearchRadioButton);
	}
	
	public int getButtonStatus(){
		if(deepSearchRadioButton.isSelected()){
			return 0;
		}
		else if(wideSearchRadioButton.isSelected()){
			return 1;
		}
		
		return 2;
	}
}
