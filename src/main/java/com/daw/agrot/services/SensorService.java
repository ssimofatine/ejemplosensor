package com.daw.agrot.services;

import com.daw.agrot.entities.Sensor;

import java.util.List;

public interface SensorService {

    List<Sensor> getAllSensors();
    List<Sensor> getAllSensorsByNameAndTipo(String name, String tipo);
    Sensor getSensorById(Long id);
    List<Sensor> getAllSensorsTemperatura();
    void saveSensor(Sensor sensor);
    void deleteSensorById(Long id);
}
