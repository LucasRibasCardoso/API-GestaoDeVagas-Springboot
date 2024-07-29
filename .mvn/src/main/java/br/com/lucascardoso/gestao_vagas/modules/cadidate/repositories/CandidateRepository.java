package br.com.lucascardoso.gestao_vagas.modules.cadidate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucascardoso.gestao_vagas.modules.cadidate.entities.CandidateEntity;

import java.util.Optional;
import java.util.UUID;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID>{
  Optional<CandidateEntity> findByUsernameOrEmail(String username, String email);
}
