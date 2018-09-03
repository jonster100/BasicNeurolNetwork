import java.util.LinkedList;

public class NeurolNet {
	private LinkedList<NeurolNetLayer> neuronLayers;

	public NeurolNet() {
		neuronLayers = new LinkedList<NeurolNetLayer>();
		this.setupNeuronLayers(2);
	}

	public void setupNeuronLayers(int noLayers) {
		for (int i = 0; i < noLayers; i++) {
			neuronLayers.add(new NeurolNetLayer("", 2));
		}
	}

	//this method needs more alterations
	private void setupNeuronConnections(NeurolNetLayer layer1, NeurolNetLayer layer2) {
		LinkedList<Neuron> neuronList1 = layer1.getNeuronLayer();
		LinkedList<Neuron> neuronList2 = layer2.getNeuronLayer();
		for (int i = 0; i < neuronList1.size(); i++) {
			Neuron outputNeuron = neuronList1.get(i);
			for(int x=0;x<neuronList2.size();x++){
				Neuron inputNeuron =neuronList2.get(x);
				Connection con = new Connection(outputNeuron,inputNeuron);
				outputNeuron.addOutputConnection(con);
				inputNeuron.addInputConnection(con);
				
			}
		}
	}

	public void addNeuronLayer() {

	}
}
