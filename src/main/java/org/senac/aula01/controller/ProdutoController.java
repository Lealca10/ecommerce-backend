package org.senac.aula01.controller;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.senac.aula01.model.Produto;
import org.senac.aula01.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository; 
    
    @GetMapping
    public List<Produto> get(@RequestParam(value = "sortBy", required = false) String sortBy,
    @RequestParam(value = "order", required = false) String order) {
Sort sort = Sort.unsorted(); // Define um valor padrão (sem ordenação)

// Verifica se os parâmetros estão presentes e configura o `Sort`
if (sortBy != null && order != null) {
sort = order.equalsIgnoreCase("desc")
? Sort.by(sortBy).descending()
: Sort.by(sortBy).ascending();
}

// Retorna os produtos com ordenação aplicada
return repository.findAll(sort);
}

    @PostMapping
    public Produto save(@RequestBody Produto produto) {
        return repository.save(produto);
    }
    
}
