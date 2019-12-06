package be.deltis.documentarchiver11;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("archiver")
@Data
public class ApplicationProperties {

    private String inputDir;
    private String currentDir;

}
