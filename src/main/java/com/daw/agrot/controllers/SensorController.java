package com.daw.agrot.controllers;


import com.daw.agrot.entities.Sensor;
import com.daw.agrot.services.SensorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sensors")
public class SensorController {

    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping
    public String getAllSensors(Model model) {
        //Obtener los sensores
        var sensors = sensorService.getAllSensors();
        //Pasárselos a la vista
        model.addAttribute("sensors", sensors);
        return "sensors";
    }

    @GetMapping("/temperatura")
    public String getAllSensorsTemperatura(Model model) {
        var sensors = sensorService.getAllSensorsTemperatura();
        model.addAttribute("sensors", sensors);
        return "sensors";
    }

    @GetMapping("/{id}")
    public String getSensorById(@PathVariable Long id, Model model) {
        var sensor = sensorService.getSensorById(id);
        model.addAttribute("sensor", sensor);
        return "sensor";
    }

    @GetMapping("/new")
    public String newSensor(Model model) {
        model.addAttribute("sensor", new Sensor());
        return "new-sensor";
    }

    @PostMapping()
    public String createSensor(Sensor sensor) {
        sensorService.createSensor(sensor);
        return "redirect:/sensors";
    }

    @GetMapping("/delete/{id}")
    public String deleteSensor(@PathVariable Long id) {
        sensorService.deleteSensorById(id);
        return "redirect:/sensors";
    }


}
