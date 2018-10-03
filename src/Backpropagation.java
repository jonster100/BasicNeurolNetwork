
public class Backpropagation {
	public double optimise(double bias, double output,double learningRate) {//will be changed, for a better back propagation
		return (bias > output) ? bias+learningRate : (bias < output) ? bias-learningRate : bias;
	}
}
