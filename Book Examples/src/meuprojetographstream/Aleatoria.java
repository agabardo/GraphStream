package meuprojetographstream;
import java.awt.Color;
import org.graphstream.algorithm.coloring.WelshPowell;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.algorithm.generator.Generator;
import org.graphstream.algorithm.generator.RandomGenerator;
import org.graphstream.graph.Node;

public class Aleatoria {    
    public static void main(String[] args) {
        Graph grafo = new SingleGraph("Rede Aleatória");
        Generator gerador = new RandomGenerator(2);
        gerador.addSink(grafo);
        gerador.begin();
        for(int i=0; i < 200; i++){
            gerador.nextEvents();
        }
        gerador.end();        
        
        WelshPowell wp = new WelshPowell("color");
        wp.init(grafo);
        wp.compute();
        
        Color[] cols = new Color[wp.getChromaticNumber()];
        for(int i=0;i< wp.getChromaticNumber();i++){
               cols[i]=Color.getHSBColor((float) (Math.random()), 0.8f, 0.9f);
        }
        for(Node n : grafo){
               int col = (int) n.getNumber("color");
               n.addAttribute("ui.style", "fill-color:rgba("+cols[col].getRed()+","+cols[col].getGreen()+","+cols[col].getBlue()+",200);" );
        }
        
        grafo.addAttribute("ui.quality");
        grafo.addAttribute("ui.antialias");
        grafo.display();
    }
}