package scaa.wardrobe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationLauncher {

    public static void main(String[] args){
        System.getProperties().put( "server.port", 8787 );
        System.setProperty("server.servlet.context-path", "/wardrobeandmenu");
        SpringApplication.run(ApplicationLauncher.class, args);
    }
}
