package classwork.may23.ui;

import java.awt.Graphics;

public class Oval extends Figure
{
    private final int centerX;
    private final int centerY;
    private final int r1;
    private final int r2;

    public Oval(int startX, int startY, int curX, int curY, boolean isFilled)
    {
        this.centerX = Integer.min(startX, curX);
        this.centerY = Integer.min(startY, curY);
        this.r1 = Math.abs(startX - curX);
        this.r2 = Math.abs(startY - curY);
        this.isFilled = isFilled;
    }

    @Override
    public void draw(Graphics g)
    {
        g.drawOval(centerX, centerY, r1, r2);
        if (isFilled)
        {
            g.fillOval(centerX, centerY, r1, r2);
        }
    }
}
