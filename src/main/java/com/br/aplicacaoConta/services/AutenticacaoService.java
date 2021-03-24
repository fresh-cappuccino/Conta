package com.br.aplicacaoConta.services;

import com.br.aplicacaoConta.model.Cliente;
import com.br.aplicacaoConta.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // user iwasawa@email.com
        // pass ciaware
        Optional<Cliente> usuario = clienteRepository.findByEmail(username);
        if (usuario.isPresent())
            return usuario.get();

        throw new UsernameNotFoundException("Dados inválidos!");
    }
}