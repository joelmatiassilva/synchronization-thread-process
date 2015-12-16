package email;
// File Name SendHTMLEmail.java

import java.util.concurrent.Semaphore;


public class SendHTMLEmail {
	   public static void main(String arg[]) {
		   Semaphore oFinP1 = new Semaphore(1,true);

	      
		   for(int i=0;i<=100; i++){
			   System.out.println("CILO NUMERO" + Integer.toString(i));
	    	  (new Thread(new EnviarEmail(Integer.toString(i), oFinP1))).start();
	      }

	   }
}

