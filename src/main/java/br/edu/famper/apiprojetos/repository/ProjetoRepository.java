package br.edu.famper.apiprojetos.repository;

import br.edu.famper.apiprojetos.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
