import java.util.LinkedList;

public class NeurolNet {
	private LinkedList<NeurolNetLayer> neuronLayers;

	public NeurolNet() {
		neuronLayers = new LinkedList<NeurolNetLayer>();
		this.setupNeuronLayers(2);
	}

	private void setupNeuronLayers(int noLayers) {
		for (int i = 0; i < noLayers; i++) {
			NeurolNetLayer newLayer = new NeurolNetLayer("", 3);
			neuronLayers.add(new NeurolNetLayer("", 3));
			if (neuronLayers.size() != 0) {
				this.setupNeuronConnections(neuronLayers.get(neuronLayers.size() - 1), newLayer);
			}
		}
	}

	// this method needs more alterations
	private void setupNeuronConnections(NeurolNetLayer layer1, NeurolNetLayer layer2) {
		LinkedList<Neuron> neuronList1 = layer1.getNeuronLayer();
		LinkedList<Neuron> neuronList2 = layer2.getNeuronLayer();
		for (int i = 0; i < neuronList1.size(); i++) {
			Neuron outputNeuron = neuronList1.get(i);
			for (int x = 0; x < neuronList2.size(); x++) {
				Neuron inputNeuron = neuronList2.get(x);
				Connection con = new Connection(inputNeuron, outputNeuron);
				outputNeuron.addOutputConnection(con);
				inputNeuron.addInputConnection(con);

			}
		}
	}
	
	private void createInputLayer(){}
	
	private void createOutputLayer(){}

	public void runNeurolNet() {
		for (NeurolNetLayer nnL : neuronLayers) {
			nnL.runNeuronLayer();
		}
	}
}
