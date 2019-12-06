package be.deltis.documentarchiver11.config;

import be.deltis.documentarchiver11.gui.FileChooser;
import be.deltis.documentarchiver11.gui.FileChooserImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public FileChooser fileChooser() {
        return new FileChooserImpl();
    }
}
