package be.deltis.documentarchiver11.gui;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.io.File;

@Component
public class FileChooser extends JFrame {

    private JFileChooser fileChooser;

    public FileChooser() {
        fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Directory selector");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        getContentPane().add(fileChooser);
    }

    public String selectDirectory(String currentDirectory) {
        fileChooser.setCurrentDirectory(new File(currentDirectory));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        int option = fileChooser.showOpenDialog(this);
        dispose();
        if (option == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getAbsolutePath();
        } else {
            return null;
        }
    }
}
