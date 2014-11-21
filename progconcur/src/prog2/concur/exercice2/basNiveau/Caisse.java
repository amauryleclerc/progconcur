package prog2.concur.exercice2.basNiveau;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Caisse
{
	
    public static void main(String args[])
    {
    	FileBloquanteBorneeBasNiveau<String> tapisRoulant = new FileBloquanteBorneeBasNiveau<String>(3);
  	   ExecutorService  pool = Executors.newFixedThreadPool(2); ;
       Caissiere caissiere = new Caissiere(tapisRoulant);
       Client client = new Client(tapisRoulant);
       pool.execute( new Thread(caissiere));
       pool.execute( new Thread(client));

    }
}
 
	
	


