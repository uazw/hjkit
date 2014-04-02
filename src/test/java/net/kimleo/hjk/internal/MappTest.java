package net.kimleo.hjk.internal;

import net.kimleo.hjk.collect.MapKit;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MappTest {
    @Test
    public void testIter() throws Exception {
        Iter<Map.Entry<Integer, Integer>> iter = MapKit.<Integer, Integer>from(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6)).iter();
        assertThat(iter.map(m -> m.getKey() + m.getValue()).<Integer>reduce(0, (x, y) -> x + y), is(21));
    }
}
