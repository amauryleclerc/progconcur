package prog2.concur.exercice2.basNiveau.v2;


public class Caisse
{
	
    public static void main(String args[])
    {
    	FileBloquanteBorneeBasNiveau<String> tapisRoulant = new FileBloquanteBorneeBasNiveau<String>(3);
    	
       Caissiere caissiere = new Caissiere(tapisRoulant);
       Client client = new Client(tapisRoulant);
               new Thread(caissiere).start();
               new Thread(client).start();

    }
}
 
	
	


