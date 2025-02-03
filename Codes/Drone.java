import java.awt.*;

public class Drone implements Runnable {
    private int x, y;
    private int startX, startY;
    private int speed;
    private Color bodyColor;
    private double rotorRotation = 0;  
    private boolean running = true;

    /**
     * @param int startX, int startY, int speed
     * 
     * constructor for drone
     */
    public Drone(int startX, int startY, int speed) {
        this.startX = startX;
        this.startY = startY;
        this.x = startX;
        this.y = startY;
        this.speed = speed;
        this.bodyColor = new Color(200, 200, 255);  
    }

    public void stopAnimation() {
        running = false;  
    }

    /**
     * updates the position of the drone to move across the screen
     * and to fly up and down
     */
    public void updatePosition() {
        x += speed;
        rotorRotation += 5;  

        if (x > 1000) {  
            x = -50;  
        }

        y = (int) (startY + Math.sin(System.currentTimeMillis() / 200.0) * 20);
    }

    /**
     * @param Graphics2D g
     * 
     * draws the drone's body and also the rotors (to have a propeller-like shape)
     * also draws the drone's lights for added realism
     */
    public void draw(Graphics2D g) {
        g.setColor(bodyColor);
        g.fillRoundRect(x, y, 40, 25, 10, 10); 

        int rotorOffsetXLeft = 0; 
        int rotorOffsetXRight = 40;  
        int rotorOffsetY = -10; 

        g.setColor(new Color(180, 180, 180)); 
        drawRotor(g, rotorOffsetXLeft, rotorOffsetY, rotorRotation); 
        drawRotor(g, rotorOffsetXRight, rotorOffsetY, rotorRotation);  

        g.setColor(new Color(255, 255, 255));
        g.fillOval(x + 10, y + 5, 7, 7);  
        g.fillOval(x + 22, y + 5, 7, 7);  
    }

    /**
     * @param Graphics2D g, int offsetX, int offsetY, double angle
     * 
     * draws the rotor with a specified length and width
     * also uses .translate and .rotate to help align the rotor and rotate
     * the rotor in a circular pattern to simulate movement
     */
    private void drawRotor(Graphics2D g, int offsetX, int offsetY, double angle) {
        int rotorLength = 20;  
        int rotorWidth = 4;   

        int rotorX1 = x + offsetX;
        int rotorY1 = y + offsetY;

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.translate(rotorX1, rotorY1);  
        g2d.rotate(Math.toRadians(angle));  

        g2d.setColor(new Color(180, 180, 180));  

        g2d.fillRoundRect(-rotorLength / 2, -rotorWidth / 2, rotorLength, rotorWidth, 15, 15);

        g2d.fillRoundRect(-rotorWidth / 2, -rotorLength / 2, rotorWidth, rotorLength, 15, 15);
    }

    @Override
    public void run() {
        while (running) {
            updatePosition();
            try {
                Thread.sleep(20);  // Smooth animation at 50 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
