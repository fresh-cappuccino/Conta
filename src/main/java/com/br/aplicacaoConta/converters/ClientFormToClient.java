package com.br.aplicacaoConta.converters;

import com.br.aplicacaoConta.commands.ClienteForm;
import com.br.aplicacaoConta.model.Cliente;
import com.br.aplicacaoConta.interfaces.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by jt on 1/10/17.
 */
@Component
public class ClientFormToClient implements Converter<ClienteForm, Cliente> {

    @Override
    public Cliente convert(ClienteForm clienteForm) {
        Cliente cliente = new Cliente();
        if (clienteForm.getId() != null  && !StringUtils.isEmpty(clienteForm.getId())) {
            cliente.setId(new Long(clienteForm.getId()));
        }
        cliente.setName(clienteForm.getName());
        cliente.setDataNascimento(clienteForm.getDataNascimento());

        return cliente;
    }
}