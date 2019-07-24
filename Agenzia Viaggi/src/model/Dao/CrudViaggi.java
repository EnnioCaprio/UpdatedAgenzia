package model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import control.Connessione;
import model.Viaggi;
import model.Idao.ICrudViaggi;

public class CrudViaggi extends Connessione implements ICrudViaggi 
{
	Connection conn=null;
	Statement s=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String query;
	
	ArrayList<Viaggi> lista = new ArrayList<>();
	
	@Override
	public Viaggi inserisciViaggio(Viaggi v) 
	{
		try 
		{
			conn=connetti();
			query="Insert into viaggi (destinazione,prezzo,disponibilità,datainizio,datafine,quantita) values(?,?,?,?,?,?)";
			ps=conn.prepareStatement(query);
			ps.setString(1, v.getDestinazione());
			ps.setDouble(2, v.getPrezzo());
			ps.setInt(3, v.getDisponibilita());
			ps.setString(4, v.getDataininzio());
			ps.setString(5, v.getDatafine());
			ps.setInt(6, v.getQuantità());
			ps.executeUpdate();
			ps.close();
			conn.close();
		} 
		catch (SQLException e) 
		{

			e.printStackTrace();
		}
		return v;



	}
	@Override
	public ArrayList<Viaggi> listaViaggi(Viaggi v) 
	{

		try {
			conn=connetti();
			query="Select * from viaggi";
			s=conn.createStatement();
			rs=s.executeQuery(query);
			while(rs.next()) {
				Viaggi v1 = new Viaggi();
				v1.setIdViaggio(rs.getInt(1));
				v1.setDestinazione(rs.getString(2));
				v1.setPrezzo(rs.getDouble(3));
				v1.setDisponibilita(rs.getInt(4));
				v1.setDataininzio(rs.getString(5));
				v1.setDatafine(rs.getString(6));
				v1.setQuantità(rs.getInt(7));
				lista.add(v1);
			}
		} catch (SQLException e) 
		{

			e.printStackTrace();
		}

		return lista;
	}
	@Override
	public Viaggi eliminaViaggio(Viaggi v) 
	{
		try {
			conn = connetti ();
			query = "Delete from viaggi where idviaggi=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1,v.getIdViaggio());
			ps.executeUpdate();
			ps.close();
			conn.close();
		}
		catch (SQLException e) {

			e.printStackTrace();
		}
		return v;

	}
	@Override
	public Viaggi modificaViaggio(Viaggi v) 
	{
		try
		{
			conn=connetti();
			query="Update viaggi set quantita=? where idviaggi=?";
			ps=conn.prepareStatement(query);
			ps.setInt(1, v.getQuantità());
			ps.setInt(2, v.getIdViaggio());
			ps.executeUpdate();
			ps.close();
		} 
		catch (SQLException e) 
		{

			e.printStackTrace();
		}
		return v;


	}

}




