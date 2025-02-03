import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Floor {
    private int x, y, width, height;
    private Color grassColor;
    private Color dirtColor;
    private Random rand;

    /**
     * @param int screenWidth, int screenHeight
     * 
     * constructor for Floor
     */
    public Floor(int screenWidth, int screenHeight) {
        this.width = screenWidth;
        this.height = 100;  // Floor thickness
        this.x = 0;
        this.y = screenHeight - height;
        this.grassColor = new Color(34, 139, 34); // Grass green
        this.dirtColor = new Color(100, 50, 20);  // Base brown for dirt
        this.rand = new Random();
    }

    /**
     * draws the ground and also uses for loops
     * to create and simulate a simplified "growth" animation
     * without implementing or using Runnable methods
     */
    public void draw(Graphics2D g) {
        // gradient for the dirt
        GradientPaint dirtGradient = new GradientPaint(
            x, y, new Color(120, 70, 40), 
            x, y + height, new Color(60, 30, 10)
        );
        g.setPaint(dirtGradient);
        g.fillRect(x, y, width, height);

        // adds some texture to the dirt
        g.setColor(new Color(80, 40, 20, 50));
        for (int i = 0; i < 300; i++) {
            int tx = x + rand.nextInt(width);
            int ty = y + rand.nextInt(height);
            g.fillRect(tx, ty, 2, 2);
        }

        // adds a layer of grass
        int grassHeight = 15;
        GradientPaint grassGradient = new GradientPaint(
            x, y, new Color(50, 205, 50), 
            x, y + grassHeight, new Color(34, 139, 34)
        );
        g.setPaint(grassGradient);
        g.fillRect(x, y, width, grassHeight);

        // adds a little highlight atop the grass to give texture
        g.setColor(new Color(200, 255, 200, 80));
        g.fillRect(x, y, width, 3);

        // adds small rocks that are "embedded" within the dirt
        g.setColor(new Color(150, 150, 150)); 
        for (int i = 0; i < 10; i++) {
            int rockX = rand.nextInt(width);
            int rockY = y + rand.nextInt(height - 10);
            int rockSize = rand.nextInt(6) + 3;
            g.fill(new Ellipse2D.Double(rockX, rockY, rockSize, rockSize));
        }

        // adds tufts of grass
        g.setColor(new Color(25, 100, 25)); 
        for (int i = 0; i < 10; i++) {
            int gx = rand.nextInt(width);
            int gy = y - rand.nextInt(5);
            int gwidth = 6 + rand.nextInt(5);
            int gheight = 10 + rand.nextInt(10);
            g.fillRect(gx, gy, gwidth, gheight);
        }

        // small flowers atop grass
        Color[] flowerColors = {Color.YELLOW, Color.RED, Color.WHITE};
        for (int i = 0; i < 5; i++) {
            g.setColor(flowerColors[rand.nextInt(flowerColors.length)]);
            int fx = rand.nextInt(width);
            int fy = y - rand.nextInt(10);
            g.fillOval(fx, fy, 4, 4);
        }
    }
}
