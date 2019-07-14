import com.thoughtworks.tdd.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class ParkingLotTest {
    // 5mins / 2 mins
    @Test
    void should_get_a_ticket_when_park_a_car() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        //When&Then
        Assertions.assertNotNull(parkingBoy.parkACar(car));
    }
    // 5mins / 1mins
    @Test
    void should_fetch_a_car_when_give_a_ticket() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = new Ticket();
        //When&Then
        Assertions.assertNotNull(parkingBoy.fetchACar(true));
    }
    // 10mins / 10mins
    @Test
    void should_park_multiply_cars() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        ArrayList<Car> carList = new ArrayList<>();
        //When&Then
        Assertions.assertEquals(new ArrayList<Ticket>(),parkingBoy.parkMultiplyCars(carList));
    }
    // 15mins / 15mins
    @Test
    void should_fetch_right_car_when_using_correspond_ticket() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        ArrayList<Ticket> ticketList = new ArrayList<>();

        //When&Then
        Assertions.assertEquals(new Car().getClass(),parkingBoy.fetchACar(parkingBoy.useCorrespondTicket(ticketList)).getClass());
    }
    // 15mins / 10mins
    @Test
    void should_fetch_no_car_when_give_a_wrong_ticket() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = new Ticket(false,false);

        //When
        boolean isValidTicket = parkingBoy.checkTicket(ticket);
        // Then
        Assertions.assertEquals(null,parkingBoy.fetchACar(isValidTicket));
    }
    // 15mins / 10mins
    @Test
    void should_fetch_no_car_when_dose_provide_a_ticket() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = null;
        //When&Then
        Assertions.assertEquals(false, parkingBoy.checkTicket(ticket));
    }
    // 15mins / 10mins
    @Test
    void should_not_park_a_car_when_parking_lot_have_no_position() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        //When
        parkingLot.setParkedCarCount(10);
        boolean isCapacityFulled = parkingLot.isCapacityFulled();
        // Then
        Assertions.assertEquals(null,isCapacityFulled?null:parkingBoy.parkACar(car));
    }
    // 5mins / 2mins
    @Test
    void should_throw_park_a_car_when_Passing_a_parked_car() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        car.setParked(true);
        //When&Then
        Assertions.assertThrows(RuntimeException.class, ()-> { parkingBoy.parkACar(car); });
    }
    // 5mins / 2mins
    @Test
    void should_throw_park_a_car_when_Passing_null_car() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = null;
        //When&Then
        Assertions.assertThrows(RuntimeException.class, ()-> { parkingBoy.parkACar(car); });
    }
    // 10mins / 10mins
    @Test
    void should_get_error_msg_when_give_a_wrong_ticket() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = new Ticket(true,false);
        //When
        boolean isValidTicket = parkingBoy.checkTicket(ticket);
        parkingBoy.fetchACar(isValidTicket);
        String errorMsg = parkingBoy.getErrorMsg();
        // Then

        Assertions.assertEquals("Unrecognized parking ticket.",errorMsg);
    }
    // 5mins / 3mins
    @Test
    void should_get_error_msg_when_dose_provide_a_ticket() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = null;
        //When
        parkingBoy.checkTicket(ticket);
        String errorMsg = parkingBoy.getErrorMsg();
        // Then

        Assertions.assertEquals("Please provide your parking ticket.",errorMsg);
    }
    // 5mins / 3mins
    @Test
    void should_get_error_msg_when_parking_lot_is_fulled() {
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(10);
        //When
        parkingLot.setParkedCarCount(10);
        parkingLot.isCapacityFulled();
        parkingBoy.checkParkingLotStatus(parkingLot);
        String errorMsg = parkingBoy.getErrorMsg();
        // Then

        Assertions.assertEquals("Not enough position.",errorMsg);
    }
    // 15mins / 10mins
    @Test
    void should_get_parking_lot_count_when_have_two_parking_lot_and_not_smarted_parkinng_boy() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        ArrayList<Car> carList = new ArrayList<>(Arrays.asList(new Car(), new Car(),new Car()));
        ParkingLot parkingLot1 = new ParkingLot(2,0);
        ParkingLot parkingLot2 = new ParkingLot(3,0);
        parkingBoy.setParkingLotList(new ArrayList<>(Arrays.asList(parkingLot1, parkingLot2)));
        //When
        parkingBoy.parkMultiplyCars(carList);
        int actuallyParkingLotStatus[] =  parkingBoy.getParkingLotCount();
        int exceptedParkingLotStatus[] = {2,1};
        // Then
        Assertions.assertArrayEquals(exceptedParkingLotStatus,actuallyParkingLotStatus);
    }
    // 20mins / 20mins
    @Test
    void should_get_parking_lot_status_when_have_two_parking_lot_and_smarted_parkinng_boy() {
        //Given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        ArrayList<Car> carList = new ArrayList<>(Arrays.asList(new Car(), new Car(),new Car()));
        ParkingLot parkingLot1 = new ParkingLot(2,0);
        ParkingLot parkingLot2 = new ParkingLot(3,0);
        smartParkingBoy.setParkingLotList(new ArrayList<>(Arrays.asList(parkingLot1, parkingLot2)));
        //When
        smartParkingBoy.parkMultiplyCars(carList);
        int actuallyParkingLotStatus[] =  smartParkingBoy.getParkingLotCount();
        int exceptedParkingLotStatus[] = {1,2};
        // Then
        Assertions.assertArrayEquals(exceptedParkingLotStatus,actuallyParkingLotStatus);
    }
     // 10mins / 10mins
    @Test
    void should_get_parking_lot_status_when_have_two_parking_lot_and_super_smarted_parkinng_boy() {
        //Given
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();
        ArrayList<Car> carList = new ArrayList<>(Arrays.asList(new Car(), new Car(),new Car()));
        ParkingLot parkingLot1 = new ParkingLot(2,0);
        ParkingLot parkingLot2 = new ParkingLot(3,0);
        superSmartParkingBoy.setParkingLotList(new ArrayList<>(Arrays.asList(parkingLot1, parkingLot2)));
        //When
        superSmartParkingBoy.parkMultiplyCars(carList);
        int actuallyParkingLotStatus[] =  superSmartParkingBoy.getParkingLotCount();
        int exceptedParkingLotStatus[] = {1,2};
        // Then
        Assertions.assertArrayEquals(exceptedParkingLotStatus,actuallyParkingLotStatus);
    }
    // 10mins / 10mins
    @Test
    void should_add_parking_boys_to_management_list_manage_parking_boys() {
        //Given
        ServiceManager serviceManager = new ServiceManager();
        serviceManager.setManageList(new ArrayList<>(Arrays.asList(new ParkingBoy(), new ParkingBoy(),new ParkingBoy())));
        //When


        // Then
        Assertions.assertNotNull(serviceManager.manageParkingBoy());
    }
    // 5mins / 5mins
    @Test
    void should_park_a_car_when_service_manager_specify_a_parking_boy_to_park_a_car_which_is_on_manage_list_and_parking_lot_is_managed() {
        //Given
        Car car = new Car();
        ParkingBoy parkingBoy1 = new ParkingBoy();
        ParkingBoy parkingBoy2 = new ParkingBoy();
        ParkingLot parkingLot1 = new ParkingLot(2,0);
        ParkingLot parkingLot2 = new ParkingLot(3,0);
        parkingBoy1.setParkingLotList(new ArrayList<>(Arrays.asList(parkingLot1, parkingLot2)));
        ServiceManager serviceManager = new ServiceManager();
        serviceManager.setManageList(new ArrayList<>(Arrays.asList(parkingBoy1,parkingBoy2)));



        //When&Then
        Assertions.assertNotNull(serviceManager.specifyAParkingBoyToParkACar(car,parkingBoy1,parkingLot1));
    }
    // 5mins / 5mins
    @Test
    void should_park_a_car_when_service_manager_specify_a_parking_boy_to_park_a_car_which_is_not_on_manage_list_and_parking_lot_is_managed() {
        //Given
        Car car = new Car();
        ParkingBoy parkingBoy1 = new ParkingBoy();
        ParkingBoy parkingBoy2 = new ParkingBoy();
        ParkingBoy parkingBoy3 = new ParkingBoy();
        ParkingLot parkingLot1 = new ParkingLot(2,0);
        ParkingLot parkingLot2 = new ParkingLot(3,0);
        parkingBoy1.setParkingLotList(new ArrayList<>(Arrays.asList(parkingLot1, parkingLot2)));
        ServiceManager serviceManager = new ServiceManager();
        serviceManager.setManageList(new ArrayList<>(Arrays.asList(parkingBoy1,parkingBoy2)));


        //When&Then
        Assertions.assertEquals(null,serviceManager.specifyAParkingBoyToParkACar(car,parkingBoy3,parkingLot1));
    }
    // 5mins / 5mins
    @Test
    void should_park_a_car_when_service_manager_specify_a_parking_boy_to_park_a_car_which_is__on_manage_list_and_parking_lot_is_not_managed() {
        //Given
        Car car = new Car();
        ParkingBoy parkingBoy1 = new ParkingBoy();
        ParkingBoy parkingBoy2 = new ParkingBoy();
        ParkingLot parkingLot1 = new ParkingLot(2,0);
        ParkingLot parkingLot2 = new ParkingLot(3,0);
        parkingBoy1.setParkingLotList(new ArrayList<>(Arrays.asList(parkingLot1)));
        ServiceManager serviceManager = new ServiceManager();
        serviceManager.setManageList(new ArrayList<>(Arrays.asList(parkingBoy1,parkingBoy2)));



        //When&Then
        Assertions.assertEquals(null,serviceManager.specifyAParkingBoyToParkACar(car,parkingBoy1,parkingLot2));
    }
    // 5mins / 5mins
    @Test
    void should_park_a_car_when_service_manager_to_park_a_car_which_is_managed() {
        //Given
        Car car = new Car();
        ParkingLot parkingLot1 = new ParkingLot(2,0);
        ParkingLot parkingLot2 = new ParkingLot(3,0);
        ServiceManager serviceManager = new ServiceManager();
        serviceManager.setParkingLotList(new ArrayList<>(Arrays.asList(parkingLot1)));

        //When&Then
        Assertions.assertNotNull(serviceManager.parkACar(car,parkingLot1));
    }
    // 5mins / 5mins
    @Test
    void should_park_a_car_when_service_manager_to_park_a_car_which_is_not_managed() {
        //Given
        Car car = new Car();
        ParkingLot parkingLot1 = new ParkingLot(2,0);
        ParkingLot parkingLot2 = new ParkingLot(3,0);
        ServiceManager serviceManager = new ServiceManager();
        serviceManager.setParkingLotList(new ArrayList<>(Arrays.asList(parkingLot1)));

        //When&Then
        Assertions.assertEquals(null,serviceManager.parkACar(car,parkingLot2));
    }
    // 5mins / 5mins
    @Test
    void should_display_the_error_message_with_wrong_ticket_from_parking_boy() {
        //Given
        Car car = new Car();
        Ticket ticket = new Ticket(true,false);
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot1 = new ParkingLot(2,0);
        ServiceManager serviceManager = new ServiceManager();

        //When
        boolean isValidTicket = parkingBoy.checkTicket(ticket);
        parkingBoy.fetchACar(isValidTicket);
        parkingBoy.passErrorMsgToManager(parkingBoy.getErrorMsg(),serviceManager);
        // Then
        Assertions.assertEquals("Unrecognized parking ticket.",serviceManager.getErrorMsg());
    }
    // 5mins / 5mins
    @Test
    void should_display_the_error_message_without_ticket_from_parking_boy() {
        //Given
        Car car = new Car();
        Ticket ticket = null;
        ParkingBoy parkingBoy = new ParkingBoy();
        ServiceManager serviceManager = new ServiceManager();
        //When
        parkingBoy.checkTicket(ticket);
        parkingBoy.passErrorMsgToManager(parkingBoy.getErrorMsg(),serviceManager);
        // Then
        Assertions.assertEquals("Please provide your parking ticket.",serviceManager.getErrorMsg());
    }
    // 5mins / 5mins
    @Test
    void should_display_the_error_message_with_no_position_from_parking_boy() {
        //Given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(10);
        ServiceManager serviceManager = new ServiceManager();

        //When
        parkingLot.setParkedCarCount(10);
        parkingLot.isCapacityFulled();
        parkingBoy.checkParkingLotStatus(parkingLot);
        parkingBoy.passErrorMsgToManager(parkingBoy.getErrorMsg(),serviceManager);
        // Then
        Assertions.assertEquals("Not enough position.",serviceManager.getErrorMsg());
    }
}

