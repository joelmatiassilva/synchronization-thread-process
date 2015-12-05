package hilosSemaforosIII;
import java.util.concurrent.Semaphore;

public class go {

	protected static Semaphore oFinP1,oFinP3;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 oFinP1 = new Semaphore(0,true);
		 oFinP3 = new Semaphore(0,true);
		 //Throw concurrente proccess
		 //while(true){
			 System.out.println("*******************************************");
			 (new Thread(new p1(oFinP1))).start();
			 (new Thread(new p2(oFinP1,oFinP3))).start();
			 (new Thread(new p3(oFinP3))).start();
			 (new Thread(new p4(oFinP1,oFinP3))).start();
		// }
		 
	}

}
