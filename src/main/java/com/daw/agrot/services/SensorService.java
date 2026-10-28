package com.daw.agrot.services;

import com.daw.agrot.entities.Sensor;

import java.util.List;

public interface SensorService {

    List<Sensor> getAllSensors();
    Sensor getSensorById(Long id);
    List<Sensor> getAllSensorsTemperatura();
    void createSensor(Sensor sensor);
    void deleteSensorById(Long id);
}
