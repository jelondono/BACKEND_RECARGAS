package com.datacenter.recargas.infrastructure.adapter.web.controller;

import com.datacenter.recargas.application.port.in.operators.GetAllOperatorsUseCase;
import com.datacenter.recargas.application.port.in.operators.GetOperatorByIdUseCase;
import com.datacenter.recargas.infrastructure.adapter.web.dto.operator.OperatorResponseDTO;
import com.datacenter.recargas.infrastructure.adapter.web.mapper.OperatorMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/operators")
public class OperatorController {

    private final GetAllOperatorsUseCase getAllOperatorsUseCase;
    private final GetOperatorByIdUseCase getOperatorByIdUseCase;
    private final OperatorMapper operatorMapper;

    public OperatorController(GetAllOperatorsUseCase getAllOperatorsUseCase,
                              GetOperatorByIdUseCase getOperatorByIdUseCase,
                              OperatorMapper operatorMapper) {
        this.getAllOperatorsUseCase = getAllOperatorsUseCase;
        this.getOperatorByIdUseCase = getOperatorByIdUseCase;
        this.operatorMapper = operatorMapper;
    }

    @Operation(summary = "Listar todos los operadores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de operadores obtenida exitosamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping
    public ResponseEntity<List<OperatorResponseDTO>> getAllOperators() {
        List<OperatorResponseDTO> response = getAllOperatorsUseCase.execute().stream()
                .map(operatorMapper::toResponseDTO)
                .toList();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Obtener operador por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operador obtenido exitosamente"),
            @ApiResponse(responseCode = "404", description = "Operador no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<OperatorResponseDTO> getOperatorById(@PathVariable Long id) {
        Optional<OperatorResponseDTO> response = getOperatorByIdUseCase.execute(id)
                .map(operatorMapper::toResponseDTO);
        return response.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
