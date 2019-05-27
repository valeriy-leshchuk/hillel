package classwork.may23.ui;

import lombok.Builder;

import javax.swing.*;
import java.awt.BorderLayout;

@Builder
public class Window extends JFrame
{
    private String windowTitle;
    private int windowHeight;
    private int windowWidth;
    private GraphicArea graphicArea;
    private JToolBar toolbar;

    public void init()
    {
        setLayout(new BorderLayout());
        graphicArea = new GraphicArea();
        add(graphicArea);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(windowTitle);
        setSize(windowWidth, windowHeight);
        toolbar = new MainToolbar();
        add(toolbar, BorderLayout.NORTH);
        setVisible(true);
    }
}
