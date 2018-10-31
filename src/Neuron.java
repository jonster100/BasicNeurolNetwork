import java.util.LinkedList;
import java.util.Random;

public class Neuron {

	private String id;
	double bias;
	private LinkedList<Connection> inputNeuronConnections;
	private LinkedList<Connection> outputNeuronConnections;
	private ActivationFunction activationFunction;

	public Neuron(String tId, ActivationFunction aF) {
		activationFunction = aF;
		inputNeuronConnections = new LinkedList<Connection>();
		outputNeuronConnections = new LinkedList<Connection>();
		id = tId;
		Random noGen = new Random();// temp
		bias = noGen.nextFloat();// temp
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

	private double startActivationFunction(int sumOfInput) {
		return activationFunction.calculateOutput(sumOfInput, bias);
	}

	public int sumInputConnections() {
		int total = 0;
		for (Connection c : inputNeuronConnections) {
			total += c.getOutputWeight();
		}
		return total;
	}

	public void setOutputConnections(double newWeight) {
		if (outputNeuronConnections.size() != 0) {
			for (Connection c : outputNeuronConnections) {
				c.setInput(newWeight);
			}
		}
	}

	public void updateWeights(float output,float learningRate) {
		Backpropagation back = new Backpropagation();
		bias=back.optimise(bias, output,learningRate);
		for(Connection c:inputNeuronConnections){
			c.runWeightBackpropagation(output, learningRate);
		}
	}
}
