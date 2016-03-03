package meuprojetographstream;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.algorithm.generator.Generator;
import org.graphstream.algorithm.generator.BarabasiAlbertGenerator;

public class BarabasiAlbert {
    public static void main(String args[]){
        Graph grafo = new SingleGraph("Rede de Barabàsi e Albert");
        Generator gerador = new BarabasiAlbertGenerator(1);
        gerador.addSink(grafo);
        gerador.begin();
        for(int i=0; i<100; i++) {
            gerador.nextEvents();
        }
        gerador.end();
        grafo.display();
    }
}
