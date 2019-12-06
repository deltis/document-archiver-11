package be.deltis.documentarchiver11;

import be.deltis.documentarchiver11.gui.FileChooser;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileInputRouter extends RouteBuilder {

    private final FileChooser fileChooser;
    private final ApplicationProperties applicationProperties;

    public FileInputRouter(FileChooser fileChooser, ApplicationProperties applicationProperties) {
        this.fileChooser = fileChooser;
        this.applicationProperties = applicationProperties;
    }

    @Override
    public void configure() {
        from("file://" + applicationProperties.getInputDir())
                .autoStartup(true)
                .log("File found: ${header.CamelFileAbsolutePath}")
                .setHeader("targetDir").method(fileChooser, "selectDirectory({{archiver.currentDir}})")
                .process(this::debug)
                .toD("file://${header.targetDir}?fileExist=Fail")
                .log("Moved to: ${header.CamelFileNameProduced}")
                .process(this::debug);

    }

    private void debug(Exchange exchange) {
        System.out.println();
    }
}
