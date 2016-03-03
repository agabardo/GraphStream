package meuprojetographstream;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.algorithm.generator.Generator;
import org.graphstream.algorithm.generator.DorogovtsevMendesGenerator;

public class Dorogovtsev {
    public static void main(String[] args) {
        Graph grafo = new SingleGraph("Dorogovtsev mendes");
        Generator gerador = new DorogovtsevMendesGenerator();
        gerador.addSink(grafo);
        gerador.begin();
        for(int i=0; i<100; i++) {
            gerador.nextEvents();
        }
        gerador.end();
        grafo.addAttribute("ui.quality");
        grafo.addAttribute("ui.antialias");
        grafo.display();
    }
}
