import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "ProductServlet", urlPatterns = "/productServlet")
public class ProductServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(ProductServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Open product list");
        //logger.info("User agent: {}", req.getHeader("User agent"));

        Product product1 = new Product(1, "Apple", 10);
        Product product2 = new Product(2, "Orange", 20);
        Product product3 = new Product(3, "Mango", 30);
        Product product4 = new Product(4, "Kiwi", 40);
        Product product5 = new Product(5, "Banana", 50);
        Product product6 = new Product(6, "Grapefruit", 60);
        Product product7 = new Product(7, "Lemon", 70);
        Product product8 = new Product(8, "Watermelon", 80);
        Product product9 = new Product(9, "Garnet", 90);
        Product product10 = new Product(10, "Grape", 100);

        resp.getWriter().println("Product ID" + "               " + "Product Name" + "               " + "Product Cost");
        resp.getWriter().println(product1.id + "               " + product1.title + "               " + product1.cost);
        resp.getWriter().println(product2.id + "               " + product2.title + "               " + product2.cost);
        resp.getWriter().println(product3.id + "               " + product3.title + "               " + product3.cost);
        resp.getWriter().println(product4.id + "               " + product4.title + "               " + product4.cost);
        resp.getWriter().println(product5.id + "               " + product5.title + "               " + product5.cost);
        resp.getWriter().println(product6.id + "               " + product6.title + "               " + product6.cost);
        resp.getWriter().println(product7.id + "               " + product7.title + "               " + product7.cost);
        resp.getWriter().println(product8.id + "               " + product8.title + "               " + product8.cost);
        resp.getWriter().println(product9.id + "               " + product9.title + "               " + product9.cost);
        resp.getWriter().println(product10.id + "              " + product10.title + "              " + product10.cost);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New POST request");
    }
}

