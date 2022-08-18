package prop.stats;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import prop.sim.Contatto;
import prop.sim.Simulatore;

/**
 * <B>DA COMPLETARE (VEDI DOMANDA 3)</B>
 */
public class Statistiche {

	synchronized public void stampaFinale(Simulatore simulatore) {
		final List<Contatto> contatti = simulatore.getContatti();

		System.out.println(contatti.size() + " contatti rilevati." );
		System.out.println(simulatore.getContatti());
		System.out.println();

		final Map<Integer,Set<Contatto>> mappa = produciStatistiche(simulatore.getContatti());
		System.out.println("Contatti per persona:");
		stampaStatistiche(mappa);
		System.out.println();
	}

	public Map<Integer, Set<Contatto>> produciStatistiche(List<Contatto> contatti) {
		// DA COMPLETARE (VEDI DOMANDA 3)
		Map<Integer, Set<Contatto>> mappa = new TreeMap<Integer, Set<Contatto>>();
		for(Contatto c: contatti) {
			if(mappa.containsKey(c.getPassoSimulazione())) {
				mappa.get(c.getPassoSimulazione()).add(c);
//				Collections.sort(mappa.get(c.getPassoSimulazione()));
			} else {
				Set<Contatto> cont = new TreeSet<Contatto>();
				cont.add(c);
				mappa.put(c.getPassoSimulazione(), cont);
			}
		}
		
		return mappa;
	}

	/**
	 * <EM>N.B. UTILE PER STAMPARE RISULTATI DOMANDA 3</EM>
	 */
	private void stampaStatistiche(final Map<Integer, Set<Contatto>> mappa) {
		for(Integer key : mappa.keySet()) {
			final Set<Contatto> l = mappa.get(key);
			System.out.print(key + " è stato coinvolto in :");
			for(Contatto c : l) 
				System.out.print(c.toString() + " ");
			System.out.println();
		}
	}
}
