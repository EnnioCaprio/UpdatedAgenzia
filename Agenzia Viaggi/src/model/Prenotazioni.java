package model;

public class Prenotazioni {
	private int idPrenotazioni , idClienti , idViaggi ,quantitapersone;
	
	private double prezzototale;
	
	private Clienti clienti;

	private Viaggi viaggi;
	
	public Clienti getClienti() {
		return clienti;
	}

	public void setClienti(Clienti clienti) {
		this.clienti = clienti;
	}

	public Viaggi getViaggi() {
		return viaggi;
	}

	public void setViaggi(Viaggi viaggi) {
		this.viaggi = viaggi;
	}

	public int getQuantitapersone() {
		return quantitapersone;
	}

	public void setQuantitapersone(int quantitapersone) {
		this.quantitapersone = quantitapersone;
	}

	public int getIdPrenotazioni() {
		return idPrenotazioni;
	}

	public void setIdPrenotazioni(int idPrenotazioni) {
		this.idPrenotazioni = idPrenotazioni;
	}

	public int getIdClienti() {
		return idClienti;
	}

	public void setIdClienti(int idClienti) {
		this.idClienti = idClienti;
	}

	public int getIdViaggi() {
		return idViaggi;
	}

	public void setIdViaggi(int idViaggi) {
		this.idViaggi = idViaggi;
	}

	public double getPrezzototale() {
		return prezzototale;
	}

	public void setPrezzototale(double prezzototale) {
		this.prezzototale = prezzototale;
	}

	@Override
	public String toString() {
		return "Prenotazioni [idPrenotazioni=" + idPrenotazioni + ", idClienti=" + idClienti + ", idViaggi=" + idViaggi
				+ ", quantitapersone=" + quantitapersone + ", prezzototale=" + prezzototale + "]";
	}

}
