
public class Backpropagation {
	public int optimise(int bias, int output) {//will be changed, for a better back propagation
		return (bias > output) ? 1 : (bias < output) ? -1 : 0;
	}
}
