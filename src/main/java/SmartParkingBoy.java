import com.thoughtworks.tdd.Ticket;

import java.util.ArrayList;

public class SmartParkingBoy extends ParkingBoy {
    @Override
    public ArrayList<Ticket> parkMultiplyCars(ArrayList<Car> carList) {

        int countOfCar = carList.size();
        for(int i = 0; i < this.getParkingLotList().size();i++){
            if(countOfCar > 0){

            }
        }
        this.getParkingLotList().size();

        return ParkingLot.getTickets(carList);
    }
}
