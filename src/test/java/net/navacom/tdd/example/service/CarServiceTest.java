package net.navacom.tdd.example.service;

import net.navacom.tdd.example.dao.CarRepository;
import net.navacom.tdd.example.dto.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class CarServiceTest {
    private CarService carService;
    private Car car;

    @Autowired
    private CarRepository carRepository;

    @BeforeEach
    void setUp(){
        car = new Car(1l, "oka", "kamaz");
        carService = new CarService(carRepository);
        carRepository.deleteAll();
    }

    @Test
    void findAllCarAndGetListCar(){
        carService.save(car);
        List<Car> carList = carService.getListCar();
        Car lastCar = carList.get(carList.size() - 1);
        assertEquals(lastCar.getModel(), car.getModel());
    }

    @Test
    void findCarByModelName(){
        carService.save(car);
        List<Car> cars = carService.getCarByModelName(car.getModel());
        Car lastCar = cars.get(cars.size() - 1);
        assertEquals(lastCar.getModel(), car.getModel());
    }
}
