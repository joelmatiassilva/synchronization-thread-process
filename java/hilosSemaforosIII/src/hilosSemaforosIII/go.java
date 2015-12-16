package hilosSemaforosIII;
import java.util.concurrent.Semaphore;

public class go {

	protected static Semaphore oFinP1,oFinP3, oFinP2, oFinP4;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 //oFinP1 = new Semaphore(0,true);
		 //oFinP3 = new Semaphore(0,true);
		 
		 oFinP1 = new Semaphore(1);
		 oFinP2 = new Semaphore(0);
		 oFinP3 = new Semaphore(0);

		 oFinP4 = new Semaphore(0);
		 
		 //Throw concurrente proccess
			 //System.out.println("*******************************************");
			 /*(new Thread(new p1(oFinP1))).start();
			 (new Thread(new p2(oFinP1,oFinP3))).start();
			 (new Thread(new p3(oFinP3))).start();
			 (new Thread(new p4(oFinP1,oFinP3))).start();*/
		 
			 for(int i=0; i<10; i++){
				 //System.out.println(i);
				 (new Thread(new p1(oFinP1, oFinP3))).start();
				 (new Thread(new p2(oFinP2, oFinP4))).start();
				 (new Thread(new p3(oFinP3, oFinP2))).start();
				 (new Thread(new p4(oFinP1, oFinP4))).start();
			 }
	
	}

}



// ESTE QUIERO: p1 p3 p2 p4