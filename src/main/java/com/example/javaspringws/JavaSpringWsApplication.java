package com.example.javaspringws;

import com.sun.xml.ws.transport.http.servlet.WSSpringServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = "jaxws-config.xml")
public class JavaSpringWsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaSpringWsApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new WSSpringServlet(), "/ws/*");
    }
}
