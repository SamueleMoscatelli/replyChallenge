package replyChallenge;

import java.util.ArrayList;

import javafx.concurrent.Worker;

public class HandleWorkers {
	
	public int pickDeveloper(ArrayList<Worker> workers, Worker w){
		int tp=0;
		int wp=0;
		int bp=0;
		for(int i=0;i<workers.size();i++) {
			wp=0;
			bp=0;
			if (workers.get(i) instanceof Developer) {
				wp=calculateWp(workers.get(i),w);
				bp=calculateBp(workers.get(i),w);
			}
			else {
				bp=calculateBp(workers.get(i),w);
			}
			tp=tp+wp+bp;
		}
		return tp;
	}
	
	public int pickManager(ArrayList<Worker> workers, Worker w){
		int tp=0;
		int wp=0;
		int bp=0;
		for(int i=0;i<workers.size();i++) {
			wp=0;
			bp=0;
			if (workers.get(i) instanceof Developer) {
				wp=calculateWp(workers.get(i),w);
				bp=calculateBp(workers.get(i),w);
			}
			else {
				bp=calculateBp(workers.get(i),w);
			}
			tp=tp+wp+bp;
		}
		return tp;
	}

}
