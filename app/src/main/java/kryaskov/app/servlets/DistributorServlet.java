package kryaskov.app.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("distributor")
public class DistributorServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String path = "/automatic";
        if(request.getParameter("automatic") == null) {
            path = "/manual";
        }
        response.sendRedirect(path);
    }
}
