package br.com.fattoria.metamodel;

import br.com.fattoria.entity.Produto;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

/**
 * Meta-modelo estático para criação de queries tipadas
 */
@StaticMetamodel(Produto.class)
public class Produto_ {
    public static volatile SingularAttribute<Produto, String> nome;
    public static volatile SingularAttribute<Produto, Double> price;
    public static volatile SingularAttribute<Produto, Integer> quantidade;
    public static volatile SingularAttribute<Produto, Date> dataDeCadastro;
}
