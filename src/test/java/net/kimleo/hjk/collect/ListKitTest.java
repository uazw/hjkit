package net.kimleo.hjk.collect;

import net.kimleo.hjk._;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ListKitTest {
    @Test
    public void testMap() throws Exception {
        List<Integer> map = IterKit.map(x -> x + 1, Arrays.asList(1, 2, 3, 4)).asList();
        assertThat(map.get(0), is(2));
    }

    @Test
    public void test_InDifferentPackages() throws Exception {
        Integer reduced = _.on(Arrays.asList(1, 2, 3, 4, 5)).filter(x -> x % 2 == 0).reduce(0, (m, n) -> m + n);
        assertThat(reduced, is(6));
    }

    @Test
    public void testReduce() throws Exception {
        Integer reducedValue = IterKit.reduce(Arrays.asList(1, 2, 3, 4, 5), 0, (m, n) -> m + n);
        assertThat(reducedValue, is(15));
    }
}
