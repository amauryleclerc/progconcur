package prog2.concur.exercice2.hautNiveau;

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