package com.felipefreitas.notify.service;

import com.felipefreitas.notify.dto.ClientEvent;
import com.felipefreitas.notify.dto.ClienteDTO;
import com.felipefreitas.notify.dto.ClienteRequest;
import com.felipefreitas.notify.entity.Cliente;
import com.felipefreitas.notify.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ApplicationEventPublisher eventPublisher;


    @Transactional
    public ClienteDTO criarCliente(ClienteRequest request){

        if(clienteRepository.existsByEmail(request.email())){
            throw new RuntimeException("Email já cadastrado");
        }
        Cliente cliente = Cliente.builder()
                .nome(request.nome())
                .email(request.email())
                .build();

        clienteRepository.save(cliente);

        eventPublisher.publishEvent(new ClientEvent(cliente.getEmail()));

        return new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getEmail());

    }

}
