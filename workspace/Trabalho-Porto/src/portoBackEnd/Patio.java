package portoBackEnd;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Patio {
	private Stack<Container> containers;
	private Queue<Caminhao> caminhoes;
	private Queue<Navio> navios;

	public Patio() {
		this.containers = new Stack<Container>();
		this.caminhoes = new LinkedList<Caminhao>();
		this.navios = new LinkedList<Navio>();
	}

	public Stack<Container> getContainers() {
		return containers;
	}

	public void setContainers(Stack<Container> containers) {
		this.containers = containers;
	}

	public Queue<Caminhao> getCaminhoes() {
		return caminhoes;
	}

	public void setCaminhoes(Queue<Caminhao> caminhoes) {
		this.caminhoes = caminhoes;
	}

	public Queue<Navio> getNavios() {
		return navios;
	}

	public void setNavios(Queue<Navio> navios) {
		this.navios = navios;
	}	
}
