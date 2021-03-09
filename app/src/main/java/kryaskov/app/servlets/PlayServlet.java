package kryaskov.app.servlets;

import kryaskov.app.game.WebMatch;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/play")
public class PlayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);

        WebMatch.clearLogs();

        if (req.getParameter("method").equals("automatic")) {
            if (req.getParameter("useInputName") == null ||
                    (req.getParameter("team1Name") == null || req.getParameter("team2Name") == null)) {
                WebMatch.getWebMatch().createTeamsAutomatically();
            } else {
                WebMatch.getWebMatch().createTeamsAutomatically(req.getParameter("team1Name"), req.getParameter("team2Name"));
            }
        } else {
            if (req.getParameter("manualPlayerCreation") == null) {
                WebMatch.getWebMatch().createTeamsSemiAutomatically(req.getParameter("team1Name"),
                        req.getParameter("team2Name"));
            } else {
                List<String> playerNames = new ArrayList<>();
                List<String> serveSkills = new ArrayList<>();
                List<String> attackSkills = new ArrayList<>();
                Enumeration parameterNames = req.getParameterNames();
                while (parameterNames.hasMoreElements()) {
                    String paramName = (String) parameterNames.nextElement();
                    String[] paramValues = req.getParameterValues(paramName);
                    if (paramName.equals("playerName")) {
                        playerNames = Arrays.asList(paramValues);
                    }
                    if (paramName.equals("playerServe")) {
                        serveSkills = Arrays.asList(paramValues);
                    }
                    if (paramName.equals("playerAttack")) {
                        attackSkills = Arrays.asList(paramValues);
                    }
                }
                boolean saveTeam1 = true;
                boolean saveTeam2 = true;
                if (req.getParameter("saveTeam1") == null) saveTeam1 = false;
                if (req.getParameter("saveTeam2") == null) saveTeam2 = false;

                WebMatch.getWebMatch().createTeamsManually(req.getParameter("team1Name"), saveTeam1,
                        req.getParameter("team2Name"), saveTeam2,
                        playerNames,
                        serveSkills,
                        attackSkills);
            }
        }

        WebMatch.getWebMatch().go();

        PrintWriter printWriter = response.getWriter();
        printWriter.write(WebMatch.getMatchLog());
        printWriter.write("<hr/>");
        printWriter.write("<p style=\"color: gray\">Press <a href='options'>here</a> to play again</p>");
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
