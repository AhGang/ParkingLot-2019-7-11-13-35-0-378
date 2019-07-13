import com.thoughtworks.tdd.Ticket;

import java.util.ArrayList;

public class ParkingBoy {
    private String ErrorMsg;
    private Ticket ticket;
    private ArrayList<ParkingLot> parkingLotList;

    public ParkingBoy() {
    }


    public ArrayList<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public void setParkingLotList(ArrayList<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }


    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }


    public String getErrorMsg() {
        return ErrorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        ErrorMsg = errorMsg;
    }
    public Ticket parkACar(Car car) {
        if(car.isParked()){
            throw new RuntimeException();
        }else if(car == null){
            throw new RuntimeException();
        }else{
            return ParkingLot.getATicket();
        }
    }
    public Car fetchACar(boolean isValidTicket) {
        if (isValidTicket){
            return ParkingLot.returnACar();
        }else {
            this.setErrorMsg("Unrecognized parking ticket.");
            return null;
        }

    }

    public ArrayList<Ticket> parkMultiplyCars(ArrayList<Car> carList) {
        int countOfCar = carList.size();
        for(int j = 0; j < countOfCar;j++) {
            for(int i = 0 ;i < parkingLotList.size();i++ ){
                 if (parkingLotList.get(i).getRemainingCount() > 0){
                    parkingLotList.get(i).setParkedCarCount(1);
                    parkingLotList.get(i).setRemainingCount(1);
                    this.parkACar(carList.get(j));
                    break;
                }
                }
            }
        if(countOfCar > 0){
            this.checkParkingLotStatus(getParkingLotList().get(0));
        }
        return ParkingLot.getTickets(carList);
    }

    public boolean useCorrespondTicket(ArrayList<Ticket> ticketList) {
        return true;
    }

    public boolean checkTicket(Ticket ticket) {
        if(ticket == null){
            this.setErrorMsg("Please provide your parking ticket.");
            return false;
        }
        else if(ticket.isProvided() == true && ticket.isUsed() == false){
            return true;
        }else{
            return  false;
        }
    }

    public Boolean checkParkingLotStatus(ParkingLot parkingLot) {
        if(parkingLot.isFulled){
            this.setErrorMsg("Not enough position.");
            return true;
        }else{
            return false;
        }

    }

    public int[] getParkingLotCount() {
        int[] arr = new int[parkingLotList.size()];
        for(int i = 0 ;i < parkingLotList.size();i++ ){
            arr[i] = getParkingLotList().get(i).getParkedCarCount();
        }
        return arr;
    }

    protected Ticket parkACarToSpecifyParkingLot(Car car) {
        return new Ticket();
    }
}
