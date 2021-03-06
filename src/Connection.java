import java.util.Random;

public class Connection {
	private double weight;
	private double input;
	protected Neuron toNeuron;
	protected Neuron fromNeuron;

	public Connection(Neuron tN, Neuron fN) {
		input = 0;
		Random noGen = new Random();// temp
		weight = noGen.nextFloat();//temp
		toNeuron = tN;
		fromNeuron = fN;
	}
	
	public void runWeightBackpropagation(double output,double learningRate) {
		Backpropagation back = new Backpropagation();
		weight=back.optimise(weight, output,learningRate);
	}
	
	public void setInput(double tW) {
		input = tW;
	}

	public double getOutputWeight() {
		return input*weight;
	}
}
