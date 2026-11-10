package com.daw.agrot.controllers;


import com.daw.agrot.entities.Sensor;
import com.daw.agrot.entities.TipoSensor;
import com.daw.agrot.services.SensorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sensors")
public class SensorController {

    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping
    public String getAllSensors(@RequestParam (required = false) String q,
                                @RequestParam(required = false) String tipo, Model model) {
        //Obtener los sensores
        if (q == null) q = "";
        if (tipo == null) tipo = "TODOS";

        var sensors = sensorService.getAllSensorsByNameAndTipo(q, tipo);
        //Pasárselos a la vista
        model.addAttribute("sensors", sensors);
        var tipos = TipoSensor.values();
        model.addAttribute("tipos", tipos);
        model.addAttribute("q", q);
        model.addAttribute("tipo", tipo);
        return "sensores/lista";
    }

    @GetMapping("/temperatura")
    public String getAllSensorsTemperatura(Model model) {
        var sensors = sensorService.getAllSensorsTemperatura();
        model.addAttribute("sensors", sensors);
        model.addAttribute("titulo", "Sensores de Temperatura");
        return "sensores/lista";
    }

    @GetMapping("/{id}")
    public String getSensorById(@PathVariable Long id, Model model) {
        var sensor = sensorService.getSensorById(id);
        model.addAttribute("sensor", sensor);
        return "sensores/detalle";
    }

    @GetMapping("/new")
    public String newSensor(Model model) {
        var tipos = TipoSensor.values();
        model.addAttribute("tipos", tipos);
        model.addAttribute("sensor", new Sensor());
        return "sensores/formulario";
    }

    @GetMapping("/update/{id}")
    public String updateSensor(@PathVariable Long id, Model model) {
        var sensor = sensorService.getSensorById(id);
        var tipos = TipoSensor.values();
        model.addAttribute("tipos", tipos);
        model.addAttribute("sensor", sensor);
        return "sensores/formulario";
    }

    @PostMapping()
    public String saveSensor(Sensor sensor) {
        sensorService.saveSensor(sensor);
        return "redirect:/sensors";
    }

    @GetMapping("/delete/{id}")
    public String deleteSensor(@PathVariable Long id) {
        sensorService.deleteSensorById(id);
        return "redirect:/sensors";
    }


}
