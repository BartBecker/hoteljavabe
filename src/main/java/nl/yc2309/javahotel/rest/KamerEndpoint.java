package nl.yc2309.javahotel.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.yc2309.javahotel.domein.Kamer;
import nl.yc2309.javahotel.domein.Reservering;
import nl.yc2309.javahotel.persistence.KamerService;
import nl.yc2309.javahotel.persistence.ReserveringService;

@RestController
public class KamerEndpoint {
	@Autowired
	KamerService ks;
	
	@Autowired
	ReserveringService rs;
	
	
	@GetMapping("dekamers") // wat voor verzoek? in url bar
	public Iterable<Kamer> alleKamers() {
		return ks.geefAlleKamers();
	}
	
	@GetMapping("dekamer/{id}")
	public Optional<Kamer> kamer(@PathVariable long id) {
		return ks.geefKamer(id);
	}
	
	@PostMapping("voegkamertoe")
	public Kamer voegKamerToe(@RequestBody Kamer kamer) {
		return ks.slaKamerOp(kamer);
	}
	
	@PutMapping("updatekamer")
	public Kamer updateKamer(@RequestBody Kamer kamer) {
		return ks.updateKamer(kamer);
	}
	
	@DeleteMapping("verwijderkamer/{kamerid}")
	public void verwijderKamer(@PathVariable("kamerid") int kamerid) {
		ks.verwijderKamer(kamerid);
	}
	
	@GetMapping("voegkameraanreserveringtoe/{kamerid}/{reserveringid}")
	public void kenKamerAanReserveringToe(@PathVariable("kamerid") long kamerid, @PathVariable("reserveringid")long reservering) {
		ks.kenkamertoeaanreservering(kamerid, reservering);
		
	}
	
	@PostMapping("voegreserveringtoeaankamer/{kamerid}")
	public void kenReserveringAanKamerToe(@PathVariable("kamerid") long kamerid, Reservering reservering) {
		ks.kenkamertoeaannieuwereservering(kamerid, reservering);
		
	}
}
