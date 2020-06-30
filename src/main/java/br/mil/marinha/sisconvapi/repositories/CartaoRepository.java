package br.mil.marinha.sisconvapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.mil.marinha.sisconvapi.domain.Cartao;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Integer>{
	@Query("SELECT obj FROM Cartao obj WHERE obj.numero = :numero")
	Cartao findByNumeroCartao(@Param("numero") String numero);
}
