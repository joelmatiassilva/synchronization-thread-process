package ejercicio8;
import java.util.concurrent.*;

public class ControladorSalida extends Thread{
	
	protected Semaphore s;
	protected Semaphore m;
	protected Semaphore p;
	
	public ControladorSalida(Semaphore s, Semaphore m, Semaphore p){
		this.s = s;
		this.m = m;
		this.p = p;
		
	}
	
	public void run(){
		while(true)
		{
			try{
				this.s.acquire();
			}catch(Exception e){
				
			}
			System.out.println("Controlador Salida");
			this.p.release();
		}
	}

}
