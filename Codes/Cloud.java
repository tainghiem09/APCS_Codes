import java.awt.*;

public class Cloud {
    private int x, y;
    private int width, height;
    private Color color;
    
    /**
     * @param int x, int y
     * 
     * Constructor for Cloud
     */
    public Cloud(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = (int) (Math.random() * 200 + 100);
        this.height = (int) (Math.random() * 50 + 30);
        this.color = new Color(255, 255, 255, (int) (Math.random() * 100 + 50));
    }

    /**
     * moves the clouds across the screen
     */
    public void move() {
        this.x += 1;
        if (this.x > 1000) {  
            this.x = -width;
        }
    }

    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);  
    }
}

