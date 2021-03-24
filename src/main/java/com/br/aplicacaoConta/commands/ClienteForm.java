package com.br.aplicacaoConta.commands;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jt on 1/10/17.
 */

public class ClienteForm {

    private Long id;
    private String name;
    private Date dataNascimento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        try {
            this.dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
        } catch (ParseException pe) {
            throw new RuntimeException("-----\nCAUSE:\n-----\n"
                    + pe.getCause()
                    + "---------\nEXCEPTION:\n---------\n"
                    + pe.getMessage());
        }
    }

    public void setDataNascimentoNoParse(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}