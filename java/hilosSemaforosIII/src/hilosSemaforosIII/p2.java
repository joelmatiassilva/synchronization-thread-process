package hilosSemaforosIII;
import java.util.concurrent.Semaphore;
public class p2 extends Thread  {

	protected Semaphore oFinP2;
	protected Semaphore oFinP4;
	
	public p2(Semaphore oFinP2,Semaphore oFinP4) {
		this.oFinP2 = oFinP2;
		this.oFinP4 = oFinP4;
	}
	
	public void run()  {
		try {
			this.oFinP2.acquire();//Si el contador es cero el thread se duerme, de lo contrario se reduce y obtiene el acceso 
			//this.oFinP3.acquire();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		/*try {
			sleep((int) Math.round(500 * Math.random() - 0.5));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		System.out.println("P2");
		this.oFinP4.release();
	}
}
