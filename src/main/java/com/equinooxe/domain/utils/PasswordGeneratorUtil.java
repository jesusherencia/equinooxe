/* Copyright (C) 2015  mohamedboullouz@gmail.com 
 * This file is part of Equinooxe Project
 */
package com.equinooxe.domain.utils;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;

/**
 * Password, hash & salt utility
 * @author mboullouz
 */
public class PasswordGeneratorUtil {

    /**
     * Generate a hash and a salt from a string password.
     *
     * @param password
     * @return String[]: [0]=password, [1]=salt
     */
    public static String[] getSaltAndPasswordFor(String password) {
        String[] hashAndSalt = new String[2];
        RandomNumberGenerator rng = new SecureRandomNumberGenerator();
        Object salt = rng.nextBytes();
        String hashedPasswordBase64 = new Sha256Hash(password, salt, 1024).toBase64();
        hashAndSalt[0] = hashedPasswordBase64;
        hashAndSalt[1] = salt.toString();
        return hashAndSalt;
    }
}
