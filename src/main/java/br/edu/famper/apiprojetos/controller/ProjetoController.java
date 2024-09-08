package br.edu.famper.apiprojetos.controller;

import br.edu.famper.apiprojetos.model.Projeto;
import br.edu.famper.apiprojetos.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/projetos")
public class ProjetoController {
    @Autowired
    private ProjetoService projetoService;

    @GetMapping("/GET")
    public ResponseEntity<List<Projeto>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(projetoService.findAll());
}

    @GetMapping("/GET/{id}")
    public ResponseEntity<Projeto> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(projetoService.findById(id));
    }

    @PostMapping("/POST")
    @Validated
    public ResponseEntity<Projeto> create(@RequestBody Projeto projeto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(projetoService.salvar(projeto));
    }

    @PutMapping("/PUT/{id}")
    public ResponseEntity<Projeto> update(@RequestBody Projeto projeto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(projetoService.update(projeto));
    }

    @DeleteMapping("/DELETE/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        projetoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}