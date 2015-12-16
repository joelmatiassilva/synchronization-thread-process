package productorConsumidor;
//http://www.sc.ehu.es/sbweb/fisica/cursoJava/applets/threads/sincronizacion.htm
public class ProducerConsumerTest {
   public static void main(String[] args) {
      CubbyHole c = new CubbyHole();
      Producer p1 = new Producer(c, 1);
      Consumer c1 = new Consumer(c, 1);
      p1.start(); 
      c1.start();
   }
}

/*La palabra reservada synchronized se usa para indicar que ciertas partes del código, 
 * (habitualmente, una función miembro) están sincronizadas, es decir, 
 * que solamente un subproceso puede acceder a dicho método a la vez.
 * Cada método sincronizado posee una especie de llave que puede cerrar o abrir la puerta de acceso. 
 * Cuando un subproceso intenta acceder al método sincronizado mirará a ver si la llave está echada, 
 * en cuyo caso no podrá accederlo. Si método no tiene puesta la llave entonces el 
 * subproceso puede acceder a dicho código sincronizado. */

class CubbyHole {
   private int contents;
   private boolean available = false;
   
   public synchronized int get() {
      while (available == false) {
         try {
            wait();
         }
         catch (InterruptedException e) {
         }
      }
      available = false;
      notifyAll();
      return contents;
   }
   
   public synchronized void put(int value) {
      while (available == true) {
         try {
            wait();
         }
         catch (InterruptedException e) { 
         } 
      }
      contents = value;
      available = true;
      notifyAll();
   }
   
}

class Consumer extends Thread {
   private CubbyHole cubbyhole;
   private int number;
   
   public Consumer(CubbyHole c, int number) {
      cubbyhole = c;
      this.number = number;
   }
   
   public void run() {
      int value = 0;
         for (int i = 0; i < 10; i++) {
            value = cubbyhole.get();
            System.out.println("Consumer #" + this.number + " got: " + value);
         }
   }
}//consumer

class Producer extends Thread {
	private CubbyHole cubbyhole;
	private int number;

	public Producer(CubbyHole c, int number) {
		cubbyhole = c;
		this.number = number;
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			cubbyhole.put(i);
			System.out.println("Producer #" + this.number	+ " put: " + i);
			try {
				sleep((int)(Math.random() * 100));
			} 
				catch (InterruptedException e) { 
					
			}
		}
	}
}