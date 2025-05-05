package com.bessa.cadastroDeNinjas.ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class Controller {
    private NinjaService ninjaService;

    public Controller(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }



    @PostMapping("/criar")
    public ResponseEntity<String>  criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("ninja criado com sucesso" + novoNinja.getNome());
    }

    @GetMapping("/all")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas =  ninjaService.listarTodos();
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> verNinjasPorId(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listarPorId(id);

        if (ninja !=null){
            return ResponseEntity.ok( ninja);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ninja não encontrado");
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarNinjasPorId(@PathVariable Long id, @RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaAtualizado = ninjaService.atualizaNinja(id, ninja);

        if (ninjaAtualizado != null){
            return ResponseEntity.ok(ninja);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja não encontrado");
        }
    }


    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjasPorId(@PathVariable Long id) {
        if (ninjaService.listarPorId(id) != null){
            ninjaService.deletarPorId(id);
            return ResponseEntity.ok("ninja deletado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ninja não existe");
        }
    }


}
