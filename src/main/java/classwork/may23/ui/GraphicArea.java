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
    private boolean isMousePressed = false;
    private int startX;
    private int startY;
    private int curX;
    private int curY;
    private int endX;
    private int endY;

    private List<Figure> figures = new LinkedList<>();

    public GraphicArea()
    {
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                isMousePressed = true;
                startX=e.getX();
                startY = e.getY();
                curX=startX;
                curY=startY;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                isMousePressed = false;
                endX=e.getX();
                endY=e.getY();
                figures.add(new Rectangle(startX,startY,curX,curY));
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter()
        {
            @Override
            public void mouseDragged(MouseEvent e)
            {
                curX=e.getX();
                curY=e.getY();
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g)
    {
        log.debug("paint invoked");
        drawGrid(g);
        repaintAllFigures(g);


        if(isMousePressed)
        {
            //g.drawRect(Integer.min(startX,curX),Integer.min(startY,curY),Math.abs(curX-startX), Math.abs(curY-startY));
            //g.fillRect(Integer.min(startX,curX),Integer.min(startY,curY),Math.abs(curX-startX), Math.abs(curY-startY));
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
