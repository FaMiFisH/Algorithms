package greedy;

/**
 * Problem   :  Given n tasks with duararion and deadlines, choose an order to perform them resulting in the largest possible total score.
 *              For each task completion, d-x points are awarded where d is the task deadline and x is when the task is completed.
 * Algorithm :  The greedy algorithm simply orders the tasks by their duarations in increasing order to obtain the optimal solution.
 * Evaluation:  Suppose the shorter task A has duaration a and the longer task B has duaration b. To maximise the points obtained, we need to 
 *              minimise the points lost and maximise the points gained; resulting in b-a > 0.
 */
public class TasksAndDeadlines{

    public static void algorithm(Task[] tasks){

        // algorithm
        sort(tasks);

        // display
        System.out.print("Solution: ");
        for(int i = 0; i < tasks.length; i++){
            System.out.print(tasks[i].getTask() + " ");
        }
        System.out.println(" ");
    }

    private static void sort(Task[] arr){
        int n = arr.length-1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                // if task at index j is longer than element at index j+1, swap them
                if(arr[j].getDuaration() > arr[j+1].getDuaration()){
                    // swap the elements
                    Task temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args){

        Task taskA = new Task("A", 4, 2);
        Task taskB = new Task("B", 3, 5);
        Task taskC = new Task("C", 2, 7);
        Task taskD = new Task("D", 4, 5);

        Task[] tasks = new Task[] {taskA, taskB, taskC, taskD};
        algorithm(tasks);
    }

}

class Task{
    private String task;
    private int duaration;
    private int deadline;

    Task(String task, int duaration, int deadline){
        this.task = task;
        this.duaration = duaration;
        this.deadline = deadline;
    }

    public String getTask(){return task;}
    public int getDuaration(){return duaration;}
    public int getDeadline(){return deadline;}
}