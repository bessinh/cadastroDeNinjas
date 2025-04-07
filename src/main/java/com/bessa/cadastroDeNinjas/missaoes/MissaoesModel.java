package com.bessa.cadastroDeNinjas.missaoes;

import com.bessa.cadastroDeNinjas.ninjas.NinjaModel;
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
  private long id;
  private String nome;
  private String dificuldade;
  @OneToMany(mappedBy = "missoes")
  private List <NinjaModel> ninjas;
}
