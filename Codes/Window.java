import java.awt.*;

public class Window extends Rectangle {
    private Color color;
    private Building building;
    private int originalYOffset;
    
    /**
     * @param int x, int y, int width, int height, Building building
     * 
     * intializes window's position relative to building, 
     * using dimensions and building's coordinates to calculate window position,
     * and sets window color.
     */
    public Window(int x, int y, int width, int height, Building building) {
        super(x, y, width, height);
        this.building = building;
        this.originalYOffset = y - building.y; // stores difference between window's y position and building's y positio
        this.color = new Color(192, 192, 192);  
    }

    public int getOriginalYOffset() {
        return originalYOffset;
    }

    /**
     * @param int x, int new Y
     * 
     * window's position able to fit within new coordinates and fit within building
     */
    public void updatePosition(int x, int newY) {
        this.x = x;
        this.y = newY;  
    }

    /**
     * @param Graphics2D page
     * 
     * fills rectangles (windows)
     */
    public void draw(Graphics2D page) {
        page.setColor(color);
        page.fillRect(x, y, width, height);
    }

    /**
     * @param double progress
     * 
     * flash effect uses a sine wave function to oscillate the window's brightness between light and dark
     * allowing for a smoother shift
     */
    public void updateFlash(double progress) {
        int flashIntensity = (int) (Math.sin(progress * 2 * Math.PI) * 127 + 128); 
        this.color = new Color(flashIntensity, flashIntensity, flashIntensity); 
    }
}
