package br.com.fattoria.repository;

import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.List;

public interface DAO<T extends Serializable> {
    /**
     * Retorna uma entidade T com um id específico.
     *
     * @param id chave primaria
     * @return a entidade encontrada ou null se a entidade não existe
     */
    @Nullable
    T findOne(int id);

    /**
     * Encontra todas as entidades do tipo T.
     *
     * @return lista de entidades
     */
    List<T> findAll();

    /**
     * Persiste uma entidade to tipo T.
     *
     * @param entity entidade a ser persistida
     */
    void create(T entity);

    /**
     * Atualiza uma entidade do tipo T.
     *
     * @param entity entidade a ser atualizada
     */
    void update(T entity);

    /**
     * Remove uma entidade do tipo T.
     *
     * @param entity entidade a ser removida
     */
    void delete(T entity);

    /**
     * @return true se há pelo menos um registro na tabela de T.
     */
    boolean oneExists();
}
