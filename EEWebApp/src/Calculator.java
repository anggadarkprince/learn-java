import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * EEWebApp
 * Created by Angga on 31/07/2016.
 */
@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String firstNumber = req.getParameter("firstNumber");
        String secondNumber = req.getParameter("secondNumber");
        int sum = Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber);
        writer.println("The sum of " + firstNumber + " and " + secondNumber + " is " + sum);
    }
}
