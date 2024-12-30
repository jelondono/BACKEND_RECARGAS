package com.datacenter.recargas.infrastructure.adapter.web.controller;

import com.datacenter.recargas.application.port.in.statics.GetStatisticsByOperatorUseCase;
import com.datacenter.recargas.application.port.in.statics.GetStatisticsBySellerUseCase;
import com.datacenter.recargas.infrastructure.adapter.web.dto.operator.OperatorStatisticsDTO;
import com.datacenter.recargas.infrastructure.adapter.web.dto.seller.SellerStatisticsDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {

    private final GetStatisticsByOperatorUseCase getStatisticsByOperatorUseCase;
    private final GetStatisticsBySellerUseCase getStatisticsBySellerUseCase;

    public StatisticsController(GetStatisticsByOperatorUseCase getStatisticsByOperatorUseCase,
                                GetStatisticsBySellerUseCase getStatisticsBySellerUseCase) {
        this.getStatisticsByOperatorUseCase = getStatisticsByOperatorUseCase;
        this.getStatisticsBySellerUseCase = getStatisticsBySellerUseCase;
    }

    @Operation(
            summary = "Estadísticas por operador",
            description = "Este endpoint devuelve las estadísticas de recargas agrupadas por operador."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estadísticas por operador obtenidas exitosamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/by-operator")
    public ResponseEntity<List<OperatorStatisticsDTO>> getStatisticsByOperator() {
        List<OperatorStatisticsDTO> statistics = getStatisticsByOperatorUseCase.execute();
        return ResponseEntity.ok(statistics);
    }

    @Operation(
            summary = "Estadísticas por vendedor",
            description = "Este endpoint devuelve las estadísticas de recargas agrupadas por vendedor."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estadísticas por vendedor obtenidas exitosamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/by-seller")
    public ResponseEntity<List<SellerStatisticsDTO>> getStatisticsBySeller() {
        List<SellerStatisticsDTO> statistics = getStatisticsBySellerUseCase.execute();
        return ResponseEntity.ok(statistics);
    }
}
