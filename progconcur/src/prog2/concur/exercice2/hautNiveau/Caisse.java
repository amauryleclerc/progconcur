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
 class Caissiere implements Runnable{
	 FileBloquanteBorneeHautNiveau<String> tapisRoulant;
	public Caissiere(FileBloquanteBorneeHautNiveau<String> tapisRoulant) {
		this.tapisRoulant = tapisRoulant;
	}
	@Override
	public void run() {
		while(true){
			scannerArticle();
		}
		
	}
	void scannerArticle(){
		String article = null;
		try {
			article = this.tapisRoulant.prendre();
			System.out.println("caissiere scanne "+article);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
 class Client implements Runnable{
	 FileBloquanteBorneeHautNiveau<String> tapisRoulant;

	public Client(FileBloquanteBorneeHautNiveau<String> tapisRoulant) {
		this.tapisRoulant = tapisRoulant;
	}
	@Override
	public void run() {
	while(true){
		deposerArticle();
		}
		
	}
	void deposerArticle(){
		try {
			
			this.tapisRoulant.deposer("article");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("client depose article");
	}
	
}

