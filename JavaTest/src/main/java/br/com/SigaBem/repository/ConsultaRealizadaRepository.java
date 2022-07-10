package br.com.SigaBem.repository;

import br.com.SigaBem.entities.DAO.ConsultaRealizada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRealizadaRepository extends JpaRepository<ConsultaRealizada, Long> {
}
