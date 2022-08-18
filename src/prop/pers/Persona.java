package prop.pers;

import java.awt.Image;

import prop.sim.Ambiente;
import prop.sim.Contatto;
import prop.sim.Coordinate;
import prop.sim.GeneratoreCasuale;

public abstract class Persona {
//	static private int progId;
//	protected int id;
	private Ambiente ambiente;
	private Coordinate posizione;
	
	public Persona(Ambiente ambiente) {		
		this.ambiente = ambiente;
		this.posizione = GeneratoreCasuale.posizioneCasuale();
//		this.id = progId++;
	}
	
	public Ambiente getAmbiente() {
		return this.ambiente;
	}
	
	public abstract Image getImmagine();
	
	public abstract int getId(); 
//	{
//		return this.id;
//	}
	
	public Coordinate getPosizione() {
		return this.posizione;
	}

	public void setPosizione(Coordinate nuova) {
		this.posizione = nuova;
	}
	
	public abstract void mossa();
	
	@Override
	public String toString() {
		return "Oggetto:" + getClass().getSimpleName() + getId();
	}

	public abstract void avvenuto(Contatto contatto);
}
