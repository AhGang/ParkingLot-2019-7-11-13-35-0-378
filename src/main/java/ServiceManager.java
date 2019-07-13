import com.thoughtworks.tdd.Ticket;

import java.util.ArrayList;

public class ServiceManager extends ParkingBoy {
    private ArrayList<ParkingBoy> manageList;
    private String errorMsg;

    public ArrayList<ParkingBoy> getManageList() {
        return manageList;
    }

    public void setManageList(ArrayList<ParkingBoy> manageList) {
        this.manageList = manageList;
    }

    public Ticket specifyAParkingBoyToParkACar(Car car,ParkingBoy parkingBoy,ParkingLot parkingLot) {
        for(int i = 0; i < manageList.size();i++){
            if(manageList.get(i) == parkingBoy){
                for (int j = 0; j < parkingBoy.getParkingLotList().size();j++ ){
                    if(parkingBoy.getParkingLotList().get(j) == parkingLot){
                        return  parkingBoy.parkACarToSpecifyParkingLot(car);
                    }else{
                        return null;
                    }
                }
            }
            else{
                return  null;
            }

        }
        return null;
    }

    public Ticket parkACar(Car car,ParkingLot parkingLot) {
        for (int i = 0;i < super.getParkingLotList().size();i++){
            if(super.getParkingLotList().get(i) == parkingLot){
                if(car.isParked()){
                    throw new RuntimeException();
                }else if(car == null){
                    throw new RuntimeException();
                }else{
                    return ParkingLot.getATicket();
                }
            }
        }
        return null;
    }

    @Override
    public String getErrorMsg() {
        return errorMsg;
    }

    @Override
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public ArrayList<ParkingBoy> manageParkingBoy() {
        return this.manageList;

    }
}
