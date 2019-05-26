package classwork.may23.ui;

import lombok.Builder;

import javax.swing.*;

@Builder
public class Window extends JFrame
{
    private String windowTitle;
    private int windowHeight;
    private int windowWidth;

    public void init()
    {
        add(new GraphicArea());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(windowTitle);
        setSize(windowWidth,windowHeight);
        setVisible(true);
    }
}
