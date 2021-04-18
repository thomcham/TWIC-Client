package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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

@WebServlet("/listeVilles")
public class ListeVilles extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListeVilles() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		URL url = new URL("http://localhost:8181/getVille");
		// Open a connection(?) on the URL(??) and cast the response(???)
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// Now it's "open", we can set the request method, headers etc.
		connection.setRequestProperty("accept", "application/json");

		// This line makes the request
		InputStream resp = connection.getInputStream();

		// Manually converting the response body InputStream to APOD using Jackson
		ObjectMapper mapper = new ObjectMapper();

		List<Ville> liste = mapper.readValue(resp,new TypeReference<List<Ville>>(){});
		
		int nbVilles = liste.size();
		session.setAttribute("nbVilles", nbVilles);
		session.setAttribute("liste", liste);
		this.getServletContext().getRequestDispatcher("/WEB-INF/listeVilles.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/listeVilles.jsp").forward(request, response);
	}

}
