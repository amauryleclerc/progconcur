package prog2.concur.exercice2.v2;

import java.util.ArrayList;

import org.w3c.dom.views.AbstractView;



public  class FileBloquanteBorneeBasNiveau<E> extends AbstractFileBloquanteBornee<E>
{

	public FileBloquanteBorneeBasNiveau(int n) throws IllegalArgumentException {
		super(n);
		// TODO Auto-generated constructor stub
	}

	@Override
	public  void deposer(E e) throws InterruptedException {
		
		
			this.tableau[this.queue] = e;
			this.queue ++;
			this.estVide = false;
		
	
		if(this.queue == this.tableau.length){
			this.queue = 0;
		}
		if(this.queue == this.tete){
			this.estPleine = true;
		}
		
		
	}

	@Override
	public  E prendre() throws InterruptedException {
		
		E e = null ;
		
		
			e =this.tableau[this.tete];
			this.tete++;
			this.estPleine = false;
		
		
		if(this.tete == this.tableau.length){
			this.tete = 0;
		}
		if(this.tete == this.queue){
			this.estVide = true;
		}
		
		return e;
	}
	

}
