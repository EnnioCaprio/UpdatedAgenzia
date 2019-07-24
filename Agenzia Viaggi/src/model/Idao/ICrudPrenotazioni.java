package model.Idao;

import java.util.ArrayList;

import model.Clienti;
import model.Prenotazioni;
import model.Viaggi;

public interface ICrudPrenotazioni {
	
	public Prenotazioni annullaPrenotazioni (Prenotazioni p);
	Prenotazioni inserisciPrenotazioni(Clienti c, Viaggi v, Prenotazioni p);
	public ArrayList<Prenotazioni> listaPrenotazioni();

}
