package hilosSemaforosIII;
import java.util.concurrent.Semaphore;

public class p3 extends Thread  {

	protected Semaphore oFinP3, oFinP2;
	
	public p3(Semaphore oFinP3, Semaphore oFinP2) {
		this.oFinP3 = oFinP3;
		this.oFinP2 = oFinP2;
	}
	
	public void run()  {
		
		try {
			this.oFinP3.acquire();//Si el contador es cero el thread se duerme, de lo contrario se reduce y obtiene el acceso 
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		/*try {
			sleep((int) Math.round(500 * Math.random() - 0.5));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("P3");
		//this.oFinP3.release(2);
		this.oFinP2.release();//Libera el semaphore e incrementa el countador  //SIGNAL
   
	}
}
