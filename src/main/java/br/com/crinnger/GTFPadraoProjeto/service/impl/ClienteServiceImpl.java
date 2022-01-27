package br.com.crinnger.GTFPadraoProjeto.service.impl;

import br.com.crinnger.GTFPadraoProjeto.model.Cliente;
import br.com.crinnger.GTFPadraoProjeto.model.ClienteReposiroty;
import br.com.crinnger.GTFPadraoProjeto.model.Endereco;
import br.com.crinnger.GTFPadraoProjeto.model.EnderecoRepository;
import br.com.crinnger.GTFPadraoProjeto.service.ClienteService;
import br.com.crinnger.GTFPadraoProjeto.service.ViaCepService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteReposiroty clienteReposiroty;
    private final EnderecoRepository enderecoRepository;
    private final ViaCepService viaCepService;

    @Override
    public List<Cliente> listAll() {
        return clienteReposiroty.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return clienteReposiroty.findById(id).orElseThrow();
    }

    @Override
    public Cliente insert(Cliente cliente) {
        return saveCliente(cliente);
    }

    private Cliente saveCliente(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco=enderecoRepository.findById(cep).orElseGet(()->{
           Endereco enderecoViaCep = viaCepService.consultarCep(cep);
           return enderecoRepository.save(enderecoViaCep);
        });
        cliente.setEndereco(endereco);
        return clienteReposiroty.save(cliente);
    }

    @Override
    public Cliente update(Long id, Cliente cliente) {
        Cliente clienteU=clienteReposiroty.findById(id).orElseThrow();
        clienteU.setEndereco(cliente.getEndereco());
        clienteU.setNome(cliente.getNome());
        return saveCliente(clienteU);
    }

    @Override
    public void delete(Long id) {
        clienteReposiroty.findById(id).orElseThrow();
        clienteReposiroty.deleteById(id);
    }
}
