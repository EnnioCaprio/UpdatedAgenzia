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
import model.Viaggi;
import model.Dao.CrudAmministratore;

@WebServlet("/loginCliente")
public class ServletLoginClienti extends HttpServlet {
	String username, password, nome,cognome;
	int telefono,idcliente;
	Clienti c = new Clienti ();
	CrudAmministratore cc = new CrudAmministratore();
	Viaggi v = new Viaggi ();

	private static final long serialVersionUID = 1L;

	public void doGet (HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		int x = Integer.parseInt(request.getParameter("x"));		
		switch (x) {
		case 1 : getServletContext().getRequestDispatcher("/login/login.jsp").forward(request, response);
		break;
		case 2 : getServletContext().getRequestDispatcher("/login/registrazione.jsp").forward(request, response);
		break;
		case 3: getServletContext().getRequestDispatcher("/login/logout.jsp").forward(request, response);
		break;
		}
	}

	public void doPost (HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		int y = Integer.parseInt(request.getParameter("y"));
		switch (y) {
		case 1 : 
			username = request.getParameter("username");
			password = request.getParameter("password");
			c.setPassword(password);
			c.setUsername(username);
			boolean flag = false;
			ArrayList<Clienti> lista = cc.leggiUtenti(c);
			System.out.println(lista);
			for(Clienti l : lista) {
				if(l.getUsername().equals(username) && l.getPassword().equals(password)) {
					HttpSession session = request.getSession();
					session.setAttribute("idCliente", l.getIdCliente());
					session.setAttribute("nomeCliente", l.getNome());
					session.setAttribute("cognomeCliente", l.getCognome());
					session.setAttribute("telefono", l.getTel());
					session.setAttribute("username", l.getUsername());
					session.setAttribute("password", l.getPassword());
					flag = true;
				}
			}
			if(flag == false) {
				out.println("<h1>Errore, i dati inseriti non sono corretti.</h1>");
				out.println("<a href="+ "loginCliente?x=1"+ ">Clicca qui per tornare alla pagina di login.</a>");
			}else if(flag == true) {
				getServletContext().getRequestDispatcher("/clienti/menuCliente.jsp").forward(request, response);
			}
			break;
		case 2 :
			username = request.getParameter("username");
			password = request.getParameter("password");
			nome = request.getParameter("nome");
			cognome = request.getParameter("cognome");
			telefono = Integer.parseInt(request.getParameter("telefono"));
			c.setUsername(username);
			c.setPassword(password);
			c.setNome(nome);
			c.setCognome(cognome);
			c.setTel(telefono);
			cc.inserisciUtenti(c);
			break;	 

		}


	}


}
