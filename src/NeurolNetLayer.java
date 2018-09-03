import java.util.LinkedList;

public class NeurolNetLayer {
	private String id;
	private LinkedList<Neuron> neuronLayer;

	public NeurolNetLayer(String tId,int noNeurons) {
		id=tId;
		neuronLayer = new LinkedList<Neuron>();
		this.setupNeuronLayer(noNeurons);
		
	}

	private void setupNeuronLayer(int noNeurons){
		for(int i=0;i<noNeurons;i++){
			neuronLayer.add(new Neuron("",new testActivationFunction()));
		}
	}
	
	public LinkedList<Neuron> getNeuronLayer(){
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
	}
}
