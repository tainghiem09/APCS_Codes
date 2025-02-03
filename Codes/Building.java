import java.awt.*;
import java.util.ArrayList;

public class Building extends Rectangle implements Runnable {
    private Color light = new Color(160, 160, 160);
    private Color dark = new Color(150, 150, 150);
    private ArrayList<Window> windows;
    private FloatingRock rock;
    private boolean running = true;
    private int amplitude = 10;
    private double frequency = 0.02;
    private double phase = 0;
    private int originalY;

    
    private double flashProgress = 0;
    private double flashSpeed = 0.05;  
    
    /**
     * @param FloatingRock rock
     * 
     * builds the building atop the rock (based on rock's position)
     */

    public Building(FloatingRock rock) {
        super(rock.x + 30, rock.y - 300, 100, 300);
        this.rock = rock;
        this.originalY = this.y;
        this.windows = new ArrayList<>();
        initializeWindows();  
    }

    /**
     * initializes windows one time with extra padding in betwen
     * and also makes sure that the windows fit within the building's parameters
     */
    private void initializeWindows() {
        int windowWidth = 20;
        int windowHeight = 30;
        int padding = 10;

        // outer loop controls horizontal window position, inner loop for vertical window position
        // new window objects created with the Building being the parent so that the window fits
        // within the building's dimensions
        for (int i = x + padding; i < x + width - windowWidth; i += windowWidth + padding) {
            for (int j = y + padding; j < y + height - windowHeight; j += windowHeight + padding) {
                Window window = new Window(i, j, windowWidth, windowHeight, this);
                windows.add(window);
            }
        }
    }

    public void stopAnimation() {
        running = false;
    }

    public int getYOffset() {
        return (int) (amplitude * Math.sin(phase));
    }

    /**
     * updates the window's positions based on the building's positions
     * effectively oscillates them "together" so that movement looks continuous
     */
    public void updatePosition() {
        phase += frequency;
        this.y = originalY + getYOffset();

        int windowIndex = 0;
        int padding = 10;
        for (int i = x + padding; i < x + width - 20; i += 30) {
            for (int j = y + padding; j < y + height - 30; j += 40) {
                if (windowIndex < windows.size()) {
                    windows.get(windowIndex).updatePosition(i, j);
                    windowIndex++;
                }
            }
        }
    }

    /**
     * updates the windows to flash
     * based on the day/night cycle (only flash during night)
     */
    private void updateFlashProgress() {
        float dayProgress = DayNightCycle.getDayProgress(); 
        
        if (dayProgress >= 0.5) {  
            flashProgress += flashSpeed;
            if (flashProgress >= 1) {
                flashProgress = 0;  
            }

            for (Window window : windows) {
                window.updateFlash(flashProgress);
            }
        } else {
            flashProgress = 0;
            for (Window window : windows) {
                window.updateFlash(flashProgress);  
            }
        }
    }

    /**
     * @param Graphics2D page, float dayProgress
     * 
     * draws the buildings and windows
     * and adds the flashing aspect if necessary
     */
    public void draw(Graphics2D page, float dayProgress) {
    page.setColor(dark);
    page.fillRect(x, y, width, height);  

    page.setColor(light);
    page.fillRect(x + 10, y, width - 20, height);

    for (Window window : windows) {
        window.draw(page); 

        if (dayProgress >= 0.5) {  
            flashProgress += flashSpeed;
            window.updateFlash(flashProgress);

            if (flashProgress >= 1) {
                flashProgress = 0;  
                window.updateFlash(flashProgress);
            }

        } else {
            flashProgress = 0;
            window.updateFlash(flashProgress);
        }

        dayProgress += 0.001;  
        if (dayProgress >= 1.0) {
            dayProgress = 0; 
            window.updateFlash(flashProgress);
        }
    }
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



