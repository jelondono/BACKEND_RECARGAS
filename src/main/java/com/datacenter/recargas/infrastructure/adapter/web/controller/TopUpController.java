package com.datacenter.recargas.infrastructure.adapter.web.controller;

import com.datacenter.recargas.application.port.in.topup.CreateTopUpUseCase;
import com.datacenter.recargas.application.port.in.topup.GetTopUpsBySellerUseCase;
import com.datacenter.recargas.application.port.in.topup.GetTopUpsByOperatorUseCase;
import com.datacenter.recargas.infrastructure.adapter.web.dto.topup.TopUpRequestDTO;
import com.datacenter.recargas.infrastructure.adapter.web.dto.topup.TopUpResponseDTO;
import com.datacenter.recargas.infrastructure.adapter.web.mapper.TopUpMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topups")
public class TopUpController {

    private final CreateTopUpUseCase createTopUpUseCase;
    private final GetTopUpsBySellerUseCase getTopUpsBySellerUseCase;
    private final GetTopUpsByOperatorUseCase getTopUpsByOperatorUseCase;
    private final TopUpMapper topUpMapper;

    public TopUpController(CreateTopUpUseCase createTopUpUseCase,
                           GetTopUpsBySellerUseCase getTopUpsBySellerUseCase,
                           GetTopUpsByOperatorUseCase getTopUpsByOperatorUseCase,
                           TopUpMapper topUpMapper) {
        this.createTopUpUseCase = createTopUpUseCase;
        this.getTopUpsBySellerUseCase = getTopUpsBySellerUseCase;
        this.getTopUpsByOperatorUseCase = getTopUpsByOperatorUseCase;
        this.topUpMapper = topUpMapper;
    }

    @Operation(summary = "Crear una nueva recarga", description = "Permite crear una nueva recarga en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recarga creada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping
    public ResponseEntity<TopUpResponseDTO> createTopUp(@RequestBody TopUpRequestDTO requestDTO) {
        if (requestDTO.getOperatorId() == null || requestDTO.getSellerId() == null) {
            throw new IllegalArgumentException("El ID del operador y el vendedor no pueden ser nulos.");
        }

        var domain = topUpMapper.toDomain(requestDTO);
        var response = topUpMapper.toResponseDTO(createTopUpUseCase.execute(domain));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Obtener recargas por vendedor", description = "Devuelve una lista de recargas realizadas por un vendedor específico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recargas obtenidas exitosamente"),
            @ApiResponse(responseCode = "404", description = "No se encontraron recargas para el vendedor"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/by-seller/{sellerId}")
    public ResponseEntity<List<TopUpResponseDTO>> getTopUpsBySeller(@PathVariable Long sellerId) {
        return ResponseEntity.ok(getTopUpsBySellerUseCase.execute(sellerId));
    }

    @Operation(summary = "Obtener recargas por operador", description = "Devuelve una lista de recargas realizadas por un operador específico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recargas obtenidas exitosamente"),
            @ApiResponse(responseCode = "404", description = "No se encontraron recargas para el operador"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/by-operator/{operatorId}")
    public ResponseEntity<List<TopUpResponseDTO>> getTopUpsByOperator(@PathVariable Long operatorId) {
        return ResponseEntity.ok(getTopUpsByOperatorUseCase.execute(operatorId));
    }

    @Operation(summary = "Obtener recargas según tipo", description = "Devuelve una lista de recargas según el tipo (vendedor u operador).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recargas obtenidas exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping
    public ResponseEntity<List<TopUpResponseDTO>> getTopUpsByType(
            @RequestParam(required = false) Long sellerId,
            @RequestParam(required = false) Long operatorId) {

        if (sellerId != null) {
            return ResponseEntity.ok(getTopUpsBySellerUseCase.execute(sellerId));
        } else if (operatorId != null) {
            return ResponseEntity.ok(getTopUpsByOperatorUseCase.execute(operatorId));
        } else {
            throw new IllegalArgumentException("Debe especificar un sellerId o un operatorId.");
        }
    }
}
