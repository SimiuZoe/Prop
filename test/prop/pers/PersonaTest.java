package prop.pers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

//import prop.pers.NonPredicatore;
//import prop.pers.Predicatore;
import prop.sim.Ambiente;

/** 
 * Suggerimento: Controllare che questi test abbiano successo sia
 * prima che dopo aver operato le modifiche suggerite<BR/>
 * RIVEDERE {@link #testIdProgressiviPerSani()}<BR/>
 * COMPLETARE {@link #testIdProgressiviPerSaniEInfetti()}<BR/>
 * <B>(VEDI DOMANDA 2)</B>
 */
public class PersonaTest {

	private Ambiente ambiente;
	
	@Before
	public void setUp() throws Exception {
		this.ambiente = new Ambiente();
	}

	@Test
	public void testIdProgressiviPerPersoneStessoTipo() {
		// DA RIVEDERE VEDI DOMANDA 2a
		Persona p1 = new NonPredicatore(ambiente);
		Persona p = new NonPredicatore(ambiente);
		assertEquals("Gli id sono progressivi base 0", 0, p1.getId());
		assertEquals("Gli id sono progressivi base 0", 1, p.getId());
	}

	@Test
	public void testIdProgressiviPerPersoneTipoDiverso() {
		// DA COMPLETARE VEDI DOMANDA 2a
		// Tipi di persone diverse hanno la stessa serie di id progressivi
		Ambiente a = new Ambiente();
		Persona p3 = new NonPredicatore(a);
		Persona p = new Predicatore(a);
		System.out.println("id NonPredicatore" + p3.getId());
		System.out.println("id Predicatore" + p.getId());
		assertEquals("Gli id sono progressivi base 0", 0, p3.getId());
		assertEquals("Gli id sono progressivi base 0", 0, p.getId());
//		fail("DA COMPLETARE");
	}
	
//	@Test
//	public void stampa() {
//		Persona p = new Predicatore(ambiente);
//		Persona p1 = new NonPredicatore(ambiente);
//		Persona p2 = new Predicatore(ambiente);
//		Persona p3 = new NonPredicatore(ambiente);
//		System.out.println(p);
//		System.out.println(p1);
//		System.out.println(p2);
//		System.out.println(p3);
//	}

}
