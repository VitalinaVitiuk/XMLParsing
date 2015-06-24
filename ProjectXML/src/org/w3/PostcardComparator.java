package org.w3;

import java.util.Comparator;

public class PostcardComparator implements Comparator<Postcard> {

    @Override
    public int compare(Postcard obj1, Postcard obj2) {

        String str1 = obj1.getCountry();
        String str2 = obj2.getCountry();
        return str1.compareTo(str2);
    }

}