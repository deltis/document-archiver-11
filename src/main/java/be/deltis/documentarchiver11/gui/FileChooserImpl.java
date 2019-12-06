package be.deltis.documentarchiver11.gui;

import javax.swing.*;
import java.io.File;

public class FileChooserImpl extends JFrame implements FileChooser {

    private JFileChooser fileChooser;

    public FileChooserImpl() {
        fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Directory selector");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        getContentPane().add(fileChooser);
    }

    @Override
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
