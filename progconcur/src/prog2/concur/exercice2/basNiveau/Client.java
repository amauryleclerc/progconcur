package prog2.concur.exercice2.basNiveau;


public  class Client implements Runnable{
	FileBloquanteBorneeBasNiveau<String> tapisRoulant;
	 public Client (FileBloquanteBorneeBasNiveau<String> tapisRoulant) {
		 this.tapisRoulant = tapisRoulant;
	 }
	 public synchronized void deposerArticle(String article) throws InterruptedException{
		
		 this.tapisRoulant.deposer(article);
		 System.out.println("client depose article");
		 notifyAll();
	 }
	@Override
	public void run() {
		while(true){
			try {
				this.deposerArticle("article");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
	}
	   

}
