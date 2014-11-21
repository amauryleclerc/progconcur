package prog2.concur.exercice2.hautNiveau;

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