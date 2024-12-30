package com.datacenter.recargas.infrastructure.adapter.web.controller;

import com.datacenter.recargas.application.port.in.sellers.GetAllSellersUseCase;
import com.datacenter.recargas.application.port.in.sellers.GetSellerByIdUseCase;
import com.datacenter.recargas.infrastructure.adapter.web.dto.seller.SellerResponseDTO;
import com.datacenter.recargas.infrastructure.adapter.web.mapper.SellerMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sellers")
public class SellerController {

    private final GetAllSellersUseCase getAllSellersUseCase;
    private final GetSellerByIdUseCase getSellerByIdUseCase;
    private final SellerMapper sellerMapper;

    public SellerController(GetAllSellersUseCase getAllSellersUseCase, GetSellerByIdUseCase getSellerByIdUseCase, SellerMapper sellerMapper) {
        this.getAllSellersUseCase = getAllSellersUseCase;
        this.getSellerByIdUseCase = getSellerByIdUseCase;
        this.sellerMapper = sellerMapper;
    }

    @Operation(
            summary = "Listar todos los vendedores",
            description = "Este endpoint permite recuperar la lista de todos los vendedores registrados en el sistema."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de vendedores obtenida exitosamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping
    public ResponseEntity<List<SellerResponseDTO>> getAllSellers() {
        List<SellerResponseDTO> response = getAllSellersUseCase.execute().stream()
                .map(sellerMapper::toResponseDTO)
                .toList();
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Obtener un vendedor por ID",
            description = "Este endpoint permite recuperar la información de un vendedor específico por su ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vendedor encontrado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Vendedor no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<SellerResponseDTO> getSellerById(@PathVariable Long id) {
        Optional<SellerResponseDTO> response = getSellerByIdUseCase.execute(id)
                .map(sellerMapper::toResponseDTO);
        return response.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
