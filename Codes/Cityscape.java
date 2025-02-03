import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Cityscape extends JComponent {
    private FloatingRock rock1;
    private FloatingRock rock2;
    private FloatingRock rock3;

    private Building building1;
    private Building building2;
    private Building building3;

    private AirRoad road1;
    private AirRoad road2;

    private FloatingPod pod1, pod2;      
    private Drone drone1;
    private Drone drone2;
    private Drone drone3;
    
    private Sky sky;
    private Timer timer;
    
    private Floor floor;

    public Cityscape() {
    
    sky = new Sky(); 
    
    rock1 = new FloatingRock(70, 550);  
    rock2 = new FloatingRock(370, 550); 
    rock3 = new FloatingRock(670, 550); 

    building1 = new Building(rock1); 
    building2 = new Building(rock2); 
    building3 = new Building(rock3); 
    
    drone1 = new Drone(0, 100, 2);  
    drone2 = new Drone(0, 150, 3);  
    drone3 = new Drone(0, 50, 4);   

    // calculates the positions of the air roads based on their positions relative to the buildings
    int road1StartX = building1.x + building1.width; 
    int road1StartY = building1.y + building1.height / 2;  
    int road1EndX = building2.x; 
    int road1EndY = building2.y + building2.height / 2;  

    int road2StartX = building2.x + building2.width; 
    int road2StartY = building2.y + building2.height / 2; 
    int road2EndX = building3.x; 
    int road2EndY = building3.y + building3.height / 2; 

    road1 = new AirRoad(road1StartX, road1StartY, road1EndX, road1EndY);
    road2 = new AirRoad(road2StartX, road2StartY, road2EndX, road2EndY);

    // creates pods based on air road dimensions
    pod1 = new FloatingPod(road1StartX, road1StartY, road1EndX, road1EndY);
    pod2 = new FloatingPod(road2StartX, road2StartY, road2EndX, road2EndY);

    floor = new Floor(1000, 1000);  

    new Thread(rock1).start();
    new Thread(rock2).start();
    new Thread(rock3).start();

    new Thread(building1).start();
    new Thread(building2).start();
    new Thread(building3).start();

    new Thread(road1).start();
    new Thread(road2).start();

    new Thread(pod1).start();
    new Thread(pod2).start();
    
    new Thread(drone1).start();
    new Thread(drone2).start();
    new Thread(drone3).start();
    
    // timer for day night cycle
    timer = new Timer(16, e -> {
        DayNightCycle.updateDayProgress();
        repaint();
    });
    timer.start();
}


    @Override
public void paintComponent(Graphics g) {
    super.paintComponent(g); 
    Graphics2D g2d = (Graphics2D) g;

    float dayProgress = DayNightCycle.getDayProgress();

    sky.draw(g2d, getWidth(), getHeight(), dayProgress);

    floor.draw(g2d);

    road1.draw(g2d);
    road2.draw(g2d);

    rock1.draw(g2d);
    rock2.draw(g2d);
    rock3.draw(g2d);

    building1.draw(g2d, dayProgress);
    building2.draw(g2d, dayProgress);
    building3.draw(g2d, dayProgress);

    pod1.draw(g2d);
    pod2.draw(g2d);

    drone1.draw(g2d);
    drone2.draw(g2d);
    drone3.draw(g2d);
}

}



