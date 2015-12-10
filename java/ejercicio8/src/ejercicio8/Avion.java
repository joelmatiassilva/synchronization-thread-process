package ejercicio8;
import java.util.concurrent.*;

public class Avion extends Thread {
	
	protected Semaphore e;
	protected Semaphore s;
	protected Semaphore p;

		
	public Avion(Semaphore e, Semaphore s, Semaphore p){
		this.e = e;
		this.s = s;
		this.p = p;
	}
	
	public void run(){

		
		this.e.release();
		
		try{
			this.p.acquire();
			System.out.println("Tomo Pista Despegar");
			}catch(Exception e){
		}
		System.out.println("Despegar");
		this.s.release();

		
		
		
		
		try {
			sleep((int) Math.round(500 * Math.random() - 0.5));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("*******************************************");

		
		
		
		this.e.release();
		
		
		try{
			this.p.acquire();
			sleep((int) Math.round(500 * Math.random() - 0.5));
			System.out.println("Tomo Pista Aterrizar");
			}catch(Exception e){
		}
		System.out.println("aterrizar");
		this.s.release();
		
	}

}

