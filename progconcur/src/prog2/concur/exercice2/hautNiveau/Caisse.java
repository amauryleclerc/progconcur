package prog2.concur.exercice2.hautNiveau;



public class Caisse
{
	
    public static void main(String args[])
    {
    	FileBloquanteBorneeHautNiveau<String> tapisRoulant = new FileBloquanteBorneeHautNiveau<String>(10);
    	
       Caissiere caissiere = new Caissiere(tapisRoulant);
       Client client = new Client(tapisRoulant);
               new Thread(caissiere).start();
               new Thread(client).start();
    }
}

