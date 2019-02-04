package be.deltis.documentarchiver11;

import be.deltis.documentarchiver11.gui.FileChooser;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileInputRouter extends RouteBuilder {

    private final FileChooser fileChooser;

    public FileInputRouter(@Autowired FileChooser fileChooser) {
        this.fileChooser = fileChooser;
    }

    @Override
    public void configure() {
        from("file://{{inputDir}}")
                .autoStartup(true)
                .log("File found: ${header.CamelFileAbsolutePath}")
                .setHeader("targetDir").method(fileChooser, "selectDirectory({{currentDir}})")
                .process(this::debug)
                .toD("file://${header.targetDir}?fileExist=Fail")
                .log("Moved to: ${header.CamelFileNameProduced}")
                .process(this::debug);

    }

    private void debug(Exchange exchange) {
        System.out.println();
    }
}
