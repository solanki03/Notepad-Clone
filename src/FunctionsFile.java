import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FunctionsFile {

    Gui gui;
    String fileName, fileAddress;

    public FunctionsFile(Gui gui) {
        this.gui = gui;
    }

    // functions to create a new files whenever some one click on the new files
    public void newFile() {
        gui.textArea.setText(""); // erase the current text
        gui.window.setTitle("Untitled*"); // set the default new name of the new file
    }

    // functions to open a existing files
    public void newOpen() {

        // to display dialog file
        FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        // logic to open any file
        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();

            gui.window.setTitle(fileName);
        }

        // display the content of the file by using buffer reader
        try {
            // you need to read the address of the file
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
            gui.textArea.setText(""); // it'll override the existing text in the file

            String line = null;

            while ((line = br.readLine()) != null) {
                gui.textArea.append(line + "\n");
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // function to save
    public void save() {
        if (fileName == null) {
            saveAs();
        } else {
            try {
                // we want to save the file, that's why here we are using FileWriter
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(gui.textArea.getText());
                gui.window.setTitle(fileName);
                fw.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // fuction to save as
    public void saveAs() {
        FileDialog fd = new FileDialog(gui.window, "Save", FileDialog.SAVE);
        fd.setVisible(true);

        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }

        try {
            // we want to save the file, that's why here we are using FileWriter
            FileWriter fw = new FileWriter(fileAddress + fileName);
            fw.write(gui.textArea.getText());
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // function to create exit operaton
    public void exit() {
        System.exit(0);
    }
}
