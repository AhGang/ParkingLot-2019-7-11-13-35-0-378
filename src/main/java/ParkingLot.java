import com.thoughtworks.tdd.Ticket;

import java.util.ArrayList;

public class ParkingLot {
    int capacity;
    int parkedCarCount;
    boolean isFulled = false;
    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }
    public ParkingLot(int capacity, int parkedCarCount) {
        this.capacity = capacity;
        this.parkedCarCount = parkedCarCount;
    }
    public ParkingLot(int capacity, int parkedCarCount, boolean isFulled) {
        this.capacity = capacity;
        this.parkedCarCount = parkedCarCount;
        this.isFulled = isFulled;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getParkedCarCount() {
        return parkedCarCount;
    }

    public void setParkedCarCount(int parkedCarCount) {
        this.parkedCarCount = parkedCarCount;
    }


    public static Ticket getATicket() {
        return new Ticket(false,true);
    }

    public static Car returnACar() {
        return new Car();
    }

    public static ArrayList<Ticket> getTickets(ArrayList<Car> carList) {
        return new ArrayList<Ticket>();
    }

    public boolean isCapacityFulled() {
        if(this.parkedCarCount < this.capacity){
            return false;
        }else{
            this.isFulled = true;
            return true;
        }
    }
}
