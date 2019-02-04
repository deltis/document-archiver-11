package be.deltis.documentarchiver11.gui;

import org.junit.Ignore;
import org.junit.Test;

public class FileChooserTest {

    @Test
    @Ignore
    public void selectDirectory() {
        FileChooser fileChooser = new FileChooser();
        String selectedDirectory = fileChooser.selectDirectory(".");
        if (selectedDirectory != null) {
            System.out.println("Selected directory: " + selectedDirectory);
        } else {
            System.err.println("No directory selected");
        }
    }
}
