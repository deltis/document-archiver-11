package be.deltis.documentarchiver11;

import be.deltis.documentarchiver11.gui.FileChooser;
import org.apache.camel.CamelContext;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(CamelSpringBootRunner.class)
@SpringBootTest
public class FileInputRouterTest {

    @Autowired
    private FileChooser fileChooser;

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private CamelContext context;

    @Test
    public void test() {
        try {
            Path targetDir = Files.createTempDirectory("targetDir");
            when(fileChooser.selectDirectory(anyString())).thenReturn(targetDir.toString());
            Path inputDir = Files.createTempDirectory("inputDir");
            applicationProperties.setInputDir(inputDir.toAbsolutePath().toString());
            FileInputRouter fileInputRouter = new FileInputRouter(fileChooser, applicationProperties);
            context.addRoutes(fileInputRouter);

            File input = new File(inputDir.toFile(), "test.txt");
            assertTrue(input.createNewFile());

            Thread.sleep(5000);

            File output = new File(targetDir.toFile(), "test.txt");
            assertTrue(output.exists());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
