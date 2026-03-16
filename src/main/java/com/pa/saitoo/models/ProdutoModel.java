package com.pa.saitoo.models;

import jakarta.persistence.*;


@Entity
@Table(name = "TBL_PRODUTO")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double preco;
    private Integer quantidade;

}
