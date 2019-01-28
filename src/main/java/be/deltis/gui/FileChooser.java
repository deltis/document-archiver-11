package be.deltis.gui;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class FileChooser extends JFileChooser {

    public FileChooser(File currentDirectory) {
        super(currentDirectory);
        setDialogTitle("Directory selector");
        setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        setAcceptAllFileFilterUsed(false);
    }

    public File selectDirectory() {
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
            return getSelectedFile();
        } else {
            return null;
        }
    }
}
