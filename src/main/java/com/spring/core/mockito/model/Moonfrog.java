package com.spring.core.mockito.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Since two files cannot have the same name, if a user enters a filename which
 * is previously used, the system will have a suffix addition to its name in the
 * form of (k), where, k is the smallest positive integer such that the obtained
 * name remains unique.
 * 
 * Return an array of strings of length n where output[i] is the actual name the
 * system will assign to the ith folder when the user creates it.
 * 
 * Input - ["moonfrog", "moonfrog(1)", "moonfrog(1)", "test", "moonfrog"]
 * Output - ["moonfrog","moonfrog(1)", "moonfrog(1)(1)", "test", "moonfrog(2)"]
 * 
 *Console output -  moonfrog, moonfrog(1), moonfrog(1)(1), test, moonfrog(2), 
 * 
 * mg - 1 - mg
 * mg(1) - 1 - mg(1)
 * mg(1) - 2 - mg(1) + (1)
 * mg - 2 - mg(2)
 * mg(1) - 3 - mg(1) + (2)
 * 
 * mg, mg(1), mg(1)(1), mg(2)
 * 
 * input - "moonfrog", "moonfrog(3)", "moonfrog(2)", "moonfrog(1)", "moonfrog"
 * outpu - "moonfrog", "moonfrog(3)", "moonfrog(2)", "moonfrog(1)",
 * Console output - moonfrog, moonfrog(3), moonfrog(2), moonfrog(1), moonfrog(4)
 * 
 * "moonfrog(4)"
 * 
 * delete files - MG(3), MG(5), MG(7)
 * 
 * Input - MG(3) - MG  
 * 
 * Delete Hashmap 
 * MG - [3, 5, 7]
 * 
 */
public class Moonfrog {

    public static String[] fileSystem(String[] files) {
        Map<String, Integer> map = new HashMap<>();
        String[] result = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            if (!map.containsKey(files[i])) {
                result[i] = files[i];
                map.put(files[i], 1);
            } else {
                int count = map.get(files[i]);
                String constructString = files[i] + "(" + (count) + ")";
                while (map.containsKey(constructString)) {
                    count++;
                    constructString = files[i] + "(" + (count) + ")";
                }

                result[i] = constructString;
                map.put(files[i], count);

                if (!map.containsKey(constructString))
                    map.put(constructString, 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] resultFiles = fileSystem(
                new String[] { "moonfrog", "moonfrog(1)", "moonfrog(1)", "test", "moonfrog" });
        System.out.println("1st  input cases");
        for (int i = 0; i < resultFiles.length; i++) {
            System.out.print(resultFiles[i] + ", ");
        }

        resultFiles = fileSystem(
                new String[] { "moonfrog", "moonfrog(3)", "moonfrog(2)", "moonfrog(1)", "moonfrog" });
        System.out.println("\n2nd input cases");
        for (int i = 0; i < resultFiles.length; i++) {
            System.out.print(resultFiles[i] + ", ");
        }
    }
}
