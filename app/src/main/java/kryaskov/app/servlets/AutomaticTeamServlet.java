package kryaskov.app.servlets;


import kryaskov.app.game.WebMatch;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("automatic")
public class AutomaticTeamServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);

        PrintWriter printWriter = response.getWriter();

        printWriter.write("<h3 style=\"color: darkgoldenrod\">Automatic team creation</h3>" + "<br/>");

        printWriter.write("<form action = \"play\" method = \"POST\" >\n" +

                "<input type=\"hidden\" name=\"method\" value=\"automatic\"/>" +

                "<input type = \"submit\" value = \"Play\" />" +
                "<hr>" +
                "<br>" +

                "<input type = \"checkbox\" name = \"useInputName\" /> Use defined names*\n" +
                "<br>" +
                "<br>" +

                "1st team name: <input type = \"text\" name = \"team1Name\" />\n" + "<p/>" +
                "2nd team name: <input type = \"text\" name = \"team2Name\" />\n" + "<p/>" +

                "<h5 style=\"color: red\">*ensure that you have entered the right names of created in past teams</h5>"
        );
    }
}