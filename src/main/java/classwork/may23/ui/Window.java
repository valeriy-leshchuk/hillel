package classwork.may23.ui;

import javax.swing.*;
import java.awt.Dimension;

public class Window extends JFrame
{
    public static void main(String[] args)
    {
        Window window = new Window();
        //JMenuBar menuBar = new JMenuBar();
        //window.setJMenuBar(menuBar);
        //JMenu menu = new JMenu();
        //JButton rectBut = new JButton("rect");
        //JButton circBut = new JButton("rect");
        //menu.add(rectBut);
        //menuBar.add(circBut);

        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setTitle("Visual editor");
        window.add(new GraphicArea());
        window.setSize(new Dimension(400, 150));
        //window.setResizable(false);
        window.setVisible(true);
    }
}
