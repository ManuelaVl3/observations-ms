package com.resua.observations.infrastructure.adapters.out.database;

import com.resua.observations.domain.models.Register;
import com.resua.observations.infrastructure.adapters.out.database.entities.RegisterEntity;
import com.resua.observations.infrastructure.adapters.out.database.mappers.RegisterMapper;
import com.resua.observations.infrastructure.ports.out.database.RegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

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
}
