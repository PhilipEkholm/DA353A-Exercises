package p2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

import javax.swing.JFrame;

/**
*	P2Controller
*
*	While commenting the P2Controller is not a requirement, the
*	program is large and hard to analyze without help comments,
*	therefore you will find some of them here.
*
*	P2Controller is the main frame for the program, using a lot of logic
*	taken from Laboration 10 in order to execute.
*
*	Interesting files include:
*
*	|P2Controller
*	|Views:
*	|---P2View
*	|------SearchingView
*	|---------OptionsView
*	|Streams
*
*	The Views are sorted in a hierarchy.
*
*	Streams contains different static methods for loading in files
*	from the operating system (a.k.a. Stream).
*	
*
*	@author Phlip Ekholm
*	@created 2017-03-04
*/

public class P2Controller {
	private Graph<String> graph = new Graph<String>();
	private MapView map;
	private TreeMap<String, Road> roads;
	private P2View view;
	private ArrayList<Road> roadList = new ArrayList<Road>();
	private Iterator<Road> values;
	private ArrayList<Place> places = new ArrayList<Place>();
	
	public P2Controller(String mapPath, Position mapLeftUp, Position mapRightDown, String pathPlaces, String pathRoads){
		//Must be executed before P2View
		places = Streams.readPlaces("files/places.txt");
		roads = Streams.readRoads(pathRoads);
		values = roads.values().iterator();
		
		while(values.hasNext()){
			roadList.add(values.next());
		}
		
		map = new MapView(mapPath, mapLeftUp.getLongitude(), mapLeftUp.getLatitude(), mapRightDown.getLongitude(), mapRightDown.getLatitude());
		this.view = new P2View(map, places, this);
		makeGraph(places, roads);
		
		
		JFrame frame = new JFrame("Philip Maps");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(120, 40);
		frame.add(view);
		
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	public void makeGraph(ArrayList<Place> places, TreeMap<String, Road> roads) {
		Iterator<Road> values = roads.values().iterator();
		Road road;
		
		for (Place place : places) {
			graph.addVertex(place.getName());
		}
		while (values.hasNext()) {
			road = values.next();
			graph.addEdge(road.getFrom(), road.getTo(), road.getCost());
		}
	}

	/**
	*	If the button search had been pressed, this method will be run.
	*/
	
	public void calculateRoute(){
		Place 	startPlace = view.getStartLocation(),
				targetPlace = view.getTargetLocation();
		
		ArrayList<Edge<String>> path = null; //Something's really wrong if none of the buttons are active
		ArrayList<Road> roadList = new ArrayList<Road>();
		
		switch(view.getButtonStatus()){
			case 0:
				path = GraphSearch.depthFirstSearch(graph, startPlace.getName(), targetPlace.getName());
				break;
			case 1:
				path = GraphSearch.breadthFirstSearch(graph, startPlace.getName(), targetPlace.getName());
				break;
			case 2:
				path = GraphSearch.dijkstraSearch(graph, startPlace.getName(), targetPlace.getName());
				break;
		}
		
		for(Edge<String> e: path){
			roadList.add(roads.get(e.getFrom() + "-" + e.getTo()));
		}
		
		view.setDescription(roadList);
		map.showRoads(roadList);
	}
}
