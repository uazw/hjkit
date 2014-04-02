package net.kimleo.hjk.internal;

import net.kimleo.hjk._;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author Kim Leo
 */
public class IterTest {
    @Test
    public void testMap() throws Exception {

    }

    @Test
    public void testSelect() throws Exception {
        assertThat(_.on(Arrays.asList(1, 2, 3, 4, 5)).select(x -> x % 2 == 0).asList().get(0),
                is(2));
    }

    @Test
    public void testFilter() throws Exception {

    }

    @Test
    public void testReduce() throws Exception {
        assertThat(_.on(Arrays.asList(1, 2, 3, 4, 5)).<Integer>reduce(0, (x, y) -> x + y),
                is(15));

    }

    @Test
    public void testZip() throws Exception {
        assertThat(_.on(Arrays.asList("a", "b", "c")).zip(Arrays.asList(1, 2, 3)).get("a"), is(1));
    }

    @Test
    public void testAsList() throws Exception {
        assertThat(_.on(Arrays.asList(1, 2, 3)).asList().get(1), is(2));
    }

    @Test
    public void testIterator() throws Exception {
        Iterator<Integer> iterator = _.on(Arrays.asList(1, 2, 3, 4, 5)).iterator();
        while (iterator.hasNext()) {
            assertTrue(iterator.next() >= 1);
        }
    }
}
