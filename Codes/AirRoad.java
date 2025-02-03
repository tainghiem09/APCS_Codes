import java.awt.*;
import javax.swing.*;

public class AirRoad extends JComponent implements Runnable {
    private Color roadColor = new Color(211, 211, 211);
    private int xStart, yStart, xEnd, yEnd;
    private int amplitude = 2; 
    private double frequency = 0.004; 
    private double phase = 0; 

    /**
     * @param int xStart, int yStart, int xEnd, int yEnd
     * 
     * constructor for coordinates of the road's position
     */
    public AirRoad(int xStart, int yStart, int xEnd, int yEnd) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
    }

    /**
     * calculates vertical offset of road's position based on a sine function
     * allows the road's to remain even with the building's movement
     */
    public int getYOffset() {
        return (int) (amplitude * Math.sin(phase));
    }

    
    /**
     * @param Graphics2D page
     * 
     * draws the road with a dark gray to light gray gradient to simulate a realistic "floating bridge"
     * and adds a shadow beneath via a basicstroke to make it more realistic
     */
    public void draw(Graphics2D page) {
        int yOffset = getYOffset();

        
        GradientPaint roadGradient = new GradientPaint(xStart, yStart + yOffset, Color.DARK_GRAY, 
                                    xEnd, yEnd + yOffset, Color.LIGHT_GRAY);
        page.setPaint(roadGradient);

        page.setStroke(new BasicStroke(6)); 
        page.drawLine(xStart, yStart + yOffset, xEnd, yEnd + yOffset);

        page.setColor(new Color(0, 0, 0, 100));  
        page.setStroke(new BasicStroke(8));  
        page.drawLine(xStart + 2, yStart + yOffset + 2, xEnd + 2, yEnd + yOffset + 2);
    }
    
    /**
     * loop for oscillating the road
     */
    public void run() {
        while (true) {
            try {
                Thread.sleep(20); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


