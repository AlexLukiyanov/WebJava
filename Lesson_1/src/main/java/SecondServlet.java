import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;


@WebServlet(name = "SecondServlet", urlPatterns = "/secondServlet")
public class SecondServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(SecondServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New GET request");

        //resp.getWriter().printf("<h1>New GET request with parameters a = %s; b = %s",
        //        req.getParameter("a"), req.getParameter("b"));

        int a = Integer.parseInt(req.getParameter("a"));
        int b = Integer.parseInt(req.getParameter("b"));
        int c = a + b;

        resp.getWriter().println("Операция сложения: a = " + a + "b = " + b + "Сумма равна" + c);


        logger.info("User agent: {}", req.getHeader("User agent"));   // Определение типа браузера
        resp.setHeader("Content-Type", "text/html; charset=utf-8");
        resp.setStatus(200);


        //resp.sendRedirect("https://www.apple.com/ru/");

        //resp.getWriter().println("Pos_1: " + req.getPathInfo() +
        //        "Pos_2: " + req.getMethod() +
        //        "Pos_3: " + req.getContextPath() +
        //        "Pos_4: " + req.getRequestURI());
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New POST request");
        resp.getWriter().printf("<h1>New POST request with body %s</h1>", readAllLines(req.getReader()));
    }

    public String readAllLines(BufferedReader reader) throws IOException { StringBuilder content = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) { content.append(line); content.append(System.lineSeparator());
        }
        return content.toString(); }
}
