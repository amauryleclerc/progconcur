package prog2.concur.exercice2.hautNiveau;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.w3c.dom.views.AbstractView;


public  class FileBloquanteBorneeHautNiveau<E> extends AbstractFileBloquanteBornee<E>
{
	Lock lock;
	Condition condPlein;
	Condition condVide;

	public FileBloquanteBorneeHautNiveau(int n) throws IllegalArgumentException {
		super(n);
		lock = new ReentrantLock();
		condPlein = lock.newCondition();
		condVide = lock.newCondition();
	}

	@Override
	public  void deposer(E e) throws InterruptedException {
		lock.lock();
		if(this.estPleine){
			condPlein.await();
		}
		
			this.tableau[this.queue] = e;
			this.queue ++;
			this.estVide = false;
		
	
		if(this.queue == this.tableau.length){
			this.queue = 0;
		}
		if(this.queue == this.tete){
			this.estPleine = true;
		}
		condVide.signal();
		
	}

	@Override
	public  E prendre() throws InterruptedException {
		lock.lock();
		E e = null ;
		if(this.estVide){
			condVide.await();
			
		}
			e =this.tableau[this.tete];
			this.tete++;
			this.estPleine = false;
		
		
		if(this.tete == this.tableau.length){
			this.tete = 0;
		}
		if(this.tete == this.queue){
			this.estVide = true;
		}
		condPlein.signal();
		return e;
	}
	

}
