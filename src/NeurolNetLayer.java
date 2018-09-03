import java.util.LinkedList;

public class NeurolNetLayer {
	private String id;
	private LinkedList<Neuron> neuronLayer;

	public NeurolNetLayer() {
		neuronLayer = new LinkedList<Neuron>();
	}

	public String getId() {
		return id;
	}

	public void addNeuron(Neuron n) {
		neuronLayer.add(n);
	}

	public void runNeuronLayer() {
		// function to go through all neurons and run there activation functions
	}
}
