package com.br.aplicacaoConta.repositories;

import com.br.aplicacaoConta.interfaces.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Conta, Long> { }