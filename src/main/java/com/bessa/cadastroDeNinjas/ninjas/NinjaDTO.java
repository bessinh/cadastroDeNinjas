package com.bessa.cadastroDeNinjas.ninjas;

import com.bessa.cadastroDeNinjas.missaoes.MissaoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaDTO {

    private Long id;
    private String nome;
    private String imgUrl;
    private String email;
    private int idade;
    private MissaoesModel missoes;
    private String rank;


}
