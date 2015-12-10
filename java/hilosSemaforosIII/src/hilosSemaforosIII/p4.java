package hilosSemaforosIII;
import java.util.concurrent.Semaphore;
public class p4 extends Thread  {

	protected Semaphore oFinP1;
	protected Semaphore oFinP4;
	
	public p4(Semaphore oFinP1,Semaphore oFinP4) {
		this.oFinP1 = oFinP1;
		this.oFinP4 = oFinP4;
	}
	
	
	public void run()  {
		try {
			this.oFinP4.acquire();//Si el contador es cero el thread se duerme, de lo contrario se reduce y obtiene el acceso 
			} catch(Exception e) {
				e.printStackTrace();
			}
		//try {
			//sleep((int) Math.round(500 * Math.random() - 0.5));
		//} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		System.out.println("P4");
		this.oFinP1.release();
	}
}
