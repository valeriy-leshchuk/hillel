package classwork.may23.ui;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainToolbar extends JToolBar
{
    private static final String RECT_BTN_TEXT = "Rectangle";
    private static final String OVAL_BTN_TEXT = "Oval";
    private static final String EMPTY_BTN_TEXT = "Empty";
    private static final String FILL_BTN_TEXT = "Fill";

    InstantFigureProp instantFigureProp = InstantFigureProp.getInstance();

    public MainToolbar()
    {
        setRollover(false);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel shapePanel = new JPanel();
        shapePanel.setLayout(new GridLayout(2, 1));
        ButtonGroup shapeBtnGrp = new ButtonGroup();
        JRadioButton rectBtn = new JRadioButton(RECT_BTN_TEXT);
        JRadioButton ovalBtn = new JRadioButton(OVAL_BTN_TEXT);
        shapeBtnGrp.add(rectBtn);
        shapeBtnGrp.add(ovalBtn);
        shapePanel.add(rectBtn);
        shapePanel.add(ovalBtn);
        rectBtn.setSelected(true);
        instantFigureProp.setShape(InstantFigureProp.Shape.Rectangle);
        add(shapePanel);

        JPanel fillPanel = new JPanel();
        fillPanel.setLayout(new GridLayout(2, 1));
        ButtonGroup fillBtnGroup = new ButtonGroup();
        JRadioButton emptyBtn = new JRadioButton(EMPTY_BTN_TEXT);
        JRadioButton fillBtn = new JRadioButton(FILL_BTN_TEXT);
        fillBtnGroup.add(emptyBtn);
        fillBtnGroup.add(fillBtn);
        fillPanel.add(emptyBtn);
        fillPanel.add(fillBtn);
        emptyBtn.setSelected(true);
        instantFigureProp.setFilled(false);

        BtnListener btnListener = new BtnListener();
        rectBtn.addActionListener(btnListener);
        ovalBtn.addActionListener(btnListener);
        emptyBtn.addActionListener(btnListener);
        fillBtn.addActionListener(btnListener);
        add(fillPanel);
    }

    private class BtnListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String btnSelected = e.getActionCommand();
            switch (btnSelected)
            {
                case RECT_BTN_TEXT:
                    instantFigureProp.setShape(InstantFigureProp.Shape.Rectangle);
                    break;
                case OVAL_BTN_TEXT:
                    instantFigureProp.setShape(InstantFigureProp.Shape.Oval);
                    break;
                case EMPTY_BTN_TEXT:
                    instantFigureProp.setFilled(false);
                    break;
                case FILL_BTN_TEXT:
                    instantFigureProp.setFilled(true);
                    break;
            }
        }
    }
}
