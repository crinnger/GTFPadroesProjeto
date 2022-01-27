package br.com.crinnger.GTFPadraoProjeto.service;

import br.com.crinnger.GTFPadraoProjeto.model.Cliente;

import java.util.List;

public interface ClienteService {
    public List<Cliente> listAll();
    public Cliente findById(Long id);
    public Cliente insert(Cliente cliente);
    public Cliente update(Long id, Cliente cliente);
    public void delete(Long id);
}
