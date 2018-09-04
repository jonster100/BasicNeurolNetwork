import java.util.LinkedList;

public class NeurolNetLayer {
	private String id;
	private LinkedList<Neuron> neuronLayer;

	public NeurolNetLayer(String tId, int noNeurons) {
		id = tId;
		neuronLayer = new LinkedList<Neuron>();
		this.setupNeuronLayer(noNeurons);

	}

	private void setupNeuronLayer(int noNeurons) {
		for (int i = 0; i < noNeurons; i++) {
			neuronLayer.add(new Neuron("", new testActivationFunction()));
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

	public void setInputLayerConnections(int[] inputData) {
		for (int i = 0; i < neuronLayer.size(); i++) {
			neuronLayer.get(i).setOutputConnections(inputData[i]);
		}
	}

	public void updateNeuronsBias(float output,float learningRate) {
		for (Neuron n : neuronLayer) {
			n.updateBias(output,learningRate);
		}
	}

	public int getOutputResult() {
		int noConnections=0;
		int toBeReturned = 0;
		if (id.equals("Output")) {
			for (Neuron n : neuronLayer) {
				toBeReturned += n.sumInputConnections();
				noConnections+=n.getInputConnectionsSize();
			}
		}
		return toBeReturned/noConnections;
	}
}
