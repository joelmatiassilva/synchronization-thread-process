package hilosSemaforos;
import java.util.concurrent.locks.*;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {

	int i = 0;

	public static void main (String[] args) {
		final SemaphoreExample example = new SemaphoreExample();
		final Semaphore semaphore = new Semaphore (1);
		final Runnable r = new Runnable () {

			public void run () {
				while (true) {
					try {
						semaphore.acquire();
						//Sección crítica a proteger
						example.printSomething ();
						Thread.sleep (1000);
						semaphore.release();

					} catch (Exception ex) {
						System.out.println (" — Interrupted…");
						ex.printStackTrace ();
					}
				}

			}//run

		};//Runnable

		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();

	}//main

	public void printSomething (){
		i++;
		System.out.println (" — current value of the i :"+ i);
	}

}