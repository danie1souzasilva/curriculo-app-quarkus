package br.com.curriculo.application.usecase;

import br.com.curriculo.adapter.output.banco.repository.CurriculoRepository;
import br.com.curriculo.domain.model.Curriculo;
import io.vavr.control.Try;
import jakarta.inject.Inject;

public class CurriculoUseCase {


    @Inject
    CurriculoRepository curriculoRepository;

    public void salvarCurriculo(Curriculo curriculo){
        Try.run(() -> curriculoRepository.salvarCurriculo(curriculo) )
                .onFailure(throwable -> System.out.println("Erro ao salvarCurriculo: " + throwable.getMessage()));
    }
    public Curriculo buscarCurriculo(String nome){

    }
}
