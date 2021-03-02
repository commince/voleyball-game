package kryaskov.app.servlets;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class EmbeddedJettyExample {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8680);

        ServletHandler servletHandler = new ServletHandler();
        servletHandler.addServletWithMapping(GreetingServlet.class, "/greeting");
        servletHandler.addServletWithMapping(OptionsServlet.class, "/options");
        servletHandler.addServletWithMapping(PlayServlet.class, "/play");
        servletHandler.addServletWithMapping(DistributorServlet.class, "/distributor");
        servletHandler.addServletWithMapping(AutomaticTeamServlet.class, "/automatic");
        servletHandler.addServletWithMapping(ManualTeamServlet.class, "/manual");


        servletHandler.setEnsureDefaultServlet(true);
        servletHandler.addServletWithMapping(ServletHandler.Default404Servlet.class, "/*");

        server.setHandler(servletHandler);

        server.start();
        server.join();
    }
}
