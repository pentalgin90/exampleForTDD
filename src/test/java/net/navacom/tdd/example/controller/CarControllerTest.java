package net.navacom.tdd.example.controller;

import net.navacom.tdd.example.dto.Car;
import net.navacom.tdd.example.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class CarControllerTest {
    private Car car;
    @Autowired
    MockMvc mockMvc;
    @MockBean
    CarService carService;

    @BeforeEach
    void setUp(){
        car = new Car(1l, "oka", "kamaz");
    }

    @Test
    void findAllCarAndGetListCar() throws Exception {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(1l, "oka", "kamaz"));
        carList.add(new Car(2l, "niva", "laba"));
        when(carService.getListCar()).thenReturn(carList);
        mockMvc.perform(get("/car")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andDo(print());
    }
    @Test
    void findCarByModelName() throws Exception {
        List<Car> carList = new ArrayList<>();
        carList.add(car);
        when(carService.getCarByModelName("oka")).thenReturn(carList);
        mockMvc.perform(get("/car/{modelName}", "oka")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
