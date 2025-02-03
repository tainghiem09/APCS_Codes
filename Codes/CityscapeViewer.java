import javax.swing.*;

public class CityscapeViewer {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        frame.setTitle("Cityscape with Floating Rocks");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Cityscape cityscape = new Cityscape();
        frame.add(cityscape);
        frame.setVisible(true);

        // animates loop
        while (true) {
            cityscape.repaint();
            try {
                Thread.sleep(20); // repaints
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
