package net.kimleo.hjk;

import net.kimleo.hjk.internal.Assoc;
import net.kimleo.hjk.internal.Iter;
import org.junit.Test;

import java.util.Arrays;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class $Test {
    @Test
    public void test$Bind1st() throws Exception {
        assertThat(
                _.on(Arrays.asList(1, 2, 3, 4))
                        .map($.<Integer>op((x, y) -> x * y).bind1st(5))
                        .<Integer>reduce(0, (x, y) -> x + y),
                is(50));
    }

    @Test
    public void testOnMethodRef() throws Exception {
        Iter<Integer> result = _.on(Arrays.asList(1, 2, 3, 4)).map($.<Integer>op((x, y) -> x - y).bind1st(1));
        for (int i : result) {
            assertTrue(i <= 0);
        }
    }

    @Test
    public void testUnaryOp() throws Exception {
        assertTrue($.<Integer>op(x -> x + 1).apply(3) == 4);
    }

    @Test
    public void testUnaryPredicate() throws Exception {
        Predicate<Integer> pred = x -> x > 1;
        assertTrue($.pred(pred).apply(2));
        assertFalse($.pred(pred).apply(0));
    }

    @Test
    public void testBinaryPredicate() throws Exception {
        Assoc<Integer, Integer, Boolean> pred = $.pred((x, y) -> x > y);
        assertTrue(pred.apply(5, 3));
        assertFalse(pred.exchange().apply(5, 3));
    }
}
