package com.pa.saitoo.controllers;

import com.pa.saitoo.models.ProdutoModel;
import com.pa.saitoo.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/produtos")
public class PessoaController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoModel>>findAll(){
        List<ProdutoModel> requeste = produtoService.findall();
        return ResponseEntity.ok(requeste);
    }

    @PostMapping
    public ResponseEntity<ProdutoModel>cadastrarProduto(@RequestBody  ProdutoModel produtoModel){
        ProdutoModel produto = produtoService.cadastrarProduto(produtoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(produtoModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerProduto (@PathVariable Long id){
        produtoService.removerProduto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Optional<ProdutoModel> listarPorId(@PathVariable Long id){
        return  produtoService.listarPorId(id);
    }

    @PutMapping("/{id}")
    public ProdutoModel atualizarProduto(@PathVariable Long id, @RequestBody ProdutoModel produtoModel){
        return produtoService.atualizarProduto(id,produtoModel);
    }
}
