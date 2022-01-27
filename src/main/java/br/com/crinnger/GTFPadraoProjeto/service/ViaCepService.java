package br.com.crinnger.GTFPadraoProjeto.service;

import br.com.crinnger.GTFPadraoProjeto.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="viacep", url="https://viacep.com.br/ws")
public interface ViaCepService {
    @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/")
    public Endereco consultarCep(@PathVariable("cep") String cep);
}
