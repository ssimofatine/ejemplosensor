package com.daw.agrot.repositories;


import com.daw.agrot.entities.Sensor;
import com.daw.agrot.entities.TipoSensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SensorRepository extends JpaRepository<Sensor, Long> {

    public List<Sensor> findAllByTipoEquals(TipoSensor tipoSensor);
    public List<Sensor> findAllByNameContainingIgnoreCase(String name);
    public List<Sensor> findAllByNameContainingIgnoreCaseAndTipoEquals(String name, TipoSensor tipo);

}
