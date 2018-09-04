
public class Backpropagation {
	public float optimise(float bias, float output,float learningRate) {//will be changed, for a better back propagation
		return (bias > output) ? bias+learningRate : (bias < output) ? bias-learningRate : bias;
	}
}
