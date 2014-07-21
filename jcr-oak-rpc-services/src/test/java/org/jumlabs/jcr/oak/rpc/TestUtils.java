/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jumlabs.jcr.oak.rpc;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author otto
 */
public class TestUtils {

public static String randomIdentifier() {
        // class variable
final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";

final java.util.Random rand = new java.util.Random();

// consider using a Map<String,Boolean> to say whether the identifier is being used or not 
final Set<String> identifiers = new HashSet<String>();

    StringBuilder builder = new StringBuilder();
    while(builder.toString().length() == 0) {
        int length = rand.nextInt(5)+5;
        for(int i = 0; i < length; i++)
            builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
        if(identifiers.contains(builder.toString())) 
            builder = new StringBuilder();
    }
    return builder.toString();
}
}
