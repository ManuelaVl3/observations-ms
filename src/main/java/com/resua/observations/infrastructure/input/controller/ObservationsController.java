package com.resua.observations.infrastructure.input.controller;

import com.resua.observations.infrastructure.input.request.ObservationRequestDTO;
import com.resua.observations.infrastructure.input.response.GenericResponseDTO;
import com.resua.observations.infrastructure.input.response.ObservationResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("observations")
@Tag(name = "Observations", description = "API para gestionar observaciones de especies silvestres")
public class ObservationsController {

    @PostMapping
    @Operation(
        summary = "Crear nueva observación",
        description = "Registra una nueva observación de especie silvestre en zona urbana"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Observación creada exitosamente",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = GenericResponseDTO.class)
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Datos de entrada inválidos"
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Error interno del servidor"
        )
    })
    public ResponseEntity<GenericResponseDTO> add(@RequestBody ObservationRequestDTO observationR) {
        GenericResponseDTO response = new GenericResponseDTO("El registro se ha agregado correctamente");

        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Editar una observación",
            description = "Edita una observación de especie silvestre en zona urbana"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Observación editada exitosamente",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Datos de entrada inválidos"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error interno del servidor"
            )
    })
    @PatchMapping("/{id}")
    public ResponseEntity<GenericResponseDTO> update(@RequestBody ObservationRequestDTO observationR, @PathVariable Long id) {
        GenericResponseDTO response = new GenericResponseDTO("El registro con id: " + id + " se ha editado correctamente");

        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Eliminar una observación",
            description = "Elimina una observación de especie silvestre en zona urbana"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Observación eliminada exitosamente",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Datos de entrada inválidos"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error interno del servidor"
            )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponseDTO> delete(@PathVariable Long id) {
        GenericResponseDTO response = new GenericResponseDTO("El registro con id: " + id + " se ha eliminado correctamente");

        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Obtener observaciones de un usuario",
            description = "Obtiene las observaciones de un usuario"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Observaciones obtenidas exitosamente",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Datos de entrada inválidos"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error interno del servidor"
            )
    })
    @GetMapping("/user")
    public ResponseEntity<List<ObservationResponseDTO>> getAllByUserId(@RequestParam("id") Long userId) {
        List<ObservationResponseDTO> response = List.of(
                new ObservationResponseDTO("Rana de Cristal", "Espadarana prosoblepon", "el modelo"),
                new ObservationResponseDTO("Rana de Pijao", "Nymphargus pijao", "Genesis")
        );

        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Obtener un registro de avistamiento",
            description = "Obtiene un registro de avistamiento"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Observación obtenida exitosamente",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Datos de entrada inválidos"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error interno del servidor"
            )
    })
    @GetMapping
    public ResponseEntity<ObservationResponseDTO> getObservation(@RequestParam("id") Long id) {
        ObservationResponseDTO response =  new ObservationResponseDTO("Rana de Cristal", "Espadarana prosoblepon", "el modelo");

        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Obtener un registro de avistamiento por palabra clave, categoría, ubicación",
            description = "Obtiene un registro de avistamiento por palabra clave, categoría, ubicación"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Observación obtenida exitosamente",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Datos de entrada inválidos"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error interno del servidor"
            )
    })
    @GetMapping("/search")
    public ResponseEntity<List<ObservationResponseDTO>> searchObservation(@RequestParam("keyword") String keyword,
                                                                          @RequestParam("category") String category,
                                                                          @RequestParam("location") String location) {
        List<ObservationResponseDTO> response = List.of(
                new ObservationResponseDTO("Rana de Cristal", "Espadarana prosoblepon", "Genesis"),
                new ObservationResponseDTO("Rana de Pijao", "Nymphargus pijao", "Genesis")
        );

        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Obtener una lista de sugerencias de búsqueda",
            description = "Obtiene una lista de sugerencias de búsqueda"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Sguerencias obtenidas exitosamente",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Datos de entrada inválidos"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error interno del servidor"
            )
    })
    @GetMapping("/suggestions")
    public ResponseEntity<List<String>> suggestionObservation(@RequestParam("sentence") String sentence) {
        List<String> response = List.of(
                new String("Aotus lemurinus"),
                new String("Aotus griseimembra"),
                new String("Aotus brumbacki")
        );

        return ResponseEntity.ok(response);
    }
}
