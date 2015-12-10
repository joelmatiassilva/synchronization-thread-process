package ejercicio8;
import java.util.concurrent.*;

public class ControladorEntrada extends Thread {
	
	protected Semaphore e;
	protected Semaphore p;
	protected Semaphore m;
		
	public ControladorEntrada(Semaphore e, Semaphore p, Semaphore m){
		this.e = e;
		this.p = p;
		this.m = m;
	}
	
	public void run(){
		while(true)
		{
		
			try{
				this.e.acquire();
			}catch(Exception e){
				
			}
			System.out.println("Controlador Entrada");
			this.p.release();
			//System.out.println(this.e.getQueueLength());
			
		}
	}

}
