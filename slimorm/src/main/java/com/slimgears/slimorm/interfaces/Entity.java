// Copyright 2015 Denis Itskovich
// Refer to LICENSE.txt for license details
package com.slimgears.slimorm.interfaces;

/**
 * Created by Denis on 05-Apr-15
 * <File Description>
 */
public interface Entity<TKey> {
    TKey getEntityId();
}
