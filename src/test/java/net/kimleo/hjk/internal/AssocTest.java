package net.kimleo.hjk.internal;

import net.kimleo.hjk.$;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AssocTest {
    @Test
    public void testInjectR() throws Exception {
        Assoc<Integer, Integer, Integer> injected =
                $.<Integer>op((x, y) -> x + y).injectR(y -> y * 2);
        assertThat(injected.apply(1, 2), is(5));
    }

    @Test
    public void testInjectL() throws Exception {
        Assoc<Integer, Integer, Integer> injected =
                $.<Integer>op((x, y) -> x + y).injectL(x -> x * 2);
        assertThat(injected.apply(1, 2), is(4));
    }

    @Test
    public void testBind1st() throws Exception {
        Trans<Integer, Integer> bind =
                $.<Integer>op((x, y) -> x + y)
                        .<Integer>injectL(x -> x * 2)
                        .bind1st(1);
        assertThat(bind.apply(2), is(4));
    }

    @Test
    public void testBind2nd() throws Exception {
        Trans<Integer, Integer> bind = $.<Integer>op((x, y) -> x + y)
                .<Integer>injectL(x -> x * 2)
                .bind2nd(1);
        assertThat(bind.apply(2), is(5));
    }

    @Test
    public void testExchange() throws Exception {
        Assoc<Integer, Integer, Integer> tr = $.on((x, y) -> x + y);
        assertThat(tr.exchange().apply(1, 2), is(tr.apply(1, 2)));
    }
}
