
public class Connection {
	private double weight;
	protected Neuron toNeuron;
	protected Neuron fromNeuron;

	public Connection(Neuron tN, Neuron fN) {
		weight = 0;
		toNeuron = tN;
		fromNeuron = fN;
	}

	public void setWeight(double tW) {
		weight = tW;
	}

	public double getWeight() {
		return weight;
	}
}
