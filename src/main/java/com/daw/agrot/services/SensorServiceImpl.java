package com.daw.agrot.services;

import com.daw.agrot.entities.Sensor;
import com.daw.agrot.entities.TipoSensor;
import com.daw.agrot.repositories.SensorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {

    private static final Logger logger = LoggerFactory.getLogger(SensorServiceImpl.class);

    public final SensorRepository sensorRepository;

    public SensorServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }


    @Override
    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }

    @Override
    public List<Sensor> getAllSensorsByNameAndTipo(String name, String tipo) {
        if (tipo.equals("TODOS")) {
            return sensorRepository.findAllByNameContainingIgnoreCase(name);
        } else {
            return sensorRepository.findAllByNameContainingIgnoreCaseAndTipoEquals(name, TipoSensor.valueOf(tipo));
        }
    }

    @Override
    public Sensor getSensorById(Long id) {
        return sensorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Sensor> getAllSensorsTemperatura() {
        logger.debug("Obteniendo todos los sensores de temperatura");
        return sensorRepository.findAllByTipoEquals(TipoSensor.TEMPERATURA);
    }

    @Override
    public void saveSensor(Sensor sensor) {
        sensorRepository.save(sensor);
    }

    @Override
    public void deleteSensorById(Long id) {
        sensorRepository.deleteById(id);
    }
}
