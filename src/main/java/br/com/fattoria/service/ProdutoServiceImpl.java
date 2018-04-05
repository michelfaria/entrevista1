package br.com.fattoria.service;

import br.com.fattoria.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.fattoria.repository.ProdutoDao;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private ProdutoDao produtoDao;

    @Autowired
    public ProdutoServiceImpl(ProdutoDao produtoDao) {
        this.produtoDao = produtoDao;
    }

    @Override
    @Transactional
    public void cadastrar(Produto produto) {
        produtoDao.create(produto);
    }

    @Override
    @Transactional
    public List<Produto> todosProdutos() {
        return produtoDao.findAll();
    }

    @Override
    @Transactional
    public void atualizar(Produto produto) throws NoSuchProductException {
        if (!produtoExiste(produto)) {
            throw new NoSuchProductException();
        }
        produtoDao.update(produto);
    }

    @Override
    @Transactional
    public void deletar(Produto produto) throws NoSuchProductException {
        Produto entity = produtoDao.findOne(produto.getId());
        if (entity == null) {
            throw new NoSuchProductException();
        }
        produtoDao.delete(entity);
    }

    private boolean produtoExiste(Produto produto) {
        return produtoDao.findOne(produto.getId()) != null;
    }
}
