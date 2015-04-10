package com.gc;

import static com.gc.Engine.OUR_ENGINE;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

@SuppressWarnings("serial")
@WebServlet("/LlServlet")
public class LlServlet extends HttpServlet {
	private String url;
	private String userUrl;
	private Document doc;
	private String htmlBody;
	private Holder ourHolder = new Holder();
	private String newBody;
	private String newHtml;
	private String[] language;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		url = "/index.html";
		userUrl = request.getParameter("userUrl");
		doc = Jsoup.connect(userUrl).get();
		htmlBody = doc.select("body").html();
		language = request.getParameterValues("language");
		
		ourHolder.setBody(htmlBody);
		ourHolder.setLanguage(language[0]);
		ourHolder = OUR_ENGINE.ourEngine(ourHolder);

		newBody = ourHolder.getBody();
		doc.select("body").empty();
		doc.select("body").html(newBody);
		newHtml = doc.toString();
		ourHolder.setBody(newHtml.toString());

		request.setAttribute("ourHolder", ourHolder);
		response.setContentType("text/html");

		url = "/result.jsp";
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
