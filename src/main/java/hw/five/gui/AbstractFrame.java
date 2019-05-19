package hw.five.gui;

import javax.swing.JFrame;

abstract class AbstractFrame extends JFrame
{
    abstract protected void initializeElements();

    abstract protected void setupContextPanel();

    abstract protected void addButtonListeners();
}