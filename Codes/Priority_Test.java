/**
 * @Tai Nghiem
 * January 10, 2025
 * Created the client class for Task
 */
public class Priority_Test {
    public static void main(String[] args) {
        Task task1 = new Task("Happy birthday cake for twin", 1, true);
        Task task2 = new Task("Clean room", 2, true);
        Task task3 = new Task("Clear out phone storage", 3);
        Task task4 = new Task("Finish homework", 4);
        Task task5 = new Task("Mead to tutoring", 5);
        Task task6 = new Task("Head to tutoring", 5);
        Task task7 = new Task("Pluck the weeds", 6, true);
        Task task8 = new Task("Get gas for the car", 6.1);
        Task task9 = new Task("Relax", 1000.2);

        // array sorts the tasks first by number, and then if have same number, alphabetically
        Task[] myTasks = {task1, task2, task3, task4, task5, task6, task7, task8, task9};
        Sorts.insertionSort(myTasks);
        for (Task t : myTasks) {
            System.out.println(t);
        }
    }
}

/** SAMPLE OUTPUT
 * 1.0   Happy birthday cake for twin is Done
2.0   Clean room is Done
3.0   Clear out phone storage
4.0   Finish homework
5.0   Head to tutoring
5.0   Mead to tutoring
6.0   Pluck the weeds is Done
6.1   Get gas for the car
1000.2   Relax
 */
