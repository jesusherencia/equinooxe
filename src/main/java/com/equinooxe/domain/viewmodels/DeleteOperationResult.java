/* Copyright (C) 2015  mohamedboullouz@gmail.com 
 * This file is part of Equinooxe Project
 */
package com.equinooxe.domain.viewmodels;

/**
 *
 * @author mboullouz
 */
public class DeleteOperationResult {

    public String entityName = "";
    public int hardDeleteCount = 0;
    public int softDeleteCount = 0;
    public int initialDeleteCount;

    public DeleteOperationResult(int initialDeleteCount) {
        this.initialDeleteCount = initialDeleteCount;
    }

    public DeleteOperationResult(int initialDeleteCount, String entityName) {
        this.initialDeleteCount = initialDeleteCount;
        this.entityName = entityName;
    }

    public void incrementeSoftDeleteCounter() {
        this.softDeleteCount++;
    }

    public void incrementeHardDeleteCounter() {
        this.hardDeleteCount++;
    }
}
