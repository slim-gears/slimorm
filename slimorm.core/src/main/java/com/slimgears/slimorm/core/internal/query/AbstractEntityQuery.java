// Copyright 2015 Denis Itskovich
// Refer to LICENSE.txt for license details
package com.slimgears.slimorm.core.internal.query;

import com.slimgears.slimorm.core.interfaces.entities.Entity;
import com.slimgears.slimorm.core.interfaces.predicates.Predicate;
import com.slimgears.slimorm.core.interfaces.predicates.Predicates;
import com.slimgears.slimorm.core.interfaces.queries.QueryBuilder;

/**
 * Created by Denis on 07-Apr-15
 * <File Description>
 */
public abstract class AbstractEntityQuery<
        TKey,
        TEntity extends Entity<TKey>,
        TQuery,
        TBuilder extends QueryBuilder<TEntity, TQuery, TBuilder>,
        TQueryParams extends ConditionalQueryParams<TKey, TEntity, TQueryParams>>
        implements QueryBuilder<TEntity, TQuery, TBuilder> {
    protected final TQueryParams queryParams;
    protected final QueryProvider<TKey, TEntity> queryProvider;

    protected abstract TBuilder fork(TQueryParams queryParams, QueryProvider<TKey, TEntity> queryProvider);
    protected abstract TBuilder builder();

    protected AbstractEntityQuery(TQueryParams queryParams, QueryProvider<TKey, TEntity> queryProvider) {
        this.queryParams = queryParams;
        this.queryProvider = queryProvider;
    }

    @Override
    public TBuilder where(Predicate<TEntity> predicate) {
        queryParams.predicate = queryParams.predicate != null
                ? Predicates.and(queryParams.predicate, predicate)
                : predicate;
        return builder();
    }

    @Override
    public TBuilder skip(int offset) {
        if (queryParams.pagination == null) {
            queryParams.pagination = new QueryPagination();
        }
        queryParams.pagination.offset = offset;
        return builder();
    }

    @Override
    public TBuilder limit(int count) {
        if (queryParams.pagination == null) {
            queryParams.pagination = new QueryPagination();
        }
        queryParams.pagination.limit = count;
        return builder();
    }

    @Override
    public TBuilder fork() {
        return fork(queryParams.fork(), queryProvider);
    }
}