package net.home.shutdown.configuration;

import net.home.shutdown.managers.Shutdown;
import net.home.shutdown.managers.impl.SystemShutdown;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Shutdown shutdown(){
        return new SystemShutdown();
    }

    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>
    webServerFactoryCustomizer() {
        return factory -> factory.setContextPath("/home");
    }

}

