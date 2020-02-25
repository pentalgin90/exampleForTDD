package net.navacom.tdd.example.service;

import net.navacom.tdd.example.dao.CarRepository;
import net.navacom.tdd.example.dto.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getListCar() {
        return carRepository.findAll();
    }

    public List<Car> getCarByModelName(String modelName) {
        return carRepository.getCarsByModel(modelName);
    }

    public void save(Car car) {
        carRepository.save(car);
    }
}
