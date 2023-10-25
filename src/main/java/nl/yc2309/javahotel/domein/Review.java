package nl.yc2309.javahotel.domein;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 1000)
	private String tekst;
	private int waardering;
	private LocalDate datum;
	//private Image image;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTekst() {
		return tekst;
	}
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	public int getWaardering() {
		return waardering;
	}
	public void setWaardering(int waardering) {
		this.waardering = waardering;
	}
	/*public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}*/
	public LocalDate getDatum() {
		return datum;
	}
	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}
	
	
}
