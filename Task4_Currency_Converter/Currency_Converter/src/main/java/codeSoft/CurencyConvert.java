package Task4_Currency_Converter.src.main.java.codeSoft;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
/**
 * Servlet implementation class CurencyConvert
 */
public class CurencyConvert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CurencyConvert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String quantity = request.getParameter("quantity");
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		
		HttpRequest req = HttpRequest.newBuilder()
				.uri(URI.create("https://currency-converter18.p.rapidapi.com/api/v1/convert?from="+from+"&to="+to+"&amount="+quantity))
				.header("X-RapidAPI-Key", "e210676565msh38cfc155e66e84dp1ee6e9jsn4c2728904fec")
				.header("X-RapidAPI-Host", "currency-converter18.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> resp = null;
		try {
			resp = HttpClient.newHttpClient().send(req, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String respObject = resp.body().toString();
		Gson gson = new Gson();
		JsonObject jsonObject = gson.fromJson(respObject, JsonObject.class);
		JsonObject resultObject = jsonObject.getAsJsonObject("result");
		double result = resultObject.get("convertedAmount").getAsDouble();
		request.setAttribute("result", result);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	}

}
