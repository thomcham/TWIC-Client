package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
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


@WebServlet("/DetailsVille")
public class DetailsVille extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DetailsVille() {
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
		
		String num = request.getParameter("numero");
		Ville v = liste.get(Integer.parseInt(num));
		
		session.setAttribute("ville", v);
		session.setAttribute("liste", liste);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/detailsVille.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		String nvNom = request.getParameter("nom");
		String nvCP = request.getParameter("codePostal");
		String nvLib = request.getParameter("lib");
		String nvLigne = request.getParameter("ligne");
		String nvLat = request.getParameter("lat");
		String nvLon = request.getParameter("lon");
		code = code.replaceAll("\\s", "");
		nvCP = nvCP.replaceAll("\\s", "");
		nvLat = nvLat.replaceAll("\\s", "");
		nvLon = nvLon.replaceAll("\\s", "");
		nvNom = nvNom.replaceAll("\\s", "+");
		nvCP = nvCP.replaceAll("\\s", "+");
		nvLib = nvLib.replaceAll("\\s", "+");
		nvLigne = nvLigne.replaceAll("\\s", "+");

		URL url = new URL("http://localhost:8181/putVille?code="+code+"&nom="+nvNom+"&codePostal="+nvCP+"&libelle="+nvLib+"&ligne="+nvLigne+"&latitude="+nvLat+"&longitude="+nvLon);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setRequestMethod("PUT");
		OutputStreamWriter out = new OutputStreamWriter(
				connection.getOutputStream());
		out.write("Resource content");
		out.close();
		connection.getInputStream();
		
		doGet(request, response);
	}

}
