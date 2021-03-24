//package com.br.aplicacaoConta.interfaces;
//
//import com.br.aplicacaoConta.model.Cliente;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
//
//@Entity
//@Table(name="CONTA")
//public class Conta {
//
//    @Id
//    @Column(name = "ID")
////    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
////    @SequenceGenerator(name = "id_Sequence", sequenceName = "SEQ_CONTA")
//    private Long id;
//
//    @NotBlank
//    @Column(name = "SALDO")
//    private String saldo;
//
//    @NotBlank
//    @Column(name = "NUMERO")
//    private Long numnero;
//
//    @NotBlank
//    @JoinTable(name = "CONTA_CLIENTE",
//            joinColumns = { @JoinColumn(name = "CLIENTE_ID") },
//            inverseJoinColumns = { @JoinColumn(name = "CONTA_ID") })
//    private Cliente cliente;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getSaldo() {
//        return saldo;
//    }
//
//    public void setSaldo(String saldo) {
//        this.saldo = saldo;
//    }
//
//    public Long getNumnero() {
//        return numnero;
//    }
//
//    public void setNumnero(Long numnero) {
//        this.numnero = numnero;
//    }
//
//    public Cliente getCliente() {
//        return cliente;
//    }
//
//    public void setCliente(Cliente cliente) {
//        this.cliente = cliente;
//    }
//}