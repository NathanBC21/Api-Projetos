package br.edu.famper.apiprojetos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "tbl_projeto")
@Data
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "projeto_id")
    private Long codigo;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "descricao", length = 100, nullable = true)
    private String descricao;

    @Column(name = "dataInicio", length = 10, nullable = false)
    private String dataInicio;

    @Column(name = "dataFim", length = 10, nullable = true)
    private String dataFim;
}
