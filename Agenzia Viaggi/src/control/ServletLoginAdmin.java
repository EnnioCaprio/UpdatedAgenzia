package control;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Clienti;
import model.Dao.CrudAmministratore;
@WebServlet ("/loginAdmin")
public class ServletLoginAdmin extends HttpServlet{

	private static final long serialVersionUID = 1L;
	Clienti c = new Clienti();
	CrudAmministratore cc = new CrudAmministratore();
	int idcliente;

	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int x = Integer.parseInt(request.getParameter("x"));
		switch(x) {

		case 1:
			getServletContext().getRequestDispatcher("/loginAdmin/loginAdmin.jsp").forward(request, response);
			break;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		PrintWriter out = response.getWriter();
		int y = Integer.parseInt(request.getParameter("y"));
		switch(y) 
		{
		case 1:
			String user = "root";
			String pass = "root";
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if(username.equals(user) && password.equals(pass)) {
				HttpSession session = request.getSession();
				session.setAttribute("userAdmin", user);
				session.setAttribute("passAdmin", pass);
				getServletContext().getRequestDispatcher("/admin/menuAdmin.jsp").forward(request, response);

			}
			else 
			{
				out.println("<h1>Errore, i dati inseriti non sono corretti.</h1>");
				out.println("<a href="+ "loginAdmin?x=1"+ ">Clicca qui per tornare alla pagina di login.</a>");
			}
			break;
		case 2:
			idcliente = Integer.parseInt(request.getParameter("idcliente"));
			c.setIdCliente(idcliente);
			cc.eliminaUtenti(c);
			break;

		}
	}
}
