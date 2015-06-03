package ro.micsa.tequilajobs.tomcat;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.ApplicationContext;

import java.io.File;

public class TomcatEmbedded {

    private static final int PORT = 8080;
    private static final String APP_CONTEXT = "/tequila-jobs";
    private static final String WEBAPP_DIR_LOCATION = "src/main/webapp/";

    private Tomcat server;
    private ApplicationContext applicationContext;

    public void start(){
        System.setProperty("spring.profiles.active", "test");
        server = new Tomcat();
        server.setPort(PORT);
        try {
            Context serverContext = server.addWebapp(APP_CONTEXT, new File(WEBAPP_DIR_LOCATION).getAbsolutePath());
            server.start();
            registerShutdown();
            applicationContext = getApplicationContext(serverContext);
            System.out.println("Tomcat started successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void registerShutdown() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    server.stop();
                } catch (LifecycleException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private ApplicationContext getApplicationContext(Context serverContext){
        return (ApplicationContext) serverContext.getServletContext().getAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.DispatcherServlet");
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    protected void await(){
        server.getServer().await();
    }

    public static void main(String[] args) throws Exception {
        TomcatEmbedded tomcatEmbedded = new TomcatEmbedded();
        tomcatEmbedded.start();
        tomcatEmbedded.await();
    }
}
