package prog2.concur.exercice2.v2;

public abstract class AbstractClient {
	FileBloquanteBorneeBasNiveau<String> tapisRoulant;
	 public AbstractClient (FileBloquanteBorneeBasNiveau<String> tapisRoulant) {
		 this.tapisRoulant = tapisRoulant;
	 }
	 public synchronized void deposerArticle(String article) throws InterruptedException{
		 if(this.tapisRoulant.estPleine){
			 wait();
		 }
		 this.tapisRoulant.deposer(article);
		 notify();
	 }
	   

}
