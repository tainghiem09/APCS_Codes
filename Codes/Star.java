import java.awt.*;
import java.util.Random;

public class Star {
    private int x, y;
    private int size;
    private float opacity;
    private Random rand;
    
    /**
     * @param int x, int y
     * 
     * constructor for Stars
     */

    public Star(int x, int y) {
        this.x = x;
        this.y = y;
        this.size = (int) (Math.random() * 2 + 1);
        this.opacity = 1.0f;
        this.rand = new Random();
    }

    public void setXandY(int x, int y) {
        this.x = rand.nextInt(1000);  
        this.y = rand.nextInt(1000);  
    }

    /**
     * sets stars to "twinkle" with various opacities for added realism
     */
    public void twinkle() {
        opacity = rand.nextFloat() * 0.7f + 0.3f;  
    }

    public void draw(Graphics2D g) {
        g.setColor(new Color(1.0f, 1.0f, 1.0f, opacity)); 
        g.fillOval(x, y, size, size);  
    }
}

