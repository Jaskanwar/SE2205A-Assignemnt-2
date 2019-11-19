import java.lang.*;

public class QueueSimulator {
    public enum Event {ARRIVAL, DEPARTURE};
    private double currTime;
    private double arrivalRate;
    private double serviceTime;
    private double timeForNextArrival;
    private double timeForNextDeparture;
    private double totalSimTime;
    LinkedListQueue<Data> buffer = new LinkedListQueue<Data>();
    LinkedListQueue<Data> eventQueue = new LinkedListQueue<Data>();
    private Event e;

    public double getRandTime(double arrivalRate) {
        double num, time1, max = 1, min = 0, randNUM;
        randNUM = Math.random();
        time1 = (-1 / arrivalRate) * (Math.log(1 - randNUM));
        //System.out.println(time1);
        return time1;
    }

    public QueueSimulator(double aR, double servT, double simT) {
        arrivalRate = aR;
        serviceTime = servT;
        totalSimTime = simT;
        currTime = 0;
    }

    public double calcAverageWaitingTime() {
        double waitTime = 0;
        int totPackets = 0;
        while (eventQueue.isEmpty() == false) {
            Data node = eventQueue.dequeue();
            waitTime += (node.getDepartureTime() - node.getArrivalTime());
            totPackets++;
        }
        return waitTime / totPackets;
    }

    public double runSimulation() {
        timeForNextArrival = getRandTime(arrivalRate);
        timeForNextDeparture = serviceTime + timeForNextArrival;
        while (currTime < totalSimTime) {   //Runs until the current time is greater then the total simulation time
            if ((timeForNextArrival < timeForNextDeparture) || buffer.isEmpty()) {  //runs if its empty or if arrival time is less than departure time
                currTime += timeForNextArrival;
                Data node = new Data();
                node.setArrivalTime(currTime);
                buffer.enqueue(node);
                timeForNextDeparture = timeForNextDeparture - timeForNextArrival;
                timeForNextArrival = getRandTime(arrivalRate);
            } else {
                currTime += timeForNextDeparture;
                Data node = buffer.dequeue();
                node.setDepartureTime(currTime);
                eventQueue.enqueue(node);
                timeForNextArrival = timeForNextArrival - timeForNextDeparture;

                if (buffer.isEmpty()) {
                    timeForNextDeparture = timeForNextArrival + serviceTime;       //sets departure time if its empty
                } else {
                    timeForNextDeparture = serviceTime;     //sets departure time if it is not empty
                }
            }
        }
        return calcAverageWaitingTime();
    }
}