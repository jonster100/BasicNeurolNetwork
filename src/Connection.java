
public class Connection {
	private float weight;
	protected Neuron toNeuron;
	protected Neuron fromNeuron;

	public Connection(Neuron tN, Neuron fN) {
		weight = 0;
		toNeuron = tN;
		fromNeuron = fN;
	}

	public void setWeight(float tW) {
		weight = tW;
	}

	public float getWeight() {
		return weight;
	}
}
