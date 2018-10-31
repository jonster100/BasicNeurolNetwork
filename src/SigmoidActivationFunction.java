
public class SigmoidActivationFunction implements ActivationFunction{

	@Override
	public double calculateOutput(double sumWeight, double bias) {
		return (1/( 1 + Math.pow(Math.E,(-1*sumWeight))))+bias;
	}
}
