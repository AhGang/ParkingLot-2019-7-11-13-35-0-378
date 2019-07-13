import com.thoughtworks.tdd.Ticket;

import java.util.ArrayList;

public class SmartParkingBoy extends ParkingBoy {
    @Override
    public ArrayList<Ticket> parkMultiplyCars(ArrayList<Car> carList) {

        int countOfCar = carList.size();
        int valueTemp;
        int keyTemp = 0;
        for(int j = 0; j < countOfCar;j++) {
            valueTemp = 0;
            for (int i = 0; i < this.getParkingLotList().size(); i++) {
                if(valueTemp < this.getParkingLotList().get(i).getRemainingCount() ){
                    valueTemp = this.getParkingLotList().get(i).getRemainingCount();
                    keyTemp = i;
                }
            }
            if(valueTemp > 0){
                this.getParkingLotList().get(keyTemp).setParkedCarCount(1);
                this.getParkingLotList().get(keyTemp).setRemainingCount(1);
                this.parkACar(carList.get(j));
            }else{
                this.checkParkingLotStatus(getParkingLotList().get(keyTemp));
            }
            }

        return ParkingLot.getTickets(carList);
    }
}
