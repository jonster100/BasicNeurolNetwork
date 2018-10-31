
public class testActivationFunction implements ActivationFunction {

	@Override
	public double calculateOutput(double sumWeight,double bias) {//not an actual activationFunction to be used, just used for testing
		// TODO Auto-generated method stub
		return sumWeight*bias;
	}

}
