package prop.pers;

import static prop.gui.CostantiGUI.RISORSA_IMMAGINE_BIANCO;
import static prop.gui.CostantiGUI.RISORSA_IMMAGINE_GIALLO;
import static prop.gui.LettoreImmagini.leggiImmagineOggetto;

import java.awt.Image;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import prop.gui.CostantiGUI;
import prop.sim.Ambiente;
import prop.sim.Contatto;
import prop.sim.Coordinate;
import prop.sim.CostantiSimulazione;
import prop.sim.GeneratoreCasuale;

public class NonPredicatore extends Persona {

	private static Image immagine = leggiImmagineOggetto(RISORSA_IMMAGINE_BIANCO);
	static private int progId;
	private final int id;
//	private Ambiente ambiente;
//	private Coordinate posizione;    // posizione corrente

	public NonPredicatore(Ambiente ambiente) {		
		super(ambiente);
		this.id=progId++;
//		this.posizione = GeneratoreCasuale.posizioneCasuale();
//		this.id = progId++;
	}
	
	@Override
	public Image getImmagine() {
		return immagine;
	}
	
	public void setImmagine() {
		this.immagine=leggiImmagineOggetto(RISORSA_IMMAGINE_GIALLO);
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
			if(this.getAmbiente().getPersona(c)==null || this.getAmbiente().getPersona(c).getClass()==this.getClass()) {
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
//		return NonPredicatore.class.getSimpleName()+getId();
//	}
	
	public void avvenuto(Contatto contatto) {
		// ( VEDI DOMANDA 2b ) 
		// Metodo invocato ogni qual volta avviene un Contatto con questa
		List<Persona> PredCoinvolti = new LinkedList<Persona>();
		List<Persona> NonPredCoinvolti = new LinkedList<Persona>();
		for(Persona coinvolta : contatto.getCoinvolti()) {
			if(coinvolta instanceof Predicatore) {
				PredCoinvolti.add(coinvolta);
			} else {
				NonPredCoinvolti.add(coinvolta);
			}
		} 
		if(PredCoinvolti.size()>0 && PredCoinvolti.size()<contatto.getCoinvolti().size()) {
			for(Persona p: NonPredCoinvolti) { 
				NonPredicatore np= (NonPredicatore)p;
			if (new GeneratoreCasuale().siVerificaEventoDiProbabilita(CostantiGUI.PROBABILITA_CONVERSIONE)) {
				np.setImmagine();
			}
			}
//		for(int i=0;i<coinvolti.size();i++) {
//			if(coinvolti.get(i).getClass()!= coinvolti.get(i++).getClass()) {
//				if (new GeneratoreCasuale().siVerificaEventoDiProbabilita(CostantiGUI.PROBABILITA_CONVERSIONE)) {
					//this.setImmagine();
//				}
//			}
		}
//		this.setImmagine();
	}

}
