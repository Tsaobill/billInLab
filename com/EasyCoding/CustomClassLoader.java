package com.EasyCoding;

import java.io.FileNotFoundException;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-06-16 00:24
 **/
public class CustomClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] result = getClassFromCustomPath (name);
            if (result == null) {
                throw new FileNotFoundException ();
            } else {
                return defineClass (name, result, 0, result.length);
            }

        } catch (Exception e) {
            e.printStackTrace ();
        }
        throw new ClassNotFoundException ();
    }

    private byte[] getClassFromCustomPath(String name) {
        // TODO
        return  null;
    }


}
