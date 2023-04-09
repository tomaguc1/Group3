package STD_Classes;

import Controller.MainController;
import Model.Main.MainModel;
import Views.MainView;

public class Run {

	public static void main(String[] args) throws InterruptedException {

		MainModel model = new MainModel();
		MainView view = new MainView(model);
		MainController controller = new MainController(model, view);

//		Scanner s = new Scanner(System.in);
//		int x = s.nextInt();
//		if(x == 0 ){
//			Server server = new Server();
//			server.run();
//		} else if (x == 1) {
//			Client client = new Client();
//			client.run();
//		}


	}
}


























// Testing server-client
		/*
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		if(x == 0 ){
			Server server = new Server();
			server.run();
		} else if (x == 1) {
			Client client = new Client();
			client.run();
		}

	*/