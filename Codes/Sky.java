import java.awt.*;
import java.util.ArrayList;
import java.util.Random;


public class Sky {
    private Cloud[] clouds = new Cloud[10];  
    private Star[] stars = new Star[500];    
    private Random rand;

    private int sunX, sunY, moonX, moonY;

    /**
     * constructor for sky that also has clouds and stars
     */
    public Sky() {
        this.clouds = clouds;
        this.stars = stars;
        this.rand = new Random();
        initializeClouds();
        initializeStars();

        sunX = 0; 
        sunY = 100; 
        moonX = 1000; 
        moonY = 100;  
    }

    private void initializeClouds() {
    for (int i = 0; i < clouds.length; i++) {
        clouds[i] = new Cloud(rand.nextInt(1000), rand.nextInt(200));
    }
}   

    private void initializeStars() {
    for (int i = 0; i < stars.length; i++) {
        stars[i] = new Star(rand.nextInt(1000), rand.nextInt(1000));
    }
}

    /**
 * @param Graphics2D g, int width, int height, float dayProgress
 * 
 * draws the sky with updated sun and moon positions based on the progress of the day
 * (whether it is nearing night or etc) and also allows the clouds to move and stars
 * to "twinkle" for added realism
 */
    public void draw(Graphics2D g, int width, int height, float dayProgress) {
    
    Color skyColor = calculateSkyColor(dayProgress);
    GradientPaint sky = new GradientPaint(0, 0, skyColor, 0, height, skyColor);
    g.setPaint(sky);
    g.fillRect(0, 0, width, height);

    updateSunMoonPositions(dayProgress);

    if (dayProgress < 0.5) {
        g.setColor(Color.YELLOW);
        g.fillOval(sunX, sunY, 100, 100); 
    } else {
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(moonX, moonY, 100, 100);  
    }

    if (dayProgress >= 0.5) {
        for (Star star : stars) {
            star.twinkle();  
            star.draw(g);
        }
    }

    for (Cloud cloud : clouds) {
        cloud.move(); 
        cloud.draw(g);
    }
}

/**
 * @param float dayProgress
 * 
 * based on the day's progress, the sun and moon positions are updated
 */
private void updateSunMoonPositions(float dayProgress) {
    int screenWidth = 1000;  
    int screenHeight = 1000; 

    if (dayProgress < 0.5) {
        sunX = (int) (dayProgress * screenWidth * 2);  
        sunY = 100; 
    } else {
        sunX = screenWidth;  
        moonX = (int) ((dayProgress - 0.5) * screenWidth * 2);  
        moonY = 100;  
    }
}


    /**
     * @param float progress
     * 
     * based on the progress of the day/night cycle (0 - 0.5 being day, 0.5 - 1.0 being night)
     * the sky's gradient will change in accordance
     */
    private Color calculateSkyColor(float progress) {
        int rStart = 135, gStart = 206, bStart = 235;
        int rEnd = 0, gEnd = 0, bEnd = 128;

        int r, g, b;

        if (progress < 0.5) {
            float ratio = progress * 2; 
            r = (int) (rStart - (rStart - rEnd) * ratio);
            g = (int) (gStart - (gStart - gEnd) * ratio);
            b = (int) (bStart - (bStart - bEnd) * ratio);
        } 
        else {
            float ratio = (progress - 0.5f) * 2; 
            r = (int) (rEnd + (rStart - rEnd) * ratio);
            g = (int) (gEnd + (gStart - gEnd) * ratio);
            b = (int) (bEnd + (bStart - bEnd) * ratio);
        }

        return new Color(r, g, b);
    }
}





