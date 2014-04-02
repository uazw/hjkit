package net.kimleo.hjk.collect;

import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class MapKitTest {
    @Test
    public void testBuildMapFromArrays() throws Exception {
        Map<String, Integer> strIntMap = MapKit.from(new String[]{"a", "b", "c"}, new Integer[]{1, 2, 3}).asMap();
        assertThat(strIntMap.get("a"), is(1));
    }

    @Test
    public void testBuildMapFromInequalLengthArrays() throws Exception {
        Map<String, Integer> strIntMap = MapKit.from(new String[]{"a", "b", "c"}, new Integer[]{1, 2}).asMap();
        assertNull(strIntMap.get("c"));
        assertTrue(strIntMap.keySet().contains("c"));
    }
}
