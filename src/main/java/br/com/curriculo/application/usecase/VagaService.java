package br.com.curriculo.application.usecase;

import br.com.curriculo.adapter.input.dto.VagaDTO;
import br.com.curriculo.adapter.output.banco.entidade.VagaEntidade;
import br.com.curriculo.adapter.output.banco.repository.VagaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class VagaService {

    @Inject
    VagaRepository vagaRepository;

    @Transactional
    public void salvarVaga(VagaDTO dto) {
        VagaEntidade vaga = new VagaEntidade();
        vaga.setTitulo(dto.titulo());
        vaga.setDescricao(dto.descricao());
        vaga.setArea(dto.area());
        vaga.setNivel(dto.nivel());
        vaga.setAnosMinimosExperiencia(dto.anosMinimosExperiencia());
        vaga.setTecnologiasObrigatorias(dto.tecnologiasObrigatorias());
        vaga.setTecnologiasDesejadas(dto.tecnologiasDesejadas());
        vaga.setEmpresa(dto.empresa());
        vaga.setDataCriacao(LocalDateTime.now());
        vagaRepository.persist(vaga);
    }

    public List<VagaEntidade> listarVagas() {
        return vagaRepository.listAll();
    }
}
