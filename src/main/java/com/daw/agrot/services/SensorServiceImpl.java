package com.daw.agrot.services;

import com.daw.agrot.entities.Sensor;
import com.daw.agrot.entities.TipoSensor;
import com.daw.agrot.repositories.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {

    public final SensorRepository sensorRepository;

    public SensorServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }


    @Override
    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }

    @Override
    public Sensor getSensorById(Long id) {
        return sensorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Sensor> getAllSensorsTemperatura() {
        return sensorRepository.findAllByTipoEquals(TipoSensor.TEMPERATURA);
    }

    @Override
    public void createSensor(Sensor sensor) {
        sensorRepository.save(sensor);
    }

    @Override
    public void deleteSensorById(Long id) {
        sensorRepository.deleteById(id);
    }
}
