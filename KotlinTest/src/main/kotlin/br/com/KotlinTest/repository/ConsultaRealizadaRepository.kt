package br.com.KotlinTest.repository

import br.com.KotlinTest.entity.ConsultaRealizada
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ConsultaRealizadaRepository: JpaRepository<ConsultaRealizada, Long> {}