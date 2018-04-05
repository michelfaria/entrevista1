package br.com.fattoria.repository;

import br.com.fattoria.entity.Produto;
import org.jetbrains.annotations.Nullable;

public interface ProdutoDao extends DAO<Produto> {
    /**
     * Busca um Produto no banco pelo nome.
     * Se o produto for encontrado, este será retornado. Senão, retornará null.
     *
     * @param nome nome com o qual efetuar busca
     * @return um Produto se for encontrado, senão null
     */
    @Nullable
    Produto buscaPorNome(String nome);
}
