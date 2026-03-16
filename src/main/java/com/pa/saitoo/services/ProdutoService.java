package com.pa.saitoo.services;

import com.pa.saitoo.models.ProdutoModel;
import com.pa.saitoo.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoModel> findall(){
        return produtoRepository.findAll();
    }

    public ProdutoModel cadastrarProduto(ProdutoModel produtoModel){
        return produtoRepository.save(produtoModel);
    }

    public ProdutoModel listarPorId(Long id){
        return produtoRepository.findById(id).get();
    }

    public ProdutoModel atualizarProduto(Long id, ProdutoModel produtoModel){
        ProdutoModel produto = produtoRepository.findById(id).get();
        produto.setName(produtoModel.getName());
        produto.setPreco(produtoModel.getPreco());
        produto.setQuantidade(produtoModel.getQuantidade());
         return produtoRepository.save(produto);
    }

    public void removerProduto(Long id){
        produtoRepository.deleteById(id);
    }
}
