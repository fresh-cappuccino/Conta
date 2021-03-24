package com.br.aplicacaoConta.controllers;

import com.br.aplicacaoConta.commands.ClienteForm;
import com.br.aplicacaoConta.converters.ClientToClientForm;
import com.br.aplicacaoConta.model.Cliente;

import com.br.aplicacaoConta.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by jt on 1/10/17.
 */

@Controller
public class ClienteController {
    private ClienteService clienteService;

    private ClientToClientForm clientToClientForm;

    @Autowired
    public void setClienteToClienteForm(ClientToClientForm clientToClientForm) {
        this.clientToClientForm = clientToClientForm;
    }

    @Autowired
    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @RequestMapping("/ws/countries.wsdl")
    public String redirToList(){
        return "redirect:/user/userList";
    }

    @RequestMapping({"/user/userList", "/user"})
    public String listClientes(Model model) {
        model.addAttribute("users", clienteService.listAll());
        return "user/userList";
    }

    @RequestMapping("/user/userShow/{id}")
    public String getCliente(@PathVariable String id, Model model) {
        model.addAttribute("user", clienteService.getById(Long.valueOf(id)));
        return "user/userShow";
    }

    @RequestMapping("user/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        Cliente cliente = this.clienteService.getById(Long.valueOf(id));
        ClienteForm clienteForm = clientToClientForm.convert(cliente);
        model.addAttribute("userform", clienteForm);
        return "user/userForm";
    }

    @RequestMapping("/user/new")
    public String newCliente(Model model) {
        model.addAttribute("userform", new ClienteForm());
        return "user/userForm";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String saveOrUpdateProduct(@Valid ClienteForm clienteForm, BindingResult bindingResult) {

        if(bindingResult.hasErrors()
//        || userForm.getId() == null
        || clienteForm.getName() == null
        || "".equals(clienteForm.getName())
        || clienteForm.getDataNascimento() == null) {
            return "redirect:/user/new/";
        }

        Cliente savedUser = clienteService.saveOrUpdateUserForm(clienteForm);
        return "redirect:/user/userShow/" + savedUser.getId();
    }

    @RequestMapping("/user/delete/{id}")
    public String delete(@PathVariable String id) {
        clienteService.delete(Long.valueOf(id));
        return "redirect:/user/userList";
    }
}