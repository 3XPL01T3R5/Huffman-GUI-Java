/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author lucas
 */
public class GeradorID {

    private static AtomicLong id = new AtomicLong();

    public static String getID() {
        return String.valueOf(id.getAndIncrement());
    }
}
