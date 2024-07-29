package br.com.lucascardoso.gestao_vagas.modules.cadidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucascardoso.gestao_vagas.exceptions.UserFoundException;
import br.com.lucascardoso.gestao_vagas.modules.cadidate.entities.CandidateEntity;
import br.com.lucascardoso.gestao_vagas.modules.cadidate.repositories.CandidateRepository;

@Service
public class CreateCandidateUseCase {

  @Autowired
  private CandidateRepository candidateRepository;

  public CandidateEntity execute (CandidateEntity candidateEntity) {
    this.candidateRepository
    .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
    .ifPresent((user) -> {
      throw new UserFoundException();
    });;

    return this.candidateRepository.save(candidateEntity);
  }
}
