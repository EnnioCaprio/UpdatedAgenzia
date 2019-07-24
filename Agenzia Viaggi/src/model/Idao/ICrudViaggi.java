package model.Idao;

import java.util.ArrayList;

import model.Viaggi;

public interface ICrudViaggi 
{
public Viaggi inserisciViaggio(Viaggi v);
public ArrayList<Viaggi> listaViaggi(Viaggi v);
public Viaggi eliminaViaggio(Viaggi v);
public Viaggi modificaViaggio(Viaggi v);
}
