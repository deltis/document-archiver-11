package be.deltis.documentarchiver11.config;

import be.deltis.documentarchiver11.gui.FileChooser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public FileChooser fileChooser() {
        return mock(FileChooser.class);
    }
}
