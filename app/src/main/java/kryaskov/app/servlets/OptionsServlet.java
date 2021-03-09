package kryaskov.app.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/options")
public class OptionsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        printWriter.write("<h3 style=\"color: cadetblue\">Choose the way of team creation</h3>" + "<br/>");

        printWriter.write("<form action = \"distributor\" method = \"POST\" >\n" +
                "<input type = \"checkbox\" name = \"automatic\" checked = \"checked\" /> Automatic team creation\n" +
                "<input type = \"submit\" value = \"Continue\" />");

        printWriter.close();
    }
}