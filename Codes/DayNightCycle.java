public class DayNightCycle {
    private static float dayProgress = 0.0f;  // progresses the day from 0.0 to 1.0
    
    public static float getDayProgress() {
        return dayProgress;
    }
    
    /**
     * updates the day's progress as time goes on until the next day occurs, then resets and continues in a loop
     */
    public static void updateDayProgress() {
        dayProgress += 0.001f;  
        if (dayProgress >= 1.0f) {
            dayProgress = 0.0f;  
        }
    }
}
