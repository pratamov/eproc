package id.noeandfriends.eproc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({
		"id.noeandfriends.eproc.configuration", 
		"id.noeandfriends.eproc.controller.rest", 
		"id.noeandfriends.eproc.controller.web"})

@SpringBootApplication
public class EprocApplication extends SpringBootServletInitializer {
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EprocApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(EprocApplication.class, args);
	}
}
