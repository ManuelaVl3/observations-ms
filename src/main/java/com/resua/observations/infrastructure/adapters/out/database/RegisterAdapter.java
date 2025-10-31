package com.resua.observations.infrastructure.adapters.out.database;

import com.resua.observations.domain.models.Register;
import com.resua.observations.infrastructure.adapters.out.database.entities.RegisterEntity;
import com.resua.observations.infrastructure.adapters.out.database.mappers.RegisterMapper;
import com.resua.observations.infrastructure.ports.out.database.RegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RegisterAdapter {
    private final RegisterRepository registerRepository;

    private final RegisterMapper registerMapper;

    public List<Register> getObservationsByUser(Long userId) {

        List<RegisterEntity> registerEntities = registerRepository.findAllByUserId(userId);

        List<Register> registers = registerMapper.toModel(registerEntities);

        return registers;
    }

    public Optional<Register> getObservationById(Long id) {

        Optional<RegisterEntity> registerEntity = registerRepository.findByIdWithRelations(id);

        return registerEntity.map(registerMapper::toModel);
    }

    public boolean deleteObservationById(Long id) {

        if (registerRepository.existsById(id)) {
            registerRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public Register createObservation(Register register) {
        
        // Establecer timestamps
        LocalDateTime now = LocalDateTime.now();
        register.setCreatedAt(now);
        register.setUpdatedAt(now);
        
        // Establecer timestamps en species
        if (register.getSpecies() != null) {
            register.getSpecies().setCreatedAt(now);
            register.getSpecies().setUpdatedAt(now);
        }
        
        // Establecer timestamps en location
        if (register.getLocation() != null) {
            register.getLocation().setCreatedAt(now);
            register.getLocation().setUpdatedAt(now);
        }
        
        // Convertir a entidad
        RegisterEntity entity = registerMapper.toEntity(register);
        
        // Guardar en la base de datos
        RegisterEntity savedEntity = registerRepository.save(entity);
        
        // Convertir de vuelta a modelo
        return registerMapper.toModel(savedEntity);
    }
}
