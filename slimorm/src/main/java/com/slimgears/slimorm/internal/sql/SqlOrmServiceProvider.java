// Copyright 2015 Denis Itskovich
// Refer to LICENSE.txt for license details
package com.slimgears.slimorm.internal.sql;

import com.slimgears.slimorm.internal.interfaces.OrmServiceProvider;

/**
 * Created by Denis on 14-Apr-15
 * <File Description>
 */
public interface SqlOrmServiceProvider extends OrmServiceProvider {
    SqlStatementBuilder getStatementBuilder();
}