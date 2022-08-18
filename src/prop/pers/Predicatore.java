package prop.pers;

import static prop.gui.CostantiGUI.*;
import static prop.gui.LettoreImmagini.leggiImmagineOggetto;

import java.awt.Image;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import prop.sim.Ambiente;
import prop.sim.Contatto;
import prop.sim.Coordinate;
import prop.sim.GeneratoreCasuale;

public class Predicatore extends Persona {

	static final private Image IMMAGINE_ROSSA = leggiImmagineOggetto(RISORSA_IMMAGINE_ROSSO);
	static private int progId;
	private final int id;
//	private Ambiente ambiente;
//	private Coordinate posizione;    // posizione corrente

	public Predicatore(Ambiente ambiente) {		
		super(ambiente);
//		this.posizione = GeneratoreCasuale.posizioneCasuale();
		this.id = progId++;
	}
	@Override
	public Image getImmagine() {
		return IMMAGINE_ROSSA;
	}
	
	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void mossa() {
		List<Coordinate> adiacenti = new LinkedList<>(this.getAmbiente().adiacentiA(this.getPosizione()));
//		Collections.shuffle(adiacenti);
//		this.setPosizione(adiacenti.get(0));
		List<Coordinate> possibili = new LinkedList<>();
		for(Coordinate c:adiacenti) {
			if(this.getAmbiente().getPersona(c)!=null || this.getAmbiente().getPersona(c).getClass()!=this.getClass()) {
				possibili.add(c);
			} 
		}
		if(possibili.size()!=0) {
		this.setPosizione(possibili.get(0));		
		} else {
			Collections.shuffle(adiacenti);
			this.setPosizione(adiacenti.get(0));
		}
	}

//	@Override
//	public String toString() {
//		return Predicatore.class.getSimpleName()+getId();
//	}
	public void avvenuto(Contatto contatto) {
		// ( VEDI DOMANDA 2b ) 
		// Metodo invocato ogni qual volta avviene un Contatto con questa
	}

}
