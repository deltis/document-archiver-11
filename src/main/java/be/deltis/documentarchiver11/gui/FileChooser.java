package be.deltis.documentarchiver11.gui;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

@Component
public class FileChooser extends JFileChooser {

    public FileChooser() {
        super();
        setDialogTitle("Directory selector");
        setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        setAcceptAllFileFilterUsed(false);
    }

    public String selectDirectory(String currentDirectory) {
        setCurrentDirectory(new File(currentDirectory));
        JFrame frame = new JFrame();
        frame.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        frame.dispose();
                    }
                }
        );
        frame.getContentPane().add(this);
        frame.setVisible(true);

        if (showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            return getSelectedFile().getAbsolutePath();
        } else {
            return null;
        }
    }
}
