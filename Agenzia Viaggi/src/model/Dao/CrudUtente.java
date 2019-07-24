package model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import control.Connessione;
import model.Clienti;
import model.Idao.ICrudUtente;

public class CrudUtente extends Connessione implements ICrudUtente
{
	Connection conn=null;
	PreparedStatement ps=null;
	Statement s=null;
	ResultSet rs=null;

	@Override
	public Clienti modificaInformazioni(Clienti c) {
		try {
			conn = connetti();
			String query = "update clienti set nome=?, cognome=?, telefono=?, username=?, password=? where idCliente = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, c.getNome());
			ps.setString(2, c.getCognome());
			ps.setInt(3, c.getTel());
			ps.setString(4, c.getUsername());
			ps.setString(5, c.getPassword());
			ps.setInt(6, c.getIdCliente());
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
		
	}

}
