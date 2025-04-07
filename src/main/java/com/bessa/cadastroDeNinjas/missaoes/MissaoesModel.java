package com.bessa.cadastroDeNinjas.missaoes;

import com.bessa.cadastroDeNinjas.ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_name")
public class MissaoesModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String nome;
  private String dificuldade;
  @OneToMany(mappedBy = "missoes")
  private List <NinjaModel> ninjas;
}
