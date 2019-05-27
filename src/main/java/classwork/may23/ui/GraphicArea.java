package classwork.may23.ui;

import lombok.extern.log4j.Log4j;

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.LinkedList;
import java.util.List;

@Log4j
public class GraphicArea extends JComponent
{
    private static final int gridStep = 20;
    private static final InstantFigureProp instantFigureProp = InstantFigureProp.getInstance();
    private boolean isMousePressed = false;
    private int startX;
    private int startY;
    private int curX;
    private int curY;

    private List<Figure> figures = new LinkedList<>();

    public GraphicArea()
    {
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                isMousePressed = true;
                startX = e.getX();
                startY = e.getY();
                curX = startX;
                curY = startY;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                isMousePressed = false;
                curX = e.getX();
                curY = e.getY();
                switch (instantFigureProp.getShape())
                {
                    case Rectangle:
                        figures.add(new Rectangle(startX, startY, curX, curY, instantFigureProp.isFilled()));
                        break;
                    case Oval:
                        figures.add(new Oval(startX, startY, curX, curY, instantFigureProp.isFilled()));
                        break;
                }
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter()
        {
            @Override
            public void mouseDragged(MouseEvent e)
            {
                curX = e.getX();
                curY = e.getY();
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g)
    {
        drawGrid(g);
        repaintAllFigures(g);

        if (isMousePressed)
        {
            switch (instantFigureProp.getShape())
            {
                case Rectangle:
                    new Rectangle(startX,startY,curX,curY, instantFigureProp.isFilled()).draw(g);
                    break;
                case Oval:
                    new Oval(startX,startY,curX,curY, instantFigureProp.isFilled()).draw(g);
                    break;
            }
        }
    }

    private void drawGrid(Graphics g)
    {
        for (int i = 0; i < getHeight(); i += gridStep)
        {
            g.drawLine(0, i, getWidth(), i);
        }
        for (int i = 0; i < getWidth(); i += gridStep)
        {
            g.drawLine(i, 0, i, getHeight());
        }
    }

    private void repaintAllFigures(Graphics g)
    {
        for (Figure figure : figures)
        {
            figure.draw(g);
        }
    }
}
