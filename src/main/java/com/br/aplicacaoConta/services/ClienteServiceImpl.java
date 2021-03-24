package com.br.aplicacaoConta.services;

import com.br.aplicacaoConta.commands.ClienteForm;
import com.br.aplicacaoConta.model.Cliente;
import com.br.aplicacaoConta.converters.ClientFormToClient;
import com.br.aplicacaoConta.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;
    private ClientFormToClient clientFormToClient;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository, ClientFormToClient clientFormToClient) {
        this.clienteRepository = clienteRepository;
        this.clientFormToClient = clientFormToClient;
    }

    @Override
    public List<Cliente> listAll() {
        List<Cliente> user = new ArrayList<>();
        clienteRepository.findAll().forEach(user::add);
        return user;
    }

    @Override
    public Cliente getById(Long id) {
        return (Cliente) (clienteRepository.findById(id).get());
    }

    @Override
    public com.br.aplicacaoConta.model.Cliente saveOrUpdate(Cliente user) {
        clienteRepository.save(user);
        return user;
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Cliente saveOrUpdateUserForm(ClienteForm clienteForm) {
        Cliente savedUser = saveOrUpdate(clientFormToClient.convert(clienteForm));
        return savedUser;
    }
}