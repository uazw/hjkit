package net.kimleo.hjk;

import net.kimleo.hjk.internal.Mapp;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class _Test {
    @Test
    public void testListWrapper() throws Exception {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> map = _.on(integers).map(x -> x).asList();
        for (int i = 0; i < integers.size(); i++) {
            assertThat(map.get(i), is(integers.get(i)));
        }
        assertThat((Integer) _.on(integers).reduce(0, (m, n) -> m + n), is(15));
    }

    @Test
    public void testMapWrapper() throws Exception {
        Mapp<String, Integer> entries = _.map(Arrays.asList("a", "b", "c"), Arrays.asList(1, 2));
        Mapp<String, Integer> entries1 = _.map(new String[]{"a", "b", "c"}, new Integer[]{1, 2, 3});
        assertNull(entries.get("c"));
        assertTrue(entries.get("a").equals(entries1.get("a")));
    }

}
