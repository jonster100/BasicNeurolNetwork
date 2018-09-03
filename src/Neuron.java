import java.util.LinkedList;

public class Neuron {

	private String id;
	int bias;
	private LinkedList<Connection> inputNeuronConnections;
	private LinkedList<Connection> outputNeuronConnections;
	private ActivationFunction activationFunction;

	public Neuron(String tId, ActivationFunction aF) {
		activationFunction = aF;
		inputNeuronConnections = new LinkedList<Connection>();
		outputNeuronConnections = new LinkedList<Connection>();
		id = tId;
		bias=0;
	}

	public String getId() {
		return id;
	}

	public void addInputConnection(Connection c) {
		inputNeuronConnections.add(c);
	}

	public void addOutputConnection(Connection c) {
		outputNeuronConnections.add(c);
	}

	public void runNeuron() {
		this.setOutputConnections(this.startActivationFunction(this.sumInputConnections()));
	}

	private int startActivationFunction(int sumOfInput) {
		return activationFunction.calculateOutput(sumOfInput,bias);
	}

	private int sumInputConnections() {
		int total = 0;
		for(Connection c:inputNeuronConnections){
			total+=c.getWeight();
		}
		return total;
	}

	private void setOutputConnections(int newWeight) {
		for(Connection c:outputNeuronConnections){
			c.setWeight(newWeight);
		}
	}
}
