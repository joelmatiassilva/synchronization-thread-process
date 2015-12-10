package hilosSemaforosIII;
import java.util.concurrent.Semaphore;

public class p1 extends Thread  {

	protected Semaphore oFinP1, oFinP3 ;
	public p1(Semaphore oFinP1, Semaphore oFinP3) {
		this.oFinP1 = oFinP1;
		this.oFinP3 = oFinP3;
	}
	
	public void run()  {
		try {
			this.oFinP1.acquire();//Si el contador es cero el thread se duerme, de lo contrario se reduce y obtiene el acceso 
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		/*try {
			sleep((int) Math.round(500 * Math.random() - 0.5));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		 System.out.println("*******************************************");
		System.out.println("P1");
		//this.oFinP1.release(2);//Libera el semaphore e incrementa el countador  
		this.oFinP3.release();
	}
}
