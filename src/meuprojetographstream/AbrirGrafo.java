package meuprojetographstream;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.DefaultGraph;
import org.graphstream.stream.file.FileSource;
import org.graphstream.stream.file.FileSourceFactory;
import java.io.IOException;
import org.graphstream.ui.layout.HierarchicalLayout;

public class AbrirGrafo {
    public static void main(String[]args){
        String filePath = "grafo.gml";
        Graph g = new DefaultGraph("g");
        try{
            FileSource fs = FileSourceFactory.sourceFor(filePath);
            fs.addSink(g);    
            fs.begin(filePath);
            while (fs.nextEvents()) {
            }
            fs.end();
            fs.removeSink(g);
            g.display();
        }catch(IOException e){
            System.out.println("Não foi possível ler o arquivo de grafo:" + e.getMessage());
        }
    }
}
