import java.awt.*;

public class FloatingPod extends Rectangle implements Runnable {
    private Color podColor;
    private int startX, startY, endX, endY;
    private double progress = 0.0;
    private boolean movingForward = true;
    private boolean running = true;

    private static final int POD_WIDTH = 80;
    private static final int POD_HEIGHT = 40;
    private static final Color BASE_COLOR = new Color(100, 100, 255);
    private static final Color HIGHLIGHT_COLOR = new Color(150, 150, 255);
    private static final Color LIGHT_COLOR = new Color(180, 180, 255);
    private static final Color BUTTON_COLOR = new Color(255, 255, 100);
    private static final Color SHADOW_COLOR = new Color(0, 0, 0, 80);
    private static final Color DETAIL_COLOR = new Color(255, 255, 255, 100);

    /**
     * @param int startX, int startY, int endX, int endY
     * 
     * constructor to create floating pod
     */
    public FloatingPod(int startX, int startY, int endX, int endY) {
        super(startX + 30, startY, POD_WIDTH, POD_HEIGHT); 
        this.startX = startX + 30;
        this.startY = startY;
        this.endX = endX - 40;
        this.endY = endY;
        this.podColor = BASE_COLOR;
    }

    public void stopAnimation() {
        running = false;
    }

    /**
     * updates the position of the floating pod to either move forward across the road or backwards
     */
    public void updatePosition() {
        if (movingForward) {
            progress += 0.01;
        } else {
            progress -= 0.01;
        }
        if (progress >= 0.95) {
            movingForward = false;
        }
        if (progress <= 0.0) {
            movingForward = true;
        }
            
        int xPos = (int) (startX + (endX - startX) * progress);
        int yPos = (int) (startY + (endY - startY) * progress);
        this.setLocation(xPos - 30, yPos - 40);
    }

    /**
     * @param Graphics2D g
     * 
     * method for drawing the body of the pod
     */
    private void drawPodBody(Graphics2D g) {
        GradientPaint gradient = new GradientPaint(x, y, BASE_COLOR, x + POD_WIDTH, y + POD_HEIGHT, HIGHLIGHT_COLOR);
        g.setPaint(gradient);
        g.fillRoundRect(x, y, POD_WIDTH, POD_HEIGHT, 20, 20);
    }

    /**
     * @param Graphics2D g
     * 
     * method for drawing other details of the pod (such as buttons, lights)
     * to make the pod seem more realistic
     */
    private void drawPodDetails(Graphics2D g) {
        g.setColor(LIGHT_COLOR); 
        g.fillRoundRect(x + 10, y + 5, POD_WIDTH - 20, POD_HEIGHT / 2, 15, 15);
        g.setColor(LIGHT_COLOR);  
        g.fillOval(x + 10, y + POD_HEIGHT - 8, 15, 10);
        g.fillOval(x + POD_WIDTH - 25, y + POD_HEIGHT - 8, 15, 10);
        g.setColor(Color.GRAY);  
        g.fillRect(x + 20, y + 5, 40, 8); 
        g.setColor(BUTTON_COLOR);  
        g.fillOval(x + 5, y + 12, 8, 8);
        g.fillOval(x + POD_WIDTH - 13, y + 12, 8, 8);  
    }

    /**
     * below are all methods that take @param Graphics2D g
     * and add more details to make the pod seem realistic
     * 
     */
    private void drawShadows(Graphics2D g) {
        g.setColor(SHADOW_COLOR);  
        g.fillOval(x + 5, y + POD_HEIGHT, POD_WIDTH - 10, 5);
    }

    private void drawDetails(Graphics2D g) {
        g.setColor(DETAIL_COLOR);  
        g.fillRoundRect(x + 12, y + 8, POD_WIDTH - 24, POD_HEIGHT / 3, 8, 8);
    }

    /**
     * @param Graphics2D g
     * draws the pod
     */
    public void draw(Graphics2D g) {
        drawPodBody(g);
        drawPodDetails(g);
        drawShadows(g);
        drawDetails(g);
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
