package com.resua.observations.infrastructure.adapters.in.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Datos para crear una nueva observación de especie silvestre")
public class ObservationRequestDTO {
    
    @Schema(description = "ID del usuario que realiza la observación", example = "1", required = true)
    private Long userId;
    
    @Schema(description = "Nombre común de la especie", example = "Rana de Cristal", required = true)
    private String commonName;
    
    @Schema(description = "Nombre científico de la especie", example = "Espadarana prosoblepon", required = true)
    private String scientificName;
    
    @Schema(description = "Longitud de la ubicación", example = "-74.072092", required = true)
    private Double longitude;
    
    @Schema(description = "Latitud de la ubicación", example = "4.710989", required = true)
    private Double latitude;
    
    @Schema(description = "Dirección o descripción de la ubicación", example = "El Modelo, Medellín", required = true)
    private String location;
    
    @Schema(description = "Descripción de la observación", example = "Observada cerca del río, clima húmedo")
    private String description;
}
