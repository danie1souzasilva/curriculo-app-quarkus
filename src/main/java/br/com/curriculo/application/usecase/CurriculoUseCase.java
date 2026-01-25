package br.com.curriculo.application.usecase;

import br.com.curriculo.adapter.output.banco.repository.CurriculoRepository;
import br.com.curriculo.domain.model.Curriculo;
import io.vavr.control.Try;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CurriculoUseCase {


    @Inject
    CurriculoRepository curriculoRepository;

    public void salvarCurriculo(Curriculo curriculo){
        Try.run(() -> curriculoRepository.salvarCurriculo(curriculo) )
                .onFailure(throwable -> System.out.println("Erro ao salvarCurriculo: " + throwable.getMessage()));
    }
    public Try<Curriculo> buscarCurriculo(String nome){
        return Try.of(() -> {
            Curriculo curriculo = curriculoRepository.buscarCurriculo(nome);
            return curriculo;
        });

    }
}
