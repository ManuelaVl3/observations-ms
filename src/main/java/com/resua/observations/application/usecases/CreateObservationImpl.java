package com.resua.observations.application.usecases;

import com.resua.observations.domain.models.Location;
import com.resua.observations.domain.models.Register;
import com.resua.observations.domain.models.Species;
import com.resua.observations.infrastructure.adapters.in.request.ObservationRequestDTO;
import com.resua.observations.infrastructure.adapters.out.database.RegisterAdapter;
import com.resua.observations.infrastructure.ports.in.CreateObservation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateObservationImpl implements CreateObservation {

    private final RegisterAdapter registerAdapter;

    @Override
    public Register createObservation(ObservationRequestDTO observationDTO) {
        
        // Crear el objeto Species usando Builder
        Species species = Species.builder()
                .commonName(observationDTO.getCommonName())
                .scientificName(observationDTO.getScientificName())
                .build();
        
        // Crear el objeto Location usando Builder
        Location location = Location.builder()
                .longitude(observationDTO.getLongitude())
                .latitude(observationDTO.getLatitude())
                .location(observationDTO.getLocation())
                .build();
        
        // Crear el objeto Register usando Builder
        Register register = Register.builder()
                .userId(observationDTO.getUserId())
                .species(species)
                .location(location)
                .description(observationDTO.getDescription())
                .images(null) // Sin imágenes por ahora
                .build();
        
        return registerAdapter.createObservation(register);
    }
}

