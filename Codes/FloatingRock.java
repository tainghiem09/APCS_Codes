import java.awt.*;

public class FloatingRock extends Rectangle implements Runnable {
    private Color rockColor = new Color(111, 83, 47);
    private Color shadowColor = new Color(80, 60, 35);

    private int amplitude = 6;  // less amplitude than building
    private double frequency = 0.02;
    private double phase = 0;
    private boolean running = true;
    private int originalY;

    /**
     * @param int x, int y
     * 
     * creates a FloatingRock object
     */
    public FloatingRock(int x, int y) {
        super(x, y, 160, 40); 
        this.originalY = y; 
    }

    public void stopAnimation() {
        running = false; 
    }

    /**
     * updates the position of the rock using
     * a sine function to subtly oscillate up and down
     */
    public void updatePosition() {
        phase += frequency;
        int newY = (int) (originalY + amplitude * Math.sin(phase));  
        this.setLocation(x, newY);  
    }

    /**
     * draws the rock with shadows to be realistic
     */
    public void draw(Graphics2D page) {
        page.setColor(rockColor);
        page.fillRoundRect(x, y, width, height, 50, 50);

        page.setColor(shadowColor);
        page.fillOval(x + 20, y + height - 10, width - 40, 15);
    }

    @Override
    public void run() {
        while (running) {
            updatePosition();
            try {
                Thread.sleep(20); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

