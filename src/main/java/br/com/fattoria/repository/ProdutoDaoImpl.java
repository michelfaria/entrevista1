package br.com.fattoria.repository;

import br.com.fattoria.entity.Produto;
import br.com.fattoria.metamodel.Produto_;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class ProdutoDaoImpl extends JPADAO<Produto> implements ProdutoDao {

    public ProdutoDaoImpl() {
        super(Produto.class);
    }

    @Override
    public @Nullable
    Produto buscaPorNome(String nome) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Produto> cq = cb.createQuery(Produto.class);
        Root<Produto> produto = cq.from(Produto.class);

        cq.select(produto)
                .where(cb.equal(produto.get(Produto_.nome), nome));

        try {
            return getEntityManager().createQuery(cq).getSingleResult();
        } catch (NoResultException ex) {
            // Caso não haja resultados, retorne null
            return null;
        }
    }

}
