package meuprojetographstream;
import org.graphstream.algorithm.generator.Generator;
import org.graphstream.algorithm.generator.GridGenerator;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

public class Grade {
   public static void main(String args[]){
        Graph grafo = new SingleGraph("Gerador do tipo grade");
        Generator gerador = new GridGenerator(true, false, false, false);
        gerador.addSink(grafo);
        gerador.begin();
        for(int i=0; i<10; i++) {
           gerador.nextEvents();
        }
        gerador.end();
        grafo.addAttribute("ui.quality");
        grafo.addAttribute("ui.antialias");
        grafo.display(false);
   }
}