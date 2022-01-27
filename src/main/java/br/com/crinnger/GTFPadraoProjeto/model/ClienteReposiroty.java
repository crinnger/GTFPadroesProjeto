package br.com.crinnger.GTFPadraoProjeto.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteReposiroty extends JpaRepository<Cliente,Long> {
}
