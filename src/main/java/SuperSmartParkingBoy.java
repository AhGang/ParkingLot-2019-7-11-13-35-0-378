import com.thoughtworks.tdd.Ticket;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class SuperSmartParkingBoy extends ParkingBoy {
        @Override
        public ArrayList<Ticket> parkMultiplyCars(ArrayList<Car> carList) {

            int countOfCar = carList.size();
            double valueTemp;
            int keyTemp = 0;
            for(int j = 0; j < countOfCar;j++) {
                valueTemp = 0;
                for (int i = 0; i < this.getParkingLotList().size(); i++) {
                    if(valueTemp < (double) (this.getParkingLotList().get(i).getRemainingCount()*1.0 / this.getParkingLotList().get(i).getCapacity())){
                        valueTemp = (double) (this.getParkingLotList().get(i).getRemainingCount() *1.0 / this.getParkingLotList().get(i).getCapacity());
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
