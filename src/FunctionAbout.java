import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FunctionAbout extends JFrame implements ActionListener{

    public FunctionAbout() {

        super("About J-Notepad");
        setSize(400, 400);
        setLayout(null);
        setLocation(200, 100);
        setResizable(false);
        ImageIcon imageIcon = new ImageIcon("src\\Icons\\info.png"); 
        setIconImage(imageIcon.getImage());

        displayAbout();
    }

    public void displayAbout() {
        // add logo to the frame
        ImageIcon logo1 = new ImageIcon(ClassLoader.getSystemResource("Icons/windows-11-icon.png"));
        Image img = logo1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon imgIcon = new ImageIcon(img);
        JLabel imglabel = new JLabel(imgIcon);
        imglabel.setBounds(150, 30, 90, 90);
        add(imglabel);

        JLabel bankLabel = new JLabel("<html>J-Notepad<br>Version: JDK-17 (System Build using Java)<br>©️ Solanki Singha. All rights reserved.<br>"+
        "<br>This J-Notepad is compatible with any operating System. This is a clone of Windows Notepad.</html>");
        bankLabel.setBounds(20, 10, 350, 350);
        bankLabel.setFont(new Font("Calibri", Font.BOLD, 12));
        add(bankLabel);

        // CREATE A EXIT BUTTON
        JButton ok = new JButton("OK");
        ok.setBounds(290, 320, 70, 20);
        ok.setFont(new Font("Calibri", Font.BOLD, 12));
        ok.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(ok);
        ok.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

}
