package it.polito.tdp.metroparis.model;

import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;

import it.polito.tdp.metroparis.db.MetroDAO;

public class Model {

	private Graph<Fermata, DefaultEdge> grafo;
	private List<Fermata> fermate;
	
	public void creaGrafo() {
		
		// crea il grafo
		this.grafo = new SimpleDirectedGraph<>(DefaultEdge.class);
		
		// aggiungi i vertici
		MetroDAO dao = new MetroDAO();
		this.fermate = dao.getAllFermate();
		Graphs.addAllVertices(grafo, fermate);
		
		// aggiungi gli archi (opzione 1)
//		for(Fermata partenza : this.grafo.vertexSet()) {
//			for(Fermata arrivo : this.grafo.vertexSet()) {
//				if(dao.esisteConnessione(partenza, arrivo))
//					this.grafo.addEdge(partenza, arrivo);
//			}
//		}
		
		// opzione 2
		for(Fermata partenza : this.grafo.vertexSet()) {
			List<Fermata> arrivi = dao.getStazioneArrivo(partenza);
			
			for(Fermata arrivo : arrivi) {
				this.grafo.addEdge(partenza, arrivo);
			}
		}
	}

	public List<Fermata> getFermate() {
		return fermate;
	}

	public void setFermate(List<Fermata> fermate) {
		this.fermate = fermate;
	}

	public Graph<Fermata, DefaultEdge> getGrafo() {
		return grafo;
	}
	
	
}
