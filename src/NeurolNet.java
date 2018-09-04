import java.util.LinkedList;

public class NeurolNet {
	private LinkedList<NeurolNetLayer> neuronLayers;

	public NeurolNet() {
		neuronLayers = new LinkedList<NeurolNetLayer>();
	}

	public void setupNeuronLayers(int noLayers) {
		for (int i = 0; i < noLayers; i++) {
			NeurolNetLayer newLayer = new NeurolNetLayer("Hidden", 3);
			neuronLayers.add(newLayer);
			if (neuronLayers.size() != 0) {
				this.setupNeuronConnections(neuronLayers.get(neuronLayers.size() - 1), newLayer);
			}
		}
		this.createOutputLayer();
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
	
	public void createInputLayer(int noInputNeurons, int[] inputWeights){
		NeurolNetLayer newLayer = new NeurolNetLayer("Input", noInputNeurons);
		neuronLayers.add(newLayer);
		this.setupNeuronLayers(4);
	}
	
	private void createOutputLayer(){
		NeurolNetLayer newLayer = new NeurolNetLayer("Output", 1);
		neuronLayers.add(newLayer);
	}

	public void runNeurolNet() {
		for (NeurolNetLayer nnL : neuronLayers) {
			nnL.runNeuronLayer();
		}
	}
}
