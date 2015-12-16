package ejercicio8;
import java.util.concurrent.Semaphore;



public class go {
	protected static Semaphore p, e, s, m, pd;

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		 
		 pd = new Semaphore(10);
		 e = new Semaphore(0);
		 s = new Semaphore(0);
		 m = new Semaphore(1);
		 p = new Semaphore(0);
		 
		 //for(int i=0; i<1; i++)
		 //{
			 (new Thread(new Avion(e, s, p))).start();
			 (new Thread(new ControladorEntrada(e, p, m))).start();
			 (new Thread(new ControladorSalida(s, m, p))).start();
		//}
	
		 
	
	}

}