package p2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
*	SearchingView contains everything inside the lower part of the window.
*/

public class SearchingView extends JPanel{
	private static final long serialVersionUID = 1L;
	private JPanel 	southPanel = new JPanel(new BorderLayout()),
					searchPanelCenter = new JPanel(new GridLayout(3, 1)),
					fromPanel = new JPanel(new BorderLayout()),
					toPanel = new JPanel(new BorderLayout());
	private JLabel 	fromLabel = new JLabel("Från: "),
					toLabel = new JLabel("Till: ");
	private JComboBox<Place> 	fromBox = new JComboBox<Place>(),
								toBox = new JComboBox<Place>();
	private JButton searchButton = new JButton("Sök");
	private OptionsView optionsView = new OptionsView();
	
	public SearchingView(ArrayList<Place> places, P2Controller controller){
		this.setDimensions();
		this.addOptionsToComboBoxes(places);
		this.addListeners(controller);
		this.setColor();
		this.addComponents();
	}
	
	private void setColor(){
		this.setBackground(Color.WHITE);
		fromPanel.setBackground(Color.WHITE);
		toPanel.setBackground(Color.WHITE);
		searchPanelCenter.setBackground(Color.WHITE);
	}
	
	private void setDimensions(){
		fromLabel.setPreferredSize(new Dimension(50, 25));
		toLabel.setPreferredSize(new Dimension(50, 25));
	}
	
	private void addOptionsToComboBoxes(ArrayList<Place> places){
		for(int i = 0; i < places.size(); i++){
			fromBox.addItem(places.get(i));
			toBox.addItem(places.get(i));
		}
	}

	/**
	*	An anonymous class that implements ActionListener is used as
	*	a shortcut here.
	*/
	
	private void addListeners(P2Controller controller){
		searchButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.calculateRoute();
			}
		});
	}
	
	public Place getStartLocation(){
		//Typecasting is safe since the comboboxes are parameterized
		return (Place)fromBox.getSelectedItem();
	}
	
	public Place getEndLocation(){
		//Typecasting is safe since the comboboxes are parameterized
		return (Place) toBox.getSelectedItem();
	}
	
	private void addComponents(){
		searchPanelCenter.add(fromPanel);
		searchPanelCenter.add(toPanel);
		searchPanelCenter.add(searchButton);
		
		fromPanel.add(fromLabel, BorderLayout.WEST);
		fromPanel.add(fromBox, BorderLayout.CENTER);
		toPanel.add(toLabel, BorderLayout.WEST);
		toPanel.add(toBox, BorderLayout.CENTER);
		
		southPanel.add(searchPanelCenter, BorderLayout.CENTER);
		southPanel.add(optionsView, BorderLayout.EAST);
		
		this.add(southPanel, BorderLayout.SOUTH);
	}
	
	public int getButtonStatus(){
		return optionsView.getButtonStatus();
	}

}













