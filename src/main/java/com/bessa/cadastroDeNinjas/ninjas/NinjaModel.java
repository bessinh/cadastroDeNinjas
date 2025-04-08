package com.bessa.cadastroDeNinjas.ninjas;

import com.bessa.cadastroDeNinjas.missaoes.MissaoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NinjaModel {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     private String nome;
     private String imgUrl;
     @Column(unique = true)
     private String email;
    private int idade;

    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissaoesModel missoes;



}
