package model;

public class Viaggi {

	private int idViaggio ;
	private String destinazione , dataininzio , datafine ;
	private double prezzo ;
	private int disponibilita , numeropersone, quantità ;
	public int getIdViaggio() {
		return idViaggio;
	}
	public void setIdViaggio(int idViaggio) {
		this.idViaggio = idViaggio;
	}
	public String getDestinazione() {
		return destinazione;
	}
	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}
	public String getDataininzio() {
		return dataininzio;
	}
	public void setDataininzio(String dataininzio) {
		this.dataininzio = dataininzio;
	}
	public String getDatafine() {
		return datafine;
	}
	public void setDatafine(String datafine) {
		this.datafine = datafine;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public int getDisponibilita() {
		return disponibilita;
	}
	public void setDisponibilita(int disponibilita) {
		this.disponibilita = disponibilita;
	}
	public int getNumeropersone() {
		return numeropersone;
	}
	public void setNumeropersone(int numeropersone) {
		this.numeropersone = numeropersone;
	}

	public int getQuantità() {
		return quantità;
	}
	public void setQuantità(int quantità) {
		this.quantità = quantità;
	}
	@Override
	public String toString() {
		return "Viaggi [idViaggio=" + idViaggio + ", destinazione=" + destinazione + ", dataininzio=" + dataininzio
				+ ", datafine=" + datafine + ", prezzo=" + prezzo + ", disponibilita=" + disponibilita
				+ ", numeropersone=" + numeropersone + ", quantità=" + quantità + "]";
	}
	  
	
	
}
