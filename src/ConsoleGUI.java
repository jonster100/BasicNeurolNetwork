import java.util.Scanner;

public class ConsoleGUI {
	NeurolNet engine;
	public ConsoleGUI(NeurolNet e) {
		engine = e;
		this.mainConsole();
	}

	private void mainConsole() {
		Scanner in = new Scanner(System.in);
		System.out.println("Please Choose one of the following options. ");
		System.out.println("q - Exit Program");
		System.out.println("i - Create input layer");
		System.out.println("r - Run Neuron Network");
		// String text = in.next();
		boolean x = true;
		while (x) {
			String text = in.next();
			if (text.equals("q")) {
				x = false;
			} else if(text.equals("i")){
				System.out.println("--->");
				this.inputLayerData();
				System.out.println("<---");
			}else if (text.equals("r")){
				System.out.println("--->");
				engine.runNeurolNet();
				System.out.println("<---");
			} else if(text.equals("v")){
				
			}
			else if(text.equals("a")) {
				
			} else if(text.equals("r")){
				
			}
		}
	}
	
	private void inputLayerData(){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter how many input neurons you require.");
		int noData = in.nextInt();
		int[] dataList= new int[noData];
		for(int i=0;i<noData;i++){
			System.out.println("Input Neuron: "+i);
			int data = in.nextInt();
			dataList[i]=data;
		}
		engine.createInputLayer(noData, dataList);
	}
}
