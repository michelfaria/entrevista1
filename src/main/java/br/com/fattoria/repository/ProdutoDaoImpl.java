package br.com.fattoria.repository;

import br.com.fattoria.entity.Produto;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoDaoImpl extends JPADAO<Produto> implements ProdutoDao {
    public ProdutoDaoImpl() {
        super(Produto.class);
    }
}
