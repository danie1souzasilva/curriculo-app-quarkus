package br.com.curriculo.application.usecase;

import br.com.curriculo.adapter.input.dto.CurriculoDTO;
import br.com.curriculo.adapter.output.MapearCurriculo;
import br.com.curriculo.adapter.output.banco.repository.CurriculoRepository;
import br.com.curriculo.domain.model.Curriculo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CurriculoUseCase {

    @Inject
    CurriculoRepository curriculoRepository;

    @Inject
    MapearCurriculo mapper;

    @Transactional
    public void salvarCurriculo(CurriculoDTO dto) {
        Curriculo curriculo = mapper.dtoParaDominio(dto);
        curriculoRepository.salvarCurriculo(curriculo);
        System.out.println("CurriculoRepository.salvarCurriculo");
    }

    public Curriculo buscarCurriculo(String nome) {
        return curriculoRepository.buscarPorNome(nome);
    }
}
