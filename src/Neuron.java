import java.util.LinkedList;
import java.util.Random;

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
		Random noGen = new Random();// temp
		bias = noGen.nextInt(10);// temp
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

	public int getInputConnectionsSize() {
		return inputNeuronConnections.size();
	}

	public void runNeuron() {
		this.setOutputConnections(this.startActivationFunction(this.sumInputConnections()));
	}

	private int startActivationFunction(int sumOfInput) {
		return activationFunction.calculateOutput(sumOfInput, bias);
	}

	private int sumInputConnections() {
		int total = 0;
		for (Connection c : inputNeuronConnections) {
			total += c.getWeight();
		}
		return total;
	}

	private void setOutputConnections(int newWeight) {
		for (Connection c : outputNeuronConnections) {
			c.setWeight(newWeight);
		}
	}
}
