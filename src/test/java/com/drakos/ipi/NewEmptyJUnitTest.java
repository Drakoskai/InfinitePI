package com.drakos.ipi;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bbrown005c
 */
public class NewEmptyJUnitTest {

    public NewEmptyJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hello() {
        BigInteger TWO = BigInteger.valueOf(2);
        BigInteger THREE = BigInteger.valueOf(3);
        BigInteger FOUR = BigInteger.valueOf(4);
        BigInteger SEVEN = BigInteger.valueOf(7);

        BigInteger q = BigInteger.ONE;
        BigInteger r = BigInteger.ZERO;
        BigInteger t = BigInteger.ONE;
        BigInteger k = BigInteger.ONE;
        BigInteger n = BigInteger.valueOf(3);
        BigInteger l = BigInteger.valueOf(3);
        BigInteger nn, nr;
        boolean first = true;

        List<Integer> place = new ArrayList();
        place.add(0);
        int i = 0;
        int[] code = new int[3];
        int j = 0;
        StringBuilder b = new StringBuilder(144);
        while (true) {
            if (FOUR.multiply(q).add(r).subtract(t).compareTo(n.multiply(t)) == -1) {
                //System.out.println("current PI digitValue=" + n);
                if (j != 3) {
                    code[j] = n.intValue();
                } else {
                    char c = (char) ((code[2] * 100) + (code[1] * 10) + code[0]);
                    if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                        if (b.length() == 144) {
                            System.out.println(b.toString());
                            b.delete(0, 143);
                            b.trimToSize();
                        }
                        b.append(String.valueOf(c).toLowerCase());
                    }
                    j = 0;
                    code[j] = n.intValue();
                }
                j++;
                if (first) {
                    //System.out.println(".");
                    first = false;
                }

                nr = BigInteger.TEN.multiply(r.subtract(n.multiply(t)));
                n = BigInteger.TEN.multiply(THREE.multiply(q).add(r)).divide(t).subtract(BigInteger.TEN.multiply(n));
                q = q.multiply(BigInteger.TEN);
                r = nr;

                int current = place.remove(i);
                if (current == Integer.MAX_VALUE) {
                    i++;
                    current = 0;
                } else {
                    current++;
                }
                place.add(i, current);
                long currentPiIndex = 0;
                if (i > 1) {
                    for (int index : place) {
                        currentPiIndex += index;
                    }
                } else {
                    currentPiIndex = current;
                }

                //System.out.println("at PI index=" + currentPiIndex);
                System.out.flush();
            } else {
                nr = TWO.multiply(q).add(r).multiply(l);
                nn = q.multiply((SEVEN.multiply(k))).add(TWO).add(r.multiply(l)).divide(t.multiply(l));
                q = q.multiply(k);
                t = t.multiply(l);
                l = l.add(TWO);
                k = k.add(BigInteger.ONE);
                n = nn;
                r = nr;
            }
        }
    }
}
