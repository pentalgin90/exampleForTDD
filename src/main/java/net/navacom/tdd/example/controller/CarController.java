package net.navacom.tdd.example.controller;

import net.navacom.tdd.example.dto.Car;
import net.navacom.tdd.example.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService){
        this.carService = carService;
    }
    @GetMapping
    public List<Car> getListCar(){
        return carService.getListCar();
    }
    @GetMapping("{modelName}")
    public List<Car> getCarByModelName(@PathVariable String modelName){
        return carService.getCarByModelName(modelName);
    }
}
