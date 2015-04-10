// Copyright 2015 Denis Itskovich
// Refer to LICENSE.txt for license details
package com.slimgears.slimorm.internal.sql;

import com.slimgears.slimorm.interfaces.RepositorySession;

/**
 * Created by Denis on 09-Apr-15
 * <File Description>
 */
public interface SqlRepositorySession extends RepositorySession {
    SqlCommandExecutor getExecutor();
    SqlStatementBuilder getStatementBuilder();
}
