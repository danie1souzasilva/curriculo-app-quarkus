package br.com.curriculo.application.usecase;

import br.com.curriculo.adapter.input.dto.CurriculoDTO;
import br.com.curriculo.adapter.output.MapearCurriculo;
import br.com.curriculo.adapter.output.banco.repository.CurriculoRepository;
import br.com.curriculo.domain.model.Curriculo;
import br.com.curriculo.domain.model.ScoreDetalhado;
import br.com.curriculo.domain.service.CurriculoService;
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
    @Inject
    CurriculoService service;

    @Transactional
    public void salvarCurriculo(CurriculoDTO dto) {
        Curriculo curriculo = mapper.dtoParaDominio(dto);
        curriculoRepository.salvarCurriculo(curriculo);
        System.out.println("CurriculoRepository.salvarCurriculo");
        int calculo = calcularScore(dto);
        System.out.println("calculo" + calculo);
    }
    public int calcularScore(CurriculoDTO curriculo) {
        Curriculo convertido = mapper.dtoParaDominio(curriculo);
        int resultado = service.calcularScore(convertido);
        return resultado;
    }

    public Curriculo buscarCurriculo(String nome) {
        return curriculoRepository.buscarPorNome(nome);
    }
}
