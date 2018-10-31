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

	public void runBackpropagation(double actual) {
		double oldOutputResult = neuronLayers.getLast().getOutputResult();
		double newOutputResult = 0;
		double oldErrorMargin = oldOutputResult - actual;
		double newErrorMargin = 0;
		double learningRate =3;//this needs to be adaptable so needs changing
		int noIterations = 0;
		while (newOutputResult <= actual) {
			for (NeurolNetLayer nnL : neuronLayers) {
				nnL.updateNeuronsBias(oldOutputResult,learningRate);
			}
			this.runNeurolNet();
			newOutputResult=0;
			newErrorMargin=0;
			newOutputResult+=neuronLayers.getLast().getOutputResult();
			newErrorMargin+=newOutputResult-actual;
			noIterations+=1;
			System.out.println(noIterations+"--output result: "+newOutputResult);
			System.out.println(noIterations+"--new error margin result: "+newErrorMargin);
		}
		System.out.println("final output result: "+newOutputResult);
		System.out.println("final margin result: "+newErrorMargin);
	}
}
