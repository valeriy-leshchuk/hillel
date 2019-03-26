package hw.five.gui;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DividersFinderFrame extends AbstractFrame
{
    private static final String FRAME_TITLE = "Dividers finder";
    private static final String HEADER_GREETING_TEXT = "Enter number to find all it's zero-residual dividers";
    private static final String PROCEED_BUTTON_TEXT = "Proceed";

    private JPanel contextPanel_;
    private JLabel headerLabel_;
    private JTextField inTextField_;
    private JTextField outTextField_;
    private JButton proceedButton_;

    public DividersFinderFrame()
    {
        initializeElements();
        setupContextPanel();
        setContentPane(contextPanel_);
        setTitle(FRAME_TITLE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 150));
        setResizable(false);
        pack();
        addButtonListeners();
        addInputFieldsListeners();
    }

    protected void initializeElements()
    {
        headerLabel_ = new JLabel(HEADER_GREETING_TEXT, SwingConstants.CENTER);
        inTextField_ = new JTextField();
        proceedButton_ = new JButton(PROCEED_BUTTON_TEXT);
        outTextField_ = new JTextField();
        outTextField_.setEditable(false);
        contextPanel_ = new JPanel();
    }

    protected void setupContextPanel()
    {
        contextPanel_.setLayout(new BoxLayout(contextPanel_, BoxLayout.Y_AXIS));
        contextPanel_.add(headerLabel_);
        contextPanel_.add(inTextField_);
        contextPanel_.add(proceedButton_);
        contextPanel_.add(outTextField_);
    }

    protected void addButtonListeners()
    {
        proceedButton_.addActionListener(e ->
        {
            String text = inTextField_.getText();
            if (!text.isEmpty())
            {
                int value = Integer.valueOf(text);
                StringBuilder strBuilder = new StringBuilder();
                for (int i = 1; i <= value; i++)
                {
                    if (value % i == 0)
                    {
                        strBuilder.append(i).append(" ");
                    }
                }
                outTextField_.setText(strBuilder.toString());
            }
        });
    }

    private void addInputFieldsListeners()
    {
        KeyListener inFieldListener = new KeyAdapter()
        {
            public void keyTyped(KeyEvent e)
            {
                int keyChar = e.getKeyChar();
                if (keyChar < KeyEvent.VK_0 || keyChar > KeyEvent.VK_9)
                {
                    e.consume();
                }
            }
        };
        inTextField_.addKeyListener(inFieldListener);
    }
}