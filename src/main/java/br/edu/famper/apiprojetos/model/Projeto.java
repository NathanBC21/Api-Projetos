package br.edu.famper.apiprojetos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "tbl_projeto")
@Data
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "projeto_id")
    private Long codigo;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "descricao", length = 100)
    private String descricao;

    @Column(name = "dataInicio", length = 10)
    private String dataInicio;

    @Column(name = "dataFim", length = 10)
    private String dataFim;
}
