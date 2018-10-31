import java.util.LinkedList;

public class NeurolNetLayer {
	private String id;
	private LinkedList<Neuron> neuronLayer;

	public NeurolNetLayer(String tId, int noNeurons) {
		id = tId;
		neuronLayer = new LinkedList<Neuron>();
		this.setupNeuronLayer(noNeurons);
	}
	
	public NeurolNetLayer(String tId, int noNeurons,int[] inputData) {
		id = tId;
		neuronLayer = new LinkedList<Neuron>();
		this.setupNeuronLayer(noNeurons);
		this.setInputLayerData(inputData);
	}
	
	private void setupNeuronLayer(int noNeurons) {
		for (int i = 0; i < noNeurons; i++) {
			neuronLayer.add(new Neuron(id, new SigmoidActivationFunction()));
		}
	}

	public LinkedList<Neuron> getNeuronLayer() {
		return neuronLayer;
	}

	public String getId() {
		return id;
	}

	public void addNeuron(Neuron n) {
		neuronLayer.add(n);
	}

	public void runNeuronLayer() {
		// function to go through all neurons and run there activation functions
		for (Neuron nL : neuronLayer) {
			if (nL.getInputConnectionsSize() >= 0) {
				nL.runNeuron();
			}
		}
	}

	private void setInputLayerData(int[] inputData) {
		for (int i = 0; i < neuronLayer.size(); i++) {
			Connection c = new Connection(null,neuronLayer.get(i));
			c.setInput(inputData[i]);
			neuronLayer.get(i).addInputConnection(c);
		}
	}

	public void updateNeuronsBias(double output,double learningRate) {
		for (Neuron n : neuronLayer) {
			n.updateWeights(output,learningRate);
		}
	}

	public double getOutputResult() {
		int noConnections=0;
		double toBeReturned = 0;
		if (id.equals("Output")) {
			for (Neuron n : neuronLayer) {
				toBeReturned += n.sumInputConnections();
				noConnections+=n.getInputConnectionsSize();
			}
		}
		return toBeReturned/noConnections;
	}
}
