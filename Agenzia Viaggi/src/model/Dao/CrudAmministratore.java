package model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import control.Connessione;
import model.Clienti;
import model.Idao.ICrudAmministratore;

public class CrudAmministratore extends Connessione implements ICrudAmministratore{

	Connection conn = null; 
	ResultSet rs = null ;
	Statement st = null ;
	PreparedStatement ps = null ;
	String query;
	
	ArrayList<Clienti> lista = new ArrayList<Clienti>();
	
	@Override
	public ArrayList<Clienti> leggiUtenti(Clienti c) {

		try {
			conn = connetti();
			String query = "select * from clienti ";
			st = conn.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()) {
				Clienti c1 = new Clienti();
				c1.setIdCliente(rs.getInt(1));
				c1.setNome(rs.getString(2));
				c1.setCognome(rs.getString(3));
				c1.setTel(rs.getInt(4));
				c1.setUsername(rs.getString(5));
				c1.setPassword(rs.getString(6));
				lista.add(c1);
			}
		}catch(Exception e) {

			e.printStackTrace();

		}
		finally {

		}
		return lista;
	}

	@Override
	public Clienti inserisciUtenti(Clienti c) {
		try {
			conn = connetti () ;
			query = "Insert into clienti (nome, cognome ,telefono ,username ,password )values(?,?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, c.getNome());
			ps.setString(2, c.getCognome());
			ps.setInt(3, c.getTel());
			ps.setString(4, c.getUsername());
			ps.setString(5, c.getPassword());
			ps.executeUpdate();
			ps.close();
			conn.close();

		}
		catch(Exception e) {

			e.printStackTrace();
		}
		return c;

	}

	@Override
	public Clienti eliminaUtenti(Clienti c) {
		try {
			conn = connetti ();
			query = "Delete from clienti where idcliente=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, c.getIdCliente());
			ps.executeUpdate();
			ps.close();
			conn.close();
			
		}
		catch (SQLException e) {

			e.printStackTrace();
		}
		return c;

	}

	@Override
	public Clienti modificaUtenti(Clienti c) {
	try {
		conn = connetti();
		query = "Update clienti set username=?,password=? where idcliente=?";
		ps = conn.prepareStatement(query);
		ps.setString(1, c.getUsername());
		ps.setString(2, c.getPassword());
		ps.setInt(3, c.getIdCliente());
		ps.executeUpdate();
		ps.close();
		conn.close();
	} 
	catch (SQLException e) {
		
		e.printStackTrace();
	}
	return c;
		
	}
}
