package com.br.aplicacaoConta.services;


import com.br.aplicacaoConta.commands.ClienteForm;

import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
public interface ClienteService {

    List<com.br.aplicacaoConta.model.Cliente> listAll();

    com.br.aplicacaoConta.model.Cliente getById(Long id);

    com.br.aplicacaoConta.model.Cliente saveOrUpdate(com.br.aplicacaoConta.model.Cliente user);

    void delete(Long id);

    com.br.aplicacaoConta.model.Cliente saveOrUpdateUserForm(ClienteForm clienteForm);
}