import java.awt.Color;

public class FunctionColor {

    Gui gui;

    public FunctionColor(Gui gui) {
        this.gui = gui;
    }

    public void changeColor(String color) {
        switch (color) {

            case "White":
                gui.window.getContentPane().setBackground(Color.WHITE);
                gui.textArea.setBackground(Color.WHITE);
                gui.textArea.setForeground(Color.BLACK);
                break;

            case "Black":
                gui.window.getContentPane().setBackground(Color.BLACK);
                gui.textArea.setBackground(Color.BLACK);
                gui.textArea.setForeground(Color.WHITE);
                break;

            case "Blue":
                gui.window.getContentPane().setBackground(Color.BLUE);
                gui.textArea.setBackground(Color.BLUE);
                gui.textArea.setForeground(Color.WHITE);
                break;

            case "Green":
                gui.window.getContentPane().setBackground(Color.GREEN);
                gui.textArea.setBackground(Color.GREEN);
                gui.textArea.setForeground(Color.BLACK);
                break;

            case "Red":
                gui.window.getContentPane().setBackground(Color.RED);
                gui.textArea.setBackground(Color.RED);
                gui.textArea.setForeground(Color.WHITE);
                break;

            case "Magenta":
                gui.window.getContentPane().setBackground(Color.MAGENTA);
                gui.textArea.setBackground(Color.MAGENTA);
                gui.textArea.setForeground(Color.WHITE);
                break;

            case "Orange":
                gui.window.getContentPane().setBackground(Color.ORANGE);
                gui.textArea.setBackground(Color.ORANGE);
                gui.textArea.setForeground(Color.BLACK);
                break;

            case "Gray":
                gui.window.getContentPane().setBackground(Color.GRAY);
                gui.textArea.setBackground(Color.GRAY);
                gui.textArea.setForeground(Color.WHITE);
                break;

            case "Cyan":
                gui.window.getContentPane().setBackground(Color.CYAN);
                gui.textArea.setBackground(Color.CYAN);
                gui.textArea.setForeground(Color.BLACK);
                break;

            case "Yellow":
                gui.window.getContentPane().setBackground(Color.YELLOW);
                gui.textArea.setBackground(Color.YELLOW);
                gui.textArea.setForeground(Color.BLACK);
                break;
        }
    }

}
