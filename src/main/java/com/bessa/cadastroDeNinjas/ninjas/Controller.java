package com.bessa.cadastroDeNinjas.ninjas;

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
    public NinjaDTO criarNinja( @RequestBody NinjaDTO ninja) {
        return  ninjaService.criarNinja(ninja);
    }

    @GetMapping("/all")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarTodos();
    }

    @GetMapping("/listar/{id}")
    public NinjaModel verNinjasPorId(@PathVariable Long id) {
        return ninjaService.listarPorId(id);
    }

    @PutMapping("/atualizar/{id}")
    public NinjaModel atualizarNinjasPorId(@PathVariable Long id, @RequestBody NinjaModel ninja) {
        return ninjaService.atualizaNinja(id, ninja);
    }


    @DeleteMapping("/deletar/{id}")
    public void deletarNinjasPorId(@PathVariable Long id) {
        ninjaService.deletarPorId(id);
    }


}
