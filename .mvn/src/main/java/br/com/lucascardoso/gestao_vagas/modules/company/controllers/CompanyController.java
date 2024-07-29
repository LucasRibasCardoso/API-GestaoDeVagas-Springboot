package br.com.lucascardoso.gestao_vagas.modules.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucascardoso.gestao_vagas.modules.company.entities.CompanyEntity;
import br.com.lucascardoso.gestao_vagas.modules.company.useCases.CreateCompanyUseCases;
import lombok.var;

@RestController
@RequestMapping("/company")
public class CompanyController {

  @Autowired
  private CreateCompanyUseCases createCompanyUseCases;

  @PostMapping("/")
  public ResponseEntity<Object> create(@RequestBody CompanyEntity companyEntity) {
      try {
        var result = this.createCompanyUseCases.execute(companyEntity);
        return ResponseEntity.ok().body(result);
      }
      catch (Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
      }
  }
}
