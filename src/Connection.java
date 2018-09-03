
public class Connection {
	private int weight;
	protected Neuron toNeuron;
	protected Neuron fromNeuron;

	public Connection(Neuron tN, Neuron fN) {
		weight = 0;
		toNeuron = tN;
		fromNeuron = fN;
	}

	public void setWeight(int tW) {
		weight = tW;
	}

	public int getWeight() {
		return weight;
	}
}
