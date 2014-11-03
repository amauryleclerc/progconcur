package prog2.concur.exercice2.v2;

public class AbstractCaissiere {
	FileBloquanteBorneeBasNiveau<String> tapisRoulant;
	 public AbstractCaissiere (FileBloquanteBorneeBasNiveau<String> tapisRoulant) {
		 this.tapisRoulant = tapisRoulant;
	 }
	 public synchronized String scannerArticle() throws InterruptedException{
		 if(this.tapisRoulant.estVide){
			 wait();
		 }
		String article = (String) this.tapisRoulant.prendre();
		notify();
		
		return article;
		
	 }
}
