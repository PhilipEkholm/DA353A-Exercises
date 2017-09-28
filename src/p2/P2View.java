package p2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
*	P2View
*
*	Main part of the view, the view has been split up into three files in order
*	to be readable.
*/

public class P2View extends JPanel{
	private static final long serialVersionUID = 1L;
	private MapView skaneMap;
	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTextArea directionsField = new JTextArea();
	private SearchingView searchView;

	public P2View(MapView map, ArrayList<Place> places, P2Controller controller){
		this.setPreferredSize(new Dimension(680, 700));
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		this.searchView = new SearchingView(places, controller);
		
		skaneMap = map;
		skaneMap.setSize(686, 592);
		directionsField.setEditable(false);
		this.createTabPanes();
		this.addComponents(places, controller);
	}
	
	private void createTabPanes(){
		tabbedPane.addTab("Karta", Streams.loadImage("images/waypoint_icon.png"), skaneMap);
		tabbedPane.addTab("Vägbeskrivningar", Streams.loadImage("images/directions_icon.png"), directionsField);
	}
	
	private void addComponents(ArrayList<Place> places, P2Controller controller){
		this.add(searchView, BorderLayout.SOUTH);
		this.add(tabbedPane, BorderLayout.CENTER);
	}
	
	public Place getStartLocation(){
		return searchView.getStartLocation();
	}
	
	public Place getTargetLocation(){
		return searchView.getEndLocation();
	}
	
	public int getButtonStatus(){
		return searchView.getButtonStatus();
	}
	
	public void setDescription(ArrayList<Road> roadList){
		Iterator<Road> iter = roadList.iterator();
		String res = "Vägbeskrivning från: " + roadList.get(0).getFrom() + " till " + roadList.get(roadList.size() - 1).getTo() + "\n \n \n";
		
		while(iter.hasNext()){
			res += iter.next() + "\n";
		}
		
		this.directionsField.setText(res);
	}
}











