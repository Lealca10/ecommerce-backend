package org.senac.aula01.repository;

import java.util.List;

import org.senac.aula01.model.Produto;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Sort;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

    List<Produto> findByNomeContains(String filter,Sort sort);
}
