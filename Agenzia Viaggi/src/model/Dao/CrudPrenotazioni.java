package model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import control.Connessione;
import model.Clienti;
import model.Prenotazioni;
import model.Viaggi;
import model.Idao.ICrudPrenotazioni;

public class CrudPrenotazioni extends Connessione implements ICrudPrenotazioni{

	Connection conn = null;
	PreparedStatement ps = null;
	Statement s = null;
	ResultSet rs = null;
	String query;

	ArrayList<Prenotazioni> list = new ArrayList<Prenotazioni>();

	@Override
	public Prenotazioni inserisciPrenotazioni(Clienti c, Viaggi v, Prenotazioni p) {
		try {
			conn = connetti();
			query = "insert into prenotazione(idcliente, idviaggio,quantitapersone, prezzototale) values (?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setInt(1, c.getIdCliente());
			ps.setInt(2, v.getIdViaggio());
			ps.setInt(3, p.getQuantitapersone());
			ps.setDouble(4, p.getPrezzototale());
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public ArrayList<Prenotazioni> listaPrenotazioni() {
		try {
			conn = connetti();
			query ="Select prenotazione.idprenotazione, viaggi.destinazione, viaggi.datainizio, viaggi.datafine, prenotazione.prezzototale, prenotazione.quantitapersone, viaggi.prezzo from clienti \r\n" + 
					"inner join prenotazione \r\n" + 
					"on clienti.idcliente=prenotazione.idcliente \r\n" + 
					"inner join viaggi\r\n" + 
					"on prenotazione.idviaggio=viaggi.idviaggio";
			s = conn.createStatement();
			rs = s.executeQuery(query);
			while(rs.next()) {
				Viaggi v = new Viaggi();
				Prenotazioni p = new Prenotazioni();
				p.setIdPrenotazioni(rs.getInt(1));
				v.setDestinazione(rs.getString(2));
				v.setDataininzio(rs.getString(3));
				v.setDatafine(rs.getString(4));
				p.setPrezzototale(rs.getDouble(5));
				p.setViaggi(v);
				p.setQuantitapersone(rs.getInt(6));
				list.add(p);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;

	}

	@Override
	public Prenotazioni annullaPrenotazioni(Prenotazioni p) {
		try {
			conn = connetti();
			query = "delete from prenotazione where idprenotazione = ?";
			ps=conn.prepareStatement(query);
			ps.setInt(1, p.getIdPrenotazioni());
			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return p;


	}



}
