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

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Seja bem vindo";
    }

    @PostMapping("/criar")
    public String criarNinja() {
        return "ninja criar";
    }

    @GetMapping("/all")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarTodos();
    }

    @GetMapping("/listar/{id}")
    public NinjaModel verNinjasPorId(@PathVariable Long id) {
        return ninjaService.listarPorId(id);
    }

    @PutMapping("/id")
    public String atualizarNinjasPorId() {
        return "atualizar ninjas por id";
    }


    @DeleteMapping("/id")
    public String deletarNinjasPorId() {
        return "atualizar ninjas por id";
    }


}
