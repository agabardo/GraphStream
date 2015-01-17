package meuprojetographstream;
import java.io.IOException;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

public class MeuProjetoGraphStream {
    public static void main(String[] args){        
        Graph grafo = new SingleGraph("Tutorial 1");
        grafo.addNode("A" );
        grafo.addNode("B" );
        grafo.addNode("C" );
        grafo.addEdge("AB", "A", "B");
        grafo.addEdge("BC", "B", "C");
        grafo.addEdge("CA", "C", "A");
        grafo.display();        
        try{        
            grafo.write("Grafo");
        }
        catch(IOException e){
            System.out.println("Erro ao gravar arquivo: " + e.getMessage());
        }
    }
}
