package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Clienti;
import model.Prenotazioni;
import model.Viaggi;
import model.Dao.CrudPrenotazioni;
import model.Dao.CrudUtente;
import model.Dao.CrudViaggi;

@WebServlet("/menuCliente")
public class MenuCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CrudPrenotazioni cr = new CrudPrenotazioni();
		int x=Integer.parseInt(request.getParameter("x"));
		switch(x) {
		case 1: 
			getServletContext().getRequestDispatcher("/clienti/infocliente.jsp").forward(request, response);
			break;
		case 2:
			getServletContext().getRequestDispatcher("/clienti/logoutCliente.jsp").forward(request, response);
			break;
		case 3: 
			getServletContext().getRequestDispatcher("/clienti/prenotazione.jsp").forward(request, response);
			break;
		case 4:
			getServletContext().getRequestDispatcher("/clienti/listaPrenotazioni.jsp").forward(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		CrudPrenotazioni cr = new CrudPrenotazioni();
		Clienti c = new Clienti();
		Viaggi v = new Viaggi();
		Prenotazioni p = new Prenotazioni() ;
		int y = Integer.parseInt(request.getParameter("y"));
		String nome;
		String cognome;
		int telefono, idCliente;
		String username;
		String password;
		int idViaggio;
		int idPrenotazione;
		int quantitapersone;
		double prezzoTotale;
		CrudUtente cu = new CrudUtente();
		switch(y) {
		case 1:
			idCliente = Integer.parseInt(request.getParameter("idCliente"));
			nome = request.getParameter("nomeCliente");
			cognome = request.getParameter("cognomeCliente");
			telefono = Integer.parseInt(request.getParameter("telefono"));
			username = request.getParameter("username");
			password = request.getParameter("password");
			c.setNome(nome);
			c.setCognome(cognome);
			c.setTel(telefono);
			c.setUsername(username);
			c.setPassword(password);
			c.setIdCliente(idCliente);
			cu.modificaInformazioni(c);
			getServletContext().getRequestDispatcher("/clienti/menuCliente.jsp").forward(request, response);
			break;
		case 2:
			HttpSession session = request.getSession();
			CrudViaggi cv = new CrudViaggi();
			ArrayList<Viaggi> listVi = cv.listaViaggi(v);
			int idClienti = (int) session.getAttribute("idCliente");
			idViaggio = Integer.parseInt(request.getParameter("idViaggio"));
			quantitapersone = Integer.parseInt(request.getParameter("quantitapersone"));
			Double prezzo = 0.00;
			boolean flag = false;
			for(Viaggi vi2 : listVi) {
				int disponibilità = vi2.getDisponibilita();
				if(disponibilità == 1) {
					flag = true;
					for(Viaggi vi : listVi) {
						prezzo = vi.getPrezzo();
						double newPrezzo = (prezzo * 28)/100;
						Double prezzoTota = (newPrezzo * quantitapersone) + prezzo;
						p.setPrezzototale(prezzoTota);
					}
					p.setQuantitapersone(quantitapersone);
					c.setIdCliente(idClienti);
					v.setIdViaggio(idViaggio);
					cr.inserisciPrenotazioni(c, v, p);
				}
				if(disponibilità == 0 && flag == false) {
					out.println("<h1>0</h1>");
				}
			}
			break;
		case 3:
			idPrenotazione= Integer.parseInt(request.getParameter("idprenotazione")); 
			p.setIdPrenotazioni(idPrenotazione);
			cr.annullaPrenotazioni(p);
			getServletContext().getRequestDispatcher("/clienti/menuCliente.jsp").forward(request, response);
			break;
		case 4:
			break;
		}
	}

}
