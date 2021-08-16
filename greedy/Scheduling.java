package greedy;

/**
 * Problem   :  Given n events with starting and ending times, find a schedule that includes as many events as possible.
 * Algorithm :  Greedy solution which selects next possible event that ends as early as possible.
 * Evaluation:  Will always produce an optimal solution as it aims to get to the next event as quickly as possible. Alterntive solutions 
 *              include selecting as many short events as possible and selecting next possible event that begins as early as possible. It 
 *              is not always the case that these algorithms will produce optimal solutions.
 */
public class Scheduling{

    public static void algorithm(Event[] events){

        // sort the given array for events to be in order of their end time
        sort(events);

        // algorithm
        int solutionIndex = 0;
        Event[] solution = new Event[events.length];
        for(int i = 0;  i < solution.length; i++) solution[i] = null;
        for(int i = 0; i < events.length; i++){
            if(i == 0) solution[solutionIndex++] = events[i];
            else{
                if(events[i].getStart() >= solution[solutionIndex-1].getEnd()){
                    solution[solutionIndex++] = events[i];
                }
            }
        }

        // print
        System.out.print("Solution: ");
        for(int i = 0; i < solution.length; i++){
            if(solution[i] != null) System.out.print(solution[i].getEvent() + " ");
        }
        System.out.println(" ");

    }

    private static void sort(Event[] arr){
        int n = arr.length-1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                // if event at index j ends after element at index j+1, swap them
                if(arr[j].getEnd() > arr[j+1].getEnd()){
                    // swap the elements
                    Event temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args){
        Event eventA = new Event("A", 1, 3);
        Event eventB = new Event("B", 2, 5);
        Event eventC = new Event("C", 3, 9);
        Event eventD = new Event("D", 6, 8);

        Event[] events = {eventA, eventB, eventC, eventD};
        algorithm(events);
        
    }
}

class Event{
    private String event;
    private int start;
    private int end;

    Event(String event, int start, int end){ 
        this.event = event;
        this.start = start;
        this.end = end;
    }

    public String getEvent(){return event;} 
    public int getStart(){return start;}
    public int getEnd(){return end;}

}