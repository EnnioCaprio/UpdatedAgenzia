package control;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Viaggi;
import model.Dao.CrudViaggi;

@WebServlet("/menuAdmin")
public class MenuAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int x=Integer.parseInt(request.getParameter("x"));
		switch(x) {
		case 1:
			getServletContext().getRequestDispatcher("/admin/listaUtenti.jsp").forward(request, response);
			break;
		case 2:
			getServletContext().getRequestDispatcher("/admin/inserimentoViaggi.jsp").forward(request, response);
			break;
		case 3:
			getServletContext().getRequestDispatcher("/admin/listaViaggi.jsp").forward(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		Viaggi v=new Viaggi();
		CrudViaggi cv=new CrudViaggi();
		int y=Integer.parseInt(request.getParameter("y"));
		switch(y) {
		case 1: 
			String destinazione=request.getParameter("destinazione");
			double prezzo=Double.parseDouble(request.getParameter("prezzo"));
			String datainizio=request.getParameter("datainizio");
			String datafine=request.getParameter("datafine");
			int quantità=Integer.parseInt(request.getParameter("quantità"));
			v.setDestinazione(destinazione);
			v.setPrezzo(prezzo);
			v.setDataininzio(datainizio);
			v.setDatafine(datafine);
			v.setQuantità(quantità);
			if(quantità > 0) {
				v.setDisponibilita(1);
			}else if(quantità <= 0){
				v.setDisponibilita(0);
			}
			cv.inserisciViaggio(v);
			getServletContext().getRequestDispatcher("/admin/menuAdmin.jsp").forward(request, response);
			break;
		case 2:
			int idViaggio=Integer.parseInt(request.getParameter("idviaggio"));
			v.setIdViaggio(idViaggio);
			cv.eliminaViaggio(v);
			getServletContext().getRequestDispatcher("/admin/menuAdmin.jsp").forward(request, response);
			break;
		case 3:
			idViaggio=Integer.parseInt(request.getParameter("idviaggio"));
			quantità=Integer.parseInt(request.getParameter("quantità"));
			v.setIdViaggio(idViaggio);
			v.setQuantità(quantità);
			cv.modificaViaggio(v);
			getServletContext().getRequestDispatcher("/admin/menuAdmin.jsp").forward(request, response);
			break;
		}
	}

}
