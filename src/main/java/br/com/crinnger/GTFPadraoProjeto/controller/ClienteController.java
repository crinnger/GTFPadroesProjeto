package br.com.crinnger.GTFPadraoProjeto.controller;

import br.com.crinnger.GTFPadraoProjeto.model.Cliente;
import br.com.crinnger.GTFPadraoProjeto.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        return ResponseEntity.ok(clienteService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> insert(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.insert(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id,@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.update(id,cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
