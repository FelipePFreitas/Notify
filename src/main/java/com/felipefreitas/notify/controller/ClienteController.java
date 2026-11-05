package com.felipefreitas.notify.controller;

import com.felipefreitas.notify.dto.ClienteDTO;
import com.felipefreitas.notify.dto.ClienteRequest;
import com.felipefreitas.notify.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteDTO>  criarCliente(@Valid @RequestBody ClienteRequest request){
        ClienteDTO clienteDTO = service.criarCliente(request);
        return ResponseEntity.ok(clienteDTO);
    }
}
