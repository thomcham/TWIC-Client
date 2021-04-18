package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Ville;


@WebServlet("/calcDist")
public class CalcDist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CalcDist() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		URL url = new URL("http://localhost:8181/getVille");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("accept", "application/json");
		InputStream resp = connection.getInputStream();
		ObjectMapper mapper = new ObjectMapper();
		List<Ville> liste = mapper.readValue(resp,new TypeReference<List<Ville>>(){});
		
		session.setAttribute("liste", liste);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/calcDist.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String numV1 = request.getParameter("numVille1");
		String numV2 = request.getParameter("numVille2");


		URL url = new URL("http://localhost:8181/getVille");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("accept", "application/json");
		InputStream resp = connection.getInputStream();
		ObjectMapper mapper = new ObjectMapper();
		List<Ville> liste = mapper.readValue(resp,new TypeReference<List<Ville>>(){});
				
		session.setAttribute("liste", liste);
		
		
		Ville v1 = liste.get(Integer.parseInt(numV1));
		Ville v2 = liste.get(Integer.parseInt(numV2));
		String dist = v1.calculDistance(v2);
		
		session.setAttribute("v1", v1);
		session.setAttribute("v2", v2);

		session.setAttribute("dist", dist);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/calcDist.jsp").forward(request, response);
	}

}
