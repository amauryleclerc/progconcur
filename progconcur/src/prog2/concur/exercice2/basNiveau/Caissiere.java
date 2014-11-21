package prog2.concur.exercice2.basNiveau;

public  class Caissiere implements Runnable{
	FileBloquanteBorneeBasNiveau<String> tapisRoulant;
	 public Caissiere (FileBloquanteBorneeBasNiveau<String> tapisRoulant) {
		 this.tapisRoulant = tapisRoulant;
	 }
	 public synchronized String scannerArticle() throws InterruptedException{
		
		String article = (String) this.tapisRoulant.prendre();
 
		System.out.println("caissiere scanne article");
		notifyAll();
		
		return article;
		
	 }
	@Override
	public void run() {
		while(true){
			try {
				this.scannerArticle();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
