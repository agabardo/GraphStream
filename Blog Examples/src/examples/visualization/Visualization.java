package examples.visualization;

import java.io.IOException;

import org.graphstream.graph.ElementNotFoundException;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.stream.GraphParseException;

/**
 * @author agabardo
 * ademir.gabardo@uon.edu.au or ademir.gabbardo@gmail.com
 * twitter @agabardo
 */
public class Visualization {

	//Please notice, I am using a STATIC object just for an small example.
	//Use the proper object declarations and constructors when using it in the real world! :-)
	private static Graph Karate = new SingleGraph("Karate");
	
	public static void main(String[] args) {
		
		System.setProperty("org.graphstream.ui.renderer","org.graphstream.ui.j2dviewer.J2DGraphRenderer");
		try {
			Karate.read("karate/Karate.net");		
			//Karate.getNode("33").setAttribute("ui.style","shape:pie-chart;fill-color:rgb(127,0,55),rgb(255,0,110),rgb(1,127,1);");
			//Karate.getNode("33").setAttribute("ui.pie-values","0.333,0.333,0.333");
			//Karate.getNode("34").setAttribute("ui.style","shape:pie-chart; fill-color: rgb(255,0,110), rgb(0,255,1);");
			//Karate.getNode("34").setAttribute("ui.pie-values","0.5,0.5");
			//Karate.getNode(0).setAttribute("ui.style","shape:pie-chart; fill-color: rgb(255,0,110), rgb(0,255,1);");
			//Karate.getNode(0).setAttribute("ui.pie-values","0.5,0.5");
			
			int minimumsize = 20;
			int maximumsize = 35;
			setNodesSizes(minimumsize, maximumsize);
			
			Karate.addAttribute("ui.quality");
			Karate.addAttribute("ui.antialias");
			Karate.addAttribute("ui.stylesheet","url('styles/style.css')");
			Karate.display();
		}catch (ElementNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (GraphParseException e){
			e.printStackTrace();
		}
	}
	
	/*
	* This is the method which adjust the sizes of the nodes.
	* About the "static", see comments above!.
	*/
	public static void setNodesSizes(int minimumsize,int maximumsize){
		int smaller = -1;
		int greater = -1;
		for(Node n:Karate.getEachNode()){
			if(n.getDegree() > greater || smaller == -1)
				greater = n.getDegree();
			if(n.getDegree() < smaller || greater == -1)
				smaller = n.getDegree();
		}
		for(Node n:Karate.getEachNode()){
			double scale = (double)(n.getDegree() - smaller)/(double)(greater - smaller);
			if(null != n.getAttribute("ui.style")){
				n.setAttribute("ui.style", n.getAttribute("ui.style") + " size:"+ Math.round((scale*maximumsize)+minimumsize) +"px;");
			}
			else{
				n.addAttribute("ui.style", " size:"+ Math.round((scale*maximumsize)+minimumsize) +"px;");
			}
		}
	}

}
