package kryaskov.app.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("manual")
public class ManualTeamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        PrintWriter printWriter = response.getWriter();

        printWriter.write("<h3 style=\"color: green\">Manual team creation</h3>" + "<br/>");

        printWriter.write("<form action = \"play\" method = \"POST\" >\n" +

                "<input type=\"hidden\" name=\"method\" value=\"manual\"/>" +

                "1st team name: <input type = \"text\" name = \"team1Name\" />\n" + "<p/>" +
                "2nd team name: <input type = \"text\" name = \"team2Name\" />\n" + "<p/>" +
                "<br>" +
                "<hr/>" +

                "<input type = \"checkbox\" name = \"manualPlayerCreation\" /> Create players manually*\n" +
                "<h5 style=\"color: red\">*if unchecked, players would be created in a random way</h5>" +
                "<br>" +

                "<p>NOTE! The values of players skills should be between 0 and 1 in 'x.xx' format</p>" +
                "<br>" +

                "<p style=\"color: gray\">1st team</p>" +
                "1st player name: <input type = \"text\" name = \"playerName\" />\n" +
                    "serve skill: <input type = \"text\" name = \"playerServe\" />\n" +
                    "attack skill: <input type = \"text\" name = \"playerAttack\" />\n" + "<p/>" +
                "2nd player name: <input type = \"text\" name = \"playerName\" />\n" +
                    "serve skill: <input type = \"text\" name = \"playerServe\" />\n" +
                    "attack skill: <input type = \"text\" name = \"playerAttack\" />\n" + "<p/>" +
                "3rd player name: <input type = \"text\" name = \"playerName\" />\n" +
                    "serve skill: <input type = \"text\" name = \"playerServe\" />\n" +
                    "attack skill: <input type = \"text\" name = \"playerAttack\" />\n" + "<p/>" +
                "4th player name: <input type = \"text\" name = \"playerName\" />\n" +
                    "serve skill: <input type = \"text\" name = \"playerServe\" />\n" +
                    "attack skill: <input type = \"text\" name = \"playerAttack\" />\n" + "<p/>" +
                "5th player name: <input type = \"text\" name = \"playerName\" />\n" +
                    "serve skill: <input type = \"text\" name = \"playerServe\" />\n" +
                    "attack skill: <input type = \"text\" name = \"playerAttack\" />\n" + "<p/>" +
                "6th player name: <input type = \"text\" name = \"playerName\" />\n" +
                    "serve skill: <input type = \"text\" name = \"playerServe\" />\n" +
                    "attack skill: <input type = \"text\" name = \"playerAttack\" />\n" + "<p/>" +

                "<input type = \"checkbox\" name = \"saveTeam1\" /> Save 1st team\n" +
                "<br>" +
                "<br>" +

                "<p style=\"color: gray\">2nd team</p>" +
                "1st player name: <input type = \"text\" name = \"playerName\" />\n" +
                    "serve skill: <input type = \"text\" name = \"playerServe\" />\n" +
                    "attack skill: <input type = \"text\" name = \"playerAttack\" />\n" + "<p/>" +
                "2nd player name: <input type = \"text\" name = \"playerName\" />\n" +
                    "serve skill: <input type = \"text\" name = \"playerServe\" />\n" +
                    "attack skill: <input type = \"text\" name = \"playerAttack\" />\n" + "<p/>" +
                "3rd player name: <input type = \"text\" name = \"playerName\" />\n" +
                    "serve skill: <input type = \"text\" name = \"playerServe\" />\n" +
                    "attack skill: <input type = \"text\" name = \"playerAttack\" />\n" + "<p/>" +
                "4th player name: <input type = \"text\" name = \"playerName\" />\n" +
                    "serve skill: <input type = \"text\" name = \"playerServe\" />\n" +
                    "attack skill: <input type = \"text\" name = \"playerAttack\" />\n" + "<p/>" +
                "5th player name: <input type = \"text\" name = \"playerName\" />\n" +
                    "serve skill: <input type = \"text\" name = \"playerServe\" />\n" +
                    "attack skill: <input type = \"text\" name = \"playerAttack\" />\n" + "<p/>" +
                "6th player name: <input type = \"text\" name = \"playerName\" />\n" +
                    "serve skill: <input type = \"text\" name = \"playerServe\" />\n" +
                    "attack skill: <input type = \"text\" name = \"playerAttack\" />\n" + "<p/>" +

                "<input type = \"checkbox\" name = \"saveTeam2\" /> Save 2nd team\n" +

                "<br>" +
                "<br>" +
                "<hr>" +

                "<input type = \"submit\" value = \"Play\" />");

        printWriter.close();
    }

}
