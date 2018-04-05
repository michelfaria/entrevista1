package br.com.fattoria.service;

import br.com.fattoria.entity.Produto;

import javax.transaction.Transactional;
import java.util.List;

public interface ProdutoService {
    /**
     * Insere um Produto no banco de dados
     *
     * @param produto produto a ser inserido
     */
    @Transactional
    void cadastrar(Produto produto);

    /**
     * Retorna todos os produtos do banco.
     *
     * @return lista de todos os produtos do banco
     */
    @Transactional
    List<Produto> todosProdutos();

    /**
     * Atualiza um produto.
     *
     * @param produto produto a ser atualizado
     * @throws NoSuchProductException se não for encontrado um produto com o mesmo id
     */
    @Transactional
    void atualizar(Produto produto) throws NoSuchProductException;

    /**
     * Deleta um produto.
     *
     * @param produto produto a ser deletado
     * @throws NoSuchProductException se não for encontrado um produto com o mesmo id
     */
    @Transactional
    void deletar(Produto produto) throws NoSuchProductException;

    /**
     * Exceção atirada quando tenta-se fazer uma operação com um produto não existente
     * quando a presença de um é necessária.
     */
    class NoSuchProductException extends Exception {
    }
}
