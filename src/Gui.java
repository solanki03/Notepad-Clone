import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ActionListener {

    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    // top menubar
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor;

    // File menu items ----
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;

    // Format menu items ----
    JMenuItem iWrap, iFontArial, iFontCSMS, iFontTNR, iFontTahoma;
    JMenuItem iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24, iFontSize28;
    JMenu menuFont, menuFontSize;

    // color menu items ----
    JMenuItem iColor1, iColor2, iColor3, iColor4, iColor5, iColor6, iColor7, iColor8, iColor9, iColor10;

    // Edit menu items ----
    JMenuItem iUndo, iRedo;

    boolean wordWrapOn = false;

    FunctionsFile file = new FunctionsFile(this);
    FunctionFormat format = new FunctionFormat(this);
    FunctionColor color = new FunctionColor(this);
    FunctionEdit edit = new FunctionEdit(this);

    // create undo and redo manager
    UndoManager um = new UndoManager();

    // constructor
    public Gui() {

        // calling all the methods
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createFormatMenu();
        createColorMenu();
        createEditMenu();

        // set default font & size
        format.selectedFont = "Arial";
        format.createFont(16);
        format.wordWrap();

        window.setVisible(true);
    }

    // define the createWindow method
    public void createWindow() {
        window = new JFrame("Notepad Clone");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // define the text area method which will help us to write our text
    public void createTextArea() {
        textArea = new JTextArea();

        // apply undo and redo manager
        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {

            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                um.addEdit(e.getEdit());
            }
        });

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(2, 3, 2, 3));
        window.add(scrollPane);
    }

    // create a method menuBar which creates a menu for our gui
    public void createMenuBar() {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        // File
        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        // Edit
        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        // Format
        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        // Color
        menuColor = new JMenu("Color");
        menuBar.add(menuColor);
    }

    // menu items method
    public void createFileMenu() {
        // New
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);

        // Open
        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);

        // Save
        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);

        // Save As
        iSaveAs = new JMenuItem("Save As");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("Save As");
        menuFile.add(iSaveAs);

        // Exit
        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        menuFile.add(iExit);
    }

    // create a method to create Format menu
    public void createFormatMenu() {
        iWrap = new JMenuItem("Word Wrap: Off");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Word Wrap");
        menuFormat.add(iWrap);

        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);

        iFontTahoma = new JMenuItem("Tahoma");
        iFontTahoma.addActionListener(this);
        iFontTahoma.setActionCommand("Tahoma");
        menuFont.add(iFontTahoma);

        iFontCSMS = new JMenuItem("Comic Sans MS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(iFontCSMS);

        iFontTNR = new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("Times New Roman");
        menuFont.add(iFontTNR);

        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("Size8");
        menuFontSize.add(iFontSize8);

        iFontSize12 = new JMenuItem("12");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("Size12");
        menuFontSize.add(iFontSize12);

        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("Size16");
        menuFontSize.add(iFontSize16);

        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("Size20");
        menuFontSize.add(iFontSize20);

        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("Size24");
        menuFontSize.add(iFontSize24);

        iFontSize28 = new JMenuItem("28");
        iFontSize28.addActionListener(this);
        iFontSize28.setActionCommand("Size28");
        menuFontSize.add(iFontSize28);

    }

    // create a method to create Color menu
    public void createColorMenu() {
        iColor1 = new JMenuItem("White");
        iColor1.addActionListener(this);
        iColor1.setActionCommand("White");
        menuColor.add(iColor1);

        iColor2 = new JMenuItem("Black");
        iColor2.addActionListener(this);
        iColor2.setActionCommand("Black");
        menuColor.add(iColor2);

        iColor3 = new JMenuItem("Blue");
        iColor3.addActionListener(this);
        iColor3.setActionCommand("Blue");
        menuColor.add(iColor3);

        iColor4 = new JMenuItem("Green");
        iColor4.addActionListener(this);
        iColor4.setActionCommand("Green");
        menuColor.add(iColor4);

        iColor5 = new JMenuItem("Red");
        iColor5.addActionListener(this);
        iColor5.setActionCommand("Red");
        menuColor.add(iColor5);

        iColor6 = new JMenuItem("Magenta");
        iColor6.addActionListener(this);
        iColor6.setActionCommand("Magenta");
        menuColor.add(iColor6);

        iColor7 = new JMenuItem("Orange");
        iColor7.addActionListener(this);
        iColor7.setActionCommand("Orange");
        menuColor.add(iColor7);

        iColor8 = new JMenuItem("Gray");
        iColor8.addActionListener(this);
        iColor8.setActionCommand("Gray");
        menuColor.add(iColor8);

        iColor9 = new JMenuItem("Cyan");
        iColor9.addActionListener(this);
        iColor9.setActionCommand("Cyan");
        menuColor.add(iColor9);

        iColor10 = new JMenuItem("Yellow");
        iColor10.addActionListener(this);
        iColor10.setActionCommand("Yellow");
        menuColor.add(iColor10);

    }

    // create a method to create Edit menu
    public void createEditMenu() {
        iUndo = new JMenuItem("Undo");
        iUndo.addActionListener(this);
        iUndo.setActionCommand("Undo");
        menuEdit.add(iUndo);

        iRedo = new JMenuItem("Redo");
        iRedo.addActionListener(this);
        iRedo.setActionCommand("Redo");
        menuEdit.add(iRedo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "New":
                file.newFile();
                break;
            case "Open":
                file.newOpen();
                break;
            case "Save":
                file.save();
                break;
            case "Save As":
                file.saveAs();
                break;
            case "Exit":
                file.exit();
                break;
            case "Word Wrap":
                format.wordWrap();
                break;
            case "Arial":
                format.setFont(command);
                break;
            case "Tahoma":
                format.setFont(command);
                break;
            case "Comic Sans MS":
                format.setFont(command);
                break;
            case "Times New Roman":
                format.setFont(command);
                break;
            case "Size8":
                format.createFont(8);
                break;
            case "Size12":
                format.createFont(12);
                break;
            case "Size16":
                format.createFont(16);
                break;
            case "Size20":
                format.createFont(20);
                break;
            case "Size24":
                format.createFont(24);
                break;
            case "Size28":
                format.createFont(28);
                break;
            case "White":
                color.changeColor(command);
                break;
            case "Black":
                color.changeColor(command);
                break;
            case "Blue":
                color.changeColor(command);
                break;
            case "Green":
                color.changeColor(command);
                break;
            case "Red":
                color.changeColor(command);
                break;
            case "Magenta":
                color.changeColor(command);
                break;
            case "Orange":
                color.changeColor(command);
                break;
            case "Gray":
                color.changeColor(command);
                break;
            case "Cyan":
                color.changeColor(command);
                break;
            case "Yellow":
                color.changeColor(command);
                break;
            case "Undo":
                edit.undo();
                break;
            case "Redo":
                edit.redo();
                break;
        }
    }

}
