package meuprojetographstream;
import org.graphstream.algorithm.generator.Generator;
import org.graphstream.algorithm.generator.WattsStrogatzGenerator;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

public class wattsStrogatz {
    public static void main(String args[]){
        Graph grafo = new SingleGraph("Rede do tipo Small world!");
        Generator gerador = new WattsStrogatzGenerator(50, 2, 0.5);
        gerador.addSink(grafo);
        gerador.begin();
        while(gerador.nextEvents()) {}
        gerador.end();
        grafo.addAttribute("ui.quality");
        grafo.addAttribute("ui.antialias");
        grafo.display(false);
    }
}
