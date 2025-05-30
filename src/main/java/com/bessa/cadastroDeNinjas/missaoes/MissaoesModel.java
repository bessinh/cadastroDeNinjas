package com.bessa.cadastroDeNinjas.missaoes;

import com.bessa.cadastroDeNinjas.ninjas.NinjaModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_name")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MissaoesModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private String dificuldade;

  @OneToMany(mappedBy = "missoes")
  @JsonIgnore  // tira o loop infinito
  private List <NinjaModel> ninjas;
}
