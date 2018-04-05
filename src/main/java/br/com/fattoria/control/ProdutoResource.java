package br.com.fattoria.control;

import br.com.fattoria.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.fattoria.service.ProdutoService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoResource {

    private ProdutoService produtoService;

    @Autowired
    public ProdutoResource(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void cadastrar(@Valid @RequestBody Produto produto) {
        produtoService.cadastrar(produto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Produto> consultar() {
        return produtoService.todosProdutos();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void atualizar(@Valid @RequestBody Produto produto) throws Exception {
        produtoService.atualizar(produto);
    }

    @PostMapping(value = "/deletar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deletar(@RequestBody Produto produto) throws Exception {
        if (produto.getId() == null) {
            throw new ProdutoService.NoSuchProductException();
        }
        produtoService.deletar(produto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(ProdutoService.NoSuchProductException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String noSuchProductHandler() {
        return "Produto não encontrado.";
    }
}