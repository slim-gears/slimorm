// Copyright 2015 Denis Itskovich
// Refer to LICENSE.txt for license details
package com.slimgears.slimorm.core.internal;

import com.slimgears.slimorm.core.interfaces.conditions.BinaryCondition;
import com.slimgears.slimorm.core.interfaces.conditions.CollectionCondition;
import com.slimgears.slimorm.core.interfaces.conditions.CompositeCondition;
import com.slimgears.slimorm.core.interfaces.conditions.Condition;
import com.slimgears.slimorm.core.interfaces.conditions.TernaryCondition;
import com.slimgears.slimorm.core.interfaces.conditions.UnaryCondition;

/**
 * Created by Denis on 11-Apr-15
 * <File Description>
 */
public abstract class PredicateVisitor<TEntity, T> {
    public T visit(Condition<TEntity> condition) {
        if (condition instanceof BinaryCondition) return visitBinary((BinaryCondition<TEntity, ?>) condition);
        if (condition instanceof UnaryCondition) return visitUnary((UnaryCondition<TEntity, ?>) condition);
        if (condition instanceof TernaryCondition) return visitTernary((TernaryCondition<TEntity, ?>) condition);
        if (condition instanceof CollectionCondition) return visitCollection((CollectionCondition<TEntity, ?>) condition);
        if (condition instanceof CompositeCondition) return visitComposite((CompositeCondition<TEntity>) condition);
        return visitUnknown(condition);
    }

    protected abstract T visitBinary(BinaryCondition<TEntity, ?> predicate);
    protected abstract T visitTernary(TernaryCondition<TEntity, ?> predicate);
    protected abstract T visitCollection(CollectionCondition<TEntity, ?> predicate);
    protected abstract T visitUnary(UnaryCondition<TEntity, ?> predicate);
    protected abstract T visitComposite(CompositeCondition<TEntity> predicate);
    protected abstract T visitUnknown(Condition<TEntity> condition);
}