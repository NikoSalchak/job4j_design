package ru.job4j.ood.srp.lsp.parking.main;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.lsp.parking.CarParking;
import ru.job4j.ood.srp.lsp.parking.Parking;
import ru.job4j.ood.srp.lsp.parking.TruckParking;
import ru.job4j.ood.srp.lsp.parking.vehicles.Car;
import ru.job4j.ood.srp.lsp.parking.vehicles.CarType;
import ru.job4j.ood.srp.lsp.parking.vehicles.Truck;
import ru.job4j.ood.srp.lsp.parking.vehicles.Vehicle;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class VehicleParkingTest {

    @Test
    void whenAddThreeCarsThenGetThemAll() {
        List<Parking> spots = Arrays.asList(
                new CarParking(3),
                new TruckParking(3)
        );
        Vehicle vaz = new Car("vaz", 1);
        Vehicle lada = new Car("lada", 2);
        Vehicle toyota = new Car("toyota", 3);
        VehicleParking parking = new VehicleParking(spots);
        parking.putTheCar(vaz);
        parking.putTheCar(lada);
        parking.putTheCar(toyota);
        assertThat(spots.get(0).findAll()).contains(vaz, lada, toyota);
    }

    @Test
    void whenAddThreeCarsThenGetFirstCar() {
        List<Parking> spots = Arrays.asList(
                new CarParking(3),
                new TruckParking(3)
        );
        Vehicle vaz = new Car("vaz", 1);
        Vehicle lada = new Car("lada", 2);
        Vehicle toyota = new Car("toyota", 3);
        VehicleParking parking = new VehicleParking(spots);
        parking.putTheCar(vaz);
        parking.putTheCar(lada);
        parking.putTheCar(toyota);
        assertThat(parking.findByParkingId(1)).isEqualTo(vaz);
    }

    @Test
    void whenAddCarThenReplaceIt() {
        List<Parking> spots = Arrays.asList(
                new CarParking(3)
        );
        Vehicle vaz = new Car("vaz", 1);
        Vehicle toyota = new Car("toyota", 3);
        VehicleParking parking = new VehicleParking(spots);
        parking.putTheCar(vaz);
        spots.get(0).replace(1, toyota);
        assertThat(parking.findByParkingId(3)).isEqualTo(toyota);
    }

    @Test
    void whenAddTrucksInCarParkingThenSuccessfully() {
        List<Parking> spots = Arrays.asList(
                new CarParking(6)
        );
        Vehicle craz = new Truck("craz", 1);
        Vehicle kamaz = new Truck("kamaz", 2);
        Vehicle ural = new Truck("ural", 3);
        VehicleParking parking = new VehicleParking(spots);
        parking.putTheCar(craz);
        parking.putTheCar(kamaz);
        parking.putTheCar(ural);
        assertThat(spots.get(0).findByName("craz")).contains(craz);
        assertThat(spots.get(0).findAll()).contains(craz, kamaz, ural);
    }

    @Test
    void whenAddTrucksInTruckParkingThenSuccessfully() {
        List<Parking> spots = Arrays.asList(
                new TruckParking(3),
                new CarParking(6)
        );
        Vehicle craz = new Truck("craz", 1);
        Vehicle kamaz = new Truck("kamaz", 2);
        Vehicle ural = new Truck("ural", 3);
        VehicleParking parking = new VehicleParking(spots);
        parking.putTheCar(craz);
        parking.putTheCar(kamaz);
        parking.putTheCar(ural);
        assertThat(spots.get(0).findByCarType(CarType.TRUCK)).contains(craz, kamaz, ural);
        assertThat(spots.get(0).findAll()).contains(craz, kamaz, ural);
    }

    @Test
    void whenAddCarsInTruckParkingThenNull() {
        List<Parking> spots = Arrays.asList(
                new TruckParking(3)
        );
        Vehicle vaz = new Car("vaz", 1);
        Vehicle lada = new Car("lada", 2);
        Vehicle toyota = new Car("toyota", 3);
        VehicleParking parking = new VehicleParking(spots);
        parking.putTheCar(vaz);
        parking.putTheCar(lada);
        parking.putTheCar(toyota);
        assertThat(spots.get(0).findAll()).isEmpty();
    }

    @Test
    void whenAddCarsAndTruckThenGetOnlyCars() {
        List<Parking> spots = Arrays.asList(
                new CarParking(6)
        );
        Vehicle vaz = new Car("vaz", 1);
        Vehicle lada = new Car("lada", 2);
        Vehicle kamaz = new Truck("kamaz", 3);
        Vehicle ural = new Truck("ural", 4);
        VehicleParking parking = new VehicleParking(spots);
        parking.putTheCar(vaz);
        parking.putTheCar(lada);
        parking.putTheCar(kamaz);
        parking.putTheCar(ural);
        assertThat(spots.get(0).findByCarType(CarType.CAR)).contains(vaz, lada);
    }

    @Test
    void whenAddCarsAndTruckThenTheyAreNotDuplicatedInParkingLots() {
        List<Parking> spots = Arrays.asList(
                new CarParking(6),
                new TruckParking(3)
        );
        Vehicle vaz = new Car("vaz", 1);
        Vehicle lada = new Car("lada", 2);
        Vehicle toyota = new Car("toyota", 3);
        Vehicle toyota2 = new Car("toyota2", 4);
        Vehicle kamaz = new Truck("kamaz", 5);
        Vehicle cruz = new Truck("cruz", 6);
        Vehicle ural = new Truck("ural", 7);
        Vehicle gaz = new Truck("gaz", 8);
        Vehicle mersedes = new Car("mersedes", 9);
        VehicleParking parking = new VehicleParking(spots);
        parking.putTheCar(vaz);
        parking.putTheCar(lada);
        parking.putTheCar(toyota);
        parking.putTheCar(toyota2);
        parking.putTheCar(kamaz);
        parking.putTheCar(cruz);
        parking.putTheCar(ural);
        parking.putTheCar(gaz);
        parking.putTheCar(mersedes);
        assertThat(spots.get(0).findAll()).contains(vaz, lada, toyota, toyota2, gaz);
        assertThat(spots.get(1).findAll()).contains(kamaz, cruz, ural);
    }
}