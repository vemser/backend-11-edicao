package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//public interface PessoaRepository extends JpaRepository<ENTIDADE,TIPODOMEUID> {
@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity,Integer> {

}
