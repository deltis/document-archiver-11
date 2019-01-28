package be.deltis.gui;

import org.junit.Ignore;
import org.junit.Test;

import java.io.File;

public class FileChooserTest {

    @Test
    @Ignore
    public void selectDirectory() {
        FileChooser fileChooser = new FileChooser(new File("."));
        File selectedDirectory = fileChooser.selectDirectory();
        if (selectedDirectory != null) {
            System.out.println("Selected directory: " + selectedDirectory.getAbsolutePath());
        } else {
            System.err.println("No directory selected");
        }
    }
}
