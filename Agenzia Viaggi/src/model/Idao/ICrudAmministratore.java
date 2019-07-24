package model.Idao;

import java.util.ArrayList;

import model.Clienti;


public interface ICrudAmministratore {

	public ArrayList<Clienti> leggiUtenti(Clienti c) ;
	public Clienti inserisciUtenti (Clienti c);
	public Clienti eliminaUtenti(Clienti c);
	public Clienti modificaUtenti(Clienti c);
	
	
}
