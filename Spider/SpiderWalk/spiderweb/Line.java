package spiderweb;

import canvas.Canvas;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.*;
import java.awt.Point;

public class Line{
    
    public int x1, y1, x2, y2;
    public int centerX, centerY, x, y;
    protected String color;
    protected boolean isVisible;
    
    public Line(int x1, int y1, int x2, int y2,String color) {
        centerX = x1;
        centerY = y1;
        x = x2;
        y = y2;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        isVisible = true;
        this.color = color;
    }
    
    public void makeVisible(){
        isVisible = true;
        draw();
    }
    
    public void makeInvisible(){
        erase();
        isVisible = false;
    }

    public void draw(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, new Line2D.Double(centerX, centerY, x, y));
            canvas.wait(10);
        }
    }

    public void erase(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public Point getInitial() {
        return new Point(x1,y1);
    }
    
    public Point getFinal() {
        return new Point(x2,y2);
    }
    
}
