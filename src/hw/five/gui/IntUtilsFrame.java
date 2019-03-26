package hw.five.gui;

import hw.five.three.IntUtils;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.NumberFormat;

public class IntUtilsFrame extends AbstractFrame
{
    private static final String FRAME_TITLE = "IntUtils convertor";
    private static final String HEADER_GREETING_TEXT = "Type in two numbers and choose operation";
    private static final String ERROR_NEED_BOTH_FIELDS_TEXT = "Enter both fields";
    private static final String ADDITION_BUTTON_TEXT = "Plus";
    private static final String SUBSTRACTION_BUTTON_TEXT = "Minus";
    private static final String POW_BUTTON_TEXT = "Pow";
    private static final String RANDOM_BUTTON_TEXT = "Random";

    private static final Insets defaultInsets_ = new Insets(0, 0, 0, 0);

    private JPanel contextPanel_;
    private JLabel headerLabel_;
    private JFormattedTextField firstInField_;
    private JFormattedTextField secondInField_;
    private JButton addButton_;
    private JButton substractButton_;
    private JButton powButton_;
    private JButton randomButton_;
    private JTextField outTextField_;

    private int firstCurrentValue_;
    private int secondCurrentValue_;

    public IntUtilsFrame()
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
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setGroupingUsed(false);
        headerLabel_ = new JLabel(HEADER_GREETING_TEXT, SwingConstants.CENTER);
        firstInField_ = new JFormattedTextField(numberFormat);
        secondInField_ = new JFormattedTextField(numberFormat);
        addButton_ = new JButton(ADDITION_BUTTON_TEXT);
        substractButton_ = new JButton(SUBSTRACTION_BUTTON_TEXT);
        powButton_ = new JButton(POW_BUTTON_TEXT);
        randomButton_ = new JButton(RANDOM_BUTTON_TEXT);
        outTextField_ = new JTextField();
        outTextField_.setEditable(false);
        contextPanel_ = new JPanel();
    }

    protected void setupContextPanel()
    {
        contextPanel_.setLayout(new GridBagLayout());

        //add header text
        contextPanel_.add(headerLabel_, new GridBagConstraints(0, 0, 4, 1, 1.0, 1.0,
            GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, defaultInsets_, 0, 0));

        //add input fields
        contextPanel_.add(firstInField_, new GridBagConstraints(0, 1, 2, 1, 1.0, 1.0,
            GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, defaultInsets_, 0, 0));
        contextPanel_.add(secondInField_, new GridBagConstraints(2, 1, 2, 1, 1.0, 1.0,
            GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, defaultInsets_, 0, 0));

        //add buttons
        contextPanel_.add(addButton_, new GridBagConstraints(0, 2, 1, 1, 1.0, 1.0,
            GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, defaultInsets_, 0, 0));
        contextPanel_.add(substractButton_, new GridBagConstraints(1, 2, 1, 1, 1.0, 1.0,
            GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, defaultInsets_, 0, 0));
        contextPanel_.add(powButton_, new GridBagConstraints(2, 2, 1, 1, 1.0, 1.0,
            GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, defaultInsets_, 0, 0));
        contextPanel_.add(randomButton_, new GridBagConstraints(3, 2, 1, 1, 1.0, 1.0,
            GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, defaultInsets_, 0, 0));

        //add out fields
        contextPanel_.add(outTextField_, new GridBagConstraints(0, 3, 4, 1, 1.0, 1.0,
            GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, defaultInsets_, 0, 0));
    }

    protected void addButtonListeners()
    {
        addButton_.addActionListener(e ->
        {
            if (getCurrentValuesFromEntry())
            {
                Integer result = IntUtils.plus(firstCurrentValue_, secondCurrentValue_);
                outTextField_.setText(result.toString());
            }
            else
            {
                showError(ERROR_NEED_BOTH_FIELDS_TEXT);
            }
        });
        substractButton_.addActionListener(e ->
        {
            if (getCurrentValuesFromEntry())
            {
                Integer result = IntUtils.minus(firstCurrentValue_, secondCurrentValue_);
                outTextField_.setText(result.toString());
            }
            else
            {
                showError(ERROR_NEED_BOTH_FIELDS_TEXT);
            }
        });
        powButton_.addActionListener(e ->
        {
            if (getCurrentValuesFromEntry())
            {
                Integer result = IntUtils.pow(firstCurrentValue_, secondCurrentValue_);
                outTextField_.setText(result.toString());
            }
            else
            {
                showError(ERROR_NEED_BOTH_FIELDS_TEXT);
            }
        });
        randomButton_.addActionListener(e ->
        {
            if (getCurrentValuesFromEntry())
            {
                Integer result = IntUtils.getRandomInt(firstCurrentValue_, secondCurrentValue_);
                outTextField_.setText(result.toString());
            }
            else
            {
                showError(ERROR_NEED_BOTH_FIELDS_TEXT);
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
        firstInField_.addKeyListener(inFieldListener);
        secondInField_.addKeyListener(inFieldListener);
    }

    private boolean getCurrentValuesFromEntry()
    {
        if (!firstInField_.getText().isEmpty() && !secondInField_.getText().isEmpty())
        {
            firstCurrentValue_ = Integer.valueOf(firstInField_.getText());
            secondCurrentValue_ = Integer.valueOf(secondInField_.getText());
            return true;
        }
        else
        {
            return false;
        }
    }

    private void showError(String errorText)
    {
        outTextField_.setText(errorText);
    }
}