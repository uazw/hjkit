package net.kimleo.hjk.internal;

import net.kimleo.hjk.$;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Kim Leo
 */
public class TriFnTest {

    @Test
    public void testBind1st() throws Exception {
        Integer integer = $.<Integer>op((x, y, z) -> x + y + z).bind1st(1).bind1st(1).apply(1);
        assertThat(integer, is(3));
    }

    @Test
    public void testBind2nd() throws Exception {
        Integer integer = $.<Integer>op((x, y, z) -> x + y + z).bind2nd(1).bind1st(1).apply(1);
        assertThat(integer, is(3));
    }

    @Test
    public void testBind3rd() throws Exception {
        Integer integer = $.<Integer>op((x, y, z) -> x + y + z).bind3rd(1).bind1st(1).apply(1);
        assertThat(integer, is(3));
    }
}
