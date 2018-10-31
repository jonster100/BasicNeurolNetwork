import java.util.LinkedList;

public class NeurolNet {
	private LinkedList<NeurolNetLayer> neuronLayers;
	
	
	public NeurolNet() {
		neuronLayers = new LinkedList<NeurolNetLayer>();
	}

	public void setupNeuronLayers(int noLayers) {
		for (int i = 0; i < noLayers; i++) {
			NeurolNetLayer newLayer = new NeurolNetLayer("Hidden", 8);
			neuronLayers.add(newLayer);
			if (neuronLayers.size() > 1) {
				this.setupNeuronConnections(neuronLayers.get(neuronLayers.indexOf(newLayer) - 1), newLayer);
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

	public void createInputLayer(int noInputNeurons, int[] inputWeights) {
		NeurolNetLayer newLayer = new NeurolNetLayer("Input", noInputNeurons,inputWeights);
		neuronLayers.add(newLayer);
		this.setupNeuronLayers(10);
	}

	private void createOutputLayer() {
		NeurolNetLayer newLayer = new NeurolNetLayer("Output", 1);
		neuronLayers.add(newLayer);
		this.setupNeuronConnections(neuronLayers.get(neuronLayers.indexOf(newLayer) - 1), newLayer);
	}

	public void runNeurolNet() {
		for (NeurolNetLayer nnL : neuronLayers) {
			nnL.runNeuronLayer();
		}
	}

	public void runBackpropagation(float actual) {
		float outputResult = neuronLayers.getLast().getOutputResult();
		float oldErrorMargin = outputResult - actual;
		float newErrorMargin = 0;
		float learningRate =1;//this needs to be adaptable so needs changing
		while (newErrorMargin >= oldErrorMargin) {
			for (NeurolNetLayer nnL : neuronLayers) {
				nnL.updateNeuronsBias(outputResult,learningRate);
			}
			this.runNeurolNet();
			newErrorMargin+=neuronLayers.getLast().getOutputResult()-actual;
		}
		System.out.println("output result: "+outputResult);
		System.out.println("old error margin result: "+oldErrorMargin);
		System.out.println("new error margin result: "+newErrorMargin);
	}
}
