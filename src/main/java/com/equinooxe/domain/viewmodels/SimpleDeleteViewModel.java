/* Copyright (C) 2015  mohamedboullouz@gmail.com 
 * This file is part of Equinooxe Project
 */
package com.equinooxe.domain.viewmodels;

/**
 * View model to simplify delete of entities by encapsulating 
 * some data like ids, delete type ...
 * @author mboullouz
 */
public class SimpleDeleteViewModel {
    /**
     * Delete a list of records
     */
    public Long[] ids;
    
    /**
     * We can simply choose to marke a record as "deleted" not completely removed
     */
    public boolean hard=false;
}
