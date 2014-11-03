package prog2.concur.exercice2.v2;


public class Caisse
{
	
    public static void main(String args[])
    {
    	FileBloquanteBorneeBasNiveau<String> tapisRoulant = new FileBloquanteBorneeBasNiveau<String>(2);
    	
       Caissiere caissiere = new Caissiere(tapisRoulant);
       Client client = new Client(tapisRoulant);
               new Thread(caissiere).start();
               new Thread(client).start();

    }
}
 class Caissiere extends AbstractCaissiere implements Runnable{

	public Caissiere(FileBloquanteBorneeBasNiveau<String> tapisRoulant) {
		super(tapisRoulant);
	
	}

	@Override
	public void run() {
		while(true){
			try {
				this.scannerArticle();
				System.out.println("caissiere scanner article");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
		
	
	
}
 class Client extends AbstractClient implements Runnable{
	 public Client(FileBloquanteBorneeBasNiveau<String> tapisRoulant) {
		super(tapisRoulant);
		// TODO Auto-generated constructor stub
	}
	

	
	@Override
	public void run() {
	while(true){
		try {
			this.deposerArticle("article");
			System.out.println("client depose article");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}
	
	
}

