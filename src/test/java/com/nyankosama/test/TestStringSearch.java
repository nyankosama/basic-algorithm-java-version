package com.nyankosama.test;

import com.nyankosama.algorithm.string.KMPSearch;
import org.junit.Test;

/**
 * Created by i@nyankosama.com on 2014/12/6.
 */
public class TestStringSearch {

    @Test
    public void TestKMP() {
         System.out.println(KMPSearch.search("BBC ABCDAB ABCDABCDABDE", "ABCDABD"));
    }
}
