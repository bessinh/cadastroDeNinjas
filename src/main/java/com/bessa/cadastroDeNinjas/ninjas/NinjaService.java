package com.bessa.cadastroDeNinjas.ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }



    public List<NinjaModel>  listarTodos(){
        return ninjaRepository.findAll();
    }

    public NinjaModel listarPorId(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return  ninjaPorId.orElse(null);
    }

    public  NinjaDTO criarNinja(NinjaDTO ninjaDTO){
       NinjaModel ninja = ninjaMapper.map(ninjaDTO);
       ninja = ninjaRepository.save(ninja);
       return ninjaMapper.map(ninja);
    }

    public void deletarPorId(Long id){
        ninjaRepository.deleteById(id);
    }

    public  NinjaModel atualizaNinja(Long id, NinjaModel ninja ){
        if(ninjaRepository.existsById(id)){
            ninja.setId(id);
            return ninjaRepository.save(ninja);
        }
        return null;
    }
}
