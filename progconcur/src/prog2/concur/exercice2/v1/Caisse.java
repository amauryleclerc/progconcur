package prog2.concur.exercice2.v1;


public class Caisse
{
	
    public static void main(String args[])
    {
    	FileBloquanteBorneeBasNiveau<String> tapisRoulant = new FileBloquanteBorneeBasNiveau<String>(10);
    	
       Caissiere caissiere = new Caissiere(tapisRoulant);
       Client client = new Client(tapisRoulant);
               new Thread(caissiere).start();
               new Thread(client).start();
    }
}
 class Caissiere implements Runnable{
	 FileBloquanteBorneeBasNiveau<String> tapisRoulant;
	public Caissiere(FileBloquanteBorneeBasNiveau<String> tapisRoulant) {
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
	 FileBloquanteBorneeBasNiveau<String> tapisRoulant;

	public Client(FileBloquanteBorneeBasNiveau<String> tapisRoulant) {
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

