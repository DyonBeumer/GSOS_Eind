package nl.hu.fnt.gsos.rest;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Track
{
	
	private String naam;

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam =  naam;
	}

	public Track(String naam) {

		this.naam = naam;
	}
}