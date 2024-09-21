package com.api_produtos.demo.controller;

// ProdutoController.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.api_produtos.demo.model.Produto;
import com.api_produtos.demo.repository.ProdutoRepository;


@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/")
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", produtoRepository.findAll());
        return "lista"; // Renderiza o template lista.html
    }

    @GetMapping("/cadastro")
    public String mostrarFormulario(Model model) {
        model.addAttribute("produto", new Produto());   
        return "cadastro"; // Renderiza o template cadastro.html
    }

    @PostMapping("/cadastro")
    public String cadastrarProduto(Produto produto) {
        produtoRepository.save(produto); 
        return "redirect:/"; 
    }

}