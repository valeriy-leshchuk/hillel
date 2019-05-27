package classwork.may23.ui;

import java.awt.Graphics;

public class Rectangle extends Figure
{
    private final int startX;
    private final int startY;
    private final int width;
    private final int height;

    public Rectangle(int startX, int startY, int currentX, int currentY, boolean isFilled)
    {
        this.startX = Integer.min(startX, currentX);
        this.startY = Integer.min(startY, currentY);
        this.width = Math.abs(startX - currentX);
        this.height = Math.abs(startY - currentY);
        this.isFilled = isFilled;
    }

    @Override
    public void draw(Graphics g)
    {
        g.drawRect(startX, startY, width, height);
        if (isFilled)
        {
            g.fillRect(startX, startY, width, height);
        }
    }
}
