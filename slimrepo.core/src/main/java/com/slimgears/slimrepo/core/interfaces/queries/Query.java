// Copyright 2015 Denis Itskovich
// Refer to LICENSE.txt for license details
package com.slimgears.slimrepo.core.interfaces.queries;

import com.slimgears.slimrepo.core.interfaces.fields.Field;
import com.slimgears.slimrepo.core.internal.interfaces.CloseableIterator;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Denis on 02-Apr-15
 * <File Description>
 */
public interface Query<T> {
    interface Builder<T> extends QueryBuilder<T, Query<T>, Builder<T>> {
        Builder<T> orderAsc(Field<T, ?>... fields);
        Builder<T> orderDesc(Field<T, ?>... fields);
    }

    T firstOrDefault() throws IOException;
    T singleOrDefault() throws IOException;
    List<T> toList() throws IOException;

    T[] toArray() throws IOException;
    long count() throws IOException;
    CloseableIterator<T> iterator();
}