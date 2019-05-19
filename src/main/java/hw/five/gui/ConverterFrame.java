package hw.five.gui;

import hw.five.one.stringPrinters.LowerCaseStringPrinter;
import hw.five.one.stringPrinters.UpperCaseStringPrinter;

import javax.swing.*;
import java.awt.*;

public class ConverterFrame extends AbstractFrame
{
    private static final String FRAME_TITLE = "String convertor";
    private static final String HEADER_GREETING_TEXT = "Enter your string in area below and choose how to convert it";
    private static final String TO_LOWERCASE_BUTTON_TEXT = "To lowercase";
    private static final String TO_UPPERCASE_BUTTON_TEXT = "To uppercase";

    private static final Insets defaultInsets_ = new Insets(0, 0, 0, 0);

    private static final LowerCaseStringPrinter lowerCaseStringPrinter_ = new LowerCaseStringPrinter();
    private static final UpperCaseStringPrinter upperCaseStringPrinter_ = new UpperCaseStringPrinter();

    private JPanel contextPanel_;
    private JTextField outTextField_;
    private JLabel headerLabel_;
    private JButton toLowerCaseButton_;
    private JButton toUpperCaseButton_;
    private JTextField inTextField_;

    public ConverterFrame()
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
    }

    protected void initializeElements()
    {
        headerLabel_ = new JLabel(HEADER_GREETING_TEXT, SwingConstants.CENTER);
        inTextField_ = new JTextField();
        toLowerCaseButton_ = new JButton(TO_LOWERCASE_BUTTON_TEXT);
        toUpperCaseButton_ = new JButton(TO_UPPERCASE_BUTTON_TEXT);
        outTextField_ = new JTextField();
        outTextField_.setEditable(false);
        contextPanel_ = new JPanel();
    }

    protected void setupContextPanel()
    {
        contextPanel_.setLayout(new GridBagLayout());

        contextPanel_.add(headerLabel_, new GridBagConstraints(0, 0, 2, 1, 1.0, 1.0,
            GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, defaultInsets_, 0, 0));
        contextPanel_.add(inTextField_, new GridBagConstraints(0, 1, 2, 1, 1.0, 1.0,
            GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, defaultInsets_, 0, 0));
        contextPanel_.add(toLowerCaseButton_, new GridBagConstraints(0, 2, 1, 1, 1.0, 1.0,
            GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, defaultInsets_, 0, 0));
        contextPanel_.add(toUpperCaseButton_, new GridBagConstraints(1, 2, 1, 1, 1.0, 1.0,
            GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, defaultInsets_, 0, 0));
        contextPanel_.add(outTextField_, new GridBagConstraints(0, 3, 2, 1, 1.0, 1.0,
            GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, defaultInsets_, 0, 0));
    }

    protected void addButtonListeners()
    {
        toLowerCaseButton_.addActionListener(e ->
        {
            String text = inTextField_.getText();
            if (!text.isEmpty())
            {
                text = lowerCaseStringPrinter_.modifyStr(text);
                outTextField_.setText(text);
            }
        });

        toUpperCaseButton_.addActionListener(e ->
        {
            String text = inTextField_.getText();
            if (!text.isEmpty())
            {
                text = upperCaseStringPrinter_.modifyStr(text);
                outTextField_.setText(text);
            }
        });
    }
}