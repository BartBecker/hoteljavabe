package nl.yc2309.javahotel.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nl.yc2309.javahotel.domein.Kamer;
import nl.yc2309.javahotel.domein.Reservering;


@Service
public class KamerService {
	// Has relatie met Kamer repository
	@Autowired
	KamerRepository kr;
	
	@Autowired
	ReserveringRepository RR;
	//-------------------------------------------
	// methode view
	
	
	public Iterable<Kamer> geefAlleKamers() {
		return kr.findAll();
	}

	// opslaan
	public Kamer slaKamerOp(Kamer kamer) {
		return kr.save(kamer);	
	}
	// update
	public Kamer updateKamer(Kamer kamer) {
		System.out.println("update kamer");
		return kr.save(kamer);
	}
	// verwijderen
	public void verwijderKamer(long kamerid) {
		kr.deleteById(kamerid);	
	}

	public void kenkamertoeaanreservering(long v, long reservering) {
		// TODO Auto-generated method stub
		Kamer K = kr.findById(v).get();
		Reservering R = RR.findById(reservering).get();
		R.setKamer(K);
		RR.save(R);
	}
	
	
	
}
