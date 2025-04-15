package com.bessa.cadastroDeNinjas.ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }



    public List<NinjaDTO>  listarTodos(){
       List<NinjaModel> ninjas = ninjaRepository.findAll();
       return ninjas.stream()
               .map(ninjaMapper::map)
               .collect(Collectors.toList());
    }

    public NinjaDTO listarPorId(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return  ninjaPorId.map(ninjaMapper::map).orElse(null);
    }

    public  NinjaDTO criarNinja(NinjaDTO ninjaDTO){
       NinjaModel ninja = ninjaMapper.map(ninjaDTO);
       ninja = ninjaRepository.save(ninja);
       return ninjaMapper.map(ninja);
    }

    public void deletarPorId(Long id){
        ninjaRepository.deleteById(id);
    }

    public  NinjaDTO atualizaNinja(Long id, NinjaDTO ninjaDTO ){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        if (ninjaPorId.isPresent()){
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }
}
