/*
 * rasterPoint.java
 *
 * Created on 20 décembre 2006, 23:11
 *
 */

package rastercreator;

import java.awt.event.*; // for mouseListener, click
import java.text.*; // for DecimalFormat
import javax.swing.*; // for drawing
import java.awt.*; // for drawing

/**
 *
 * @author Jean-Etienne
 */
public class rasterPoint extends JPanel implements MouseListener {
    
    private double x;
    private double y;
    private boolean status;
    private int sidesize = 20; // side size, to draw our square
    private int bordersize = 3; // size of the border in square where we shouldn't draw the bullet
    
    private NumberFormat formatter;
    private String rasterDecimalFormat = "0.000000";
    
    /* ***** CONSTRUCTOR ***** */   
    public rasterPoint(double x, double y, boolean s) {
        setX(x);
        setY(y);
        setStatus(s);
        addMouseListener(this);
        setPreferredSize(new Dimension(sidesize, sidesize));
        setBackground(Color.white);
        formatter = new DecimalFormat(rasterDecimalFormat);
    }
    
    /* ***** OVERRIDE PAINTCOMPONENT FROM JPANEL ***** */
    @Override public void paintComponent(Graphics g) { // paint component
        super.paintComponent(g);
        drawFilledCircle(getStatus(), g);
    }
    
    public String toString() {
        // better practice: http://www.javapractices.com/Topic55.cjp
        if(status)
            return(getXf() + " " +  getYf() + " true");
        else
            return(getXf() + " " +  getYf() + " false");
    }
    
    private void drawFilledCircle(boolean s, Graphics g) {
        int w = getWidth();
        int h = getHeight();
        if(s) {
            g.setColor(Color.red);
            g.fillOval(bordersize, bordersize, w - (2 * bordersize), h - (2 * bordersize));
        }
        else {
            if((getXval() > -0.5 && getXval() < 0.5) && (getYval() > -0.5 && getYval() < 0.5))
                g.setColor(Color.green);
            g.drawOval(bordersize, bordersize, w - (2 * bordersize), h - (2 * bordersize));
        }
    }
    
    /* ***** NOW "NORMAL" METHODS FOR MY OBJECT ***** */
    public boolean getStatus() {
        return status;
    }
    
    public void setStatus(boolean s) {
        status = s;
    }
    
    public double getXval() {
        return x;
    }
    
    public String getXf() { // get X formatted like a "x.xx" string
        String tmp = formatter.format(x);
        tmp = tmp.replace(',', '.');
        return tmp;
    }
    
    public void setX(double val) {
        x = val;
    }
    
    public double getYval() {
        return y;
    }

    public String getYf() { // get Y formatted like a "x.xx" string
        String tmp = formatter.format(y);
        tmp = tmp.replace(',', '.');
        return tmp;
    }
    
    public void setY(double val) {
        y = val;
    }
    
// ***** FINALLY IMPLEMENTS MOUSELISTENER METHODS *****
    public void mouseClicked(MouseEvent e) {
        if(getStatus())
            setStatus(false);
        else
            setStatus(true);
        this.repaint();
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
