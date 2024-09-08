package br.edu.famper.apiprojetos.service;

import br.edu.famper.apiprojetos.model.Projeto;
import br.edu.famper.apiprojetos.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Transactional
    public Projeto salvar(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public List<Projeto> findAll() {
        return projetoRepository.findAll();
    }

    public Projeto findById(Long id) {
        Optional<Projeto> projeto = projetoRepository.findById(id);
        return projeto.orElseThrow(() ->
                    new RuntimeException("Usuário não encontrado")
                );
    }

    @Transactional
    public Projeto update(Projeto projeto) {
        Projeto salvo = projetoRepository.findById(projeto.getCodigo()).
                orElseThrow(() ->
                         new RuntimeException("Projeto não encontrado!")
                );
        salvo.setNome(projeto.getNome());
        salvo.setDescricao(projeto.getDescricao());
        salvo.setDataInicio(projeto.getDataInicio());
        salvo.setDataFim(projeto.getDataFim());
        return projetoRepository.save(salvo);
    }

    public void deleteById(Long id) {
        findById(id);
        projetoRepository.deleteById(id);
    }
}

