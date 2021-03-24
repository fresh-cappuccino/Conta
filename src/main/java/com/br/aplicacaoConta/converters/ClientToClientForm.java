package com.br.aplicacaoConta.converters;

import com.br.aplicacaoConta.commands.ClienteForm;
import com.br.aplicacaoConta.model.Cliente;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 1/10/17.
 */
@Component
public class ClientToClientForm implements Converter<Cliente, ClienteForm> {
    @Override
    public ClienteForm convert(Cliente cliente) {
        ClienteForm clienteForm = new ClienteForm();
        clienteForm.setId(cliente.getId());
        clienteForm.setName(cliente.getName());
        clienteForm.setDataNascimentoNoParse(cliente.getDataNascimento());
        return clienteForm;
    }
}