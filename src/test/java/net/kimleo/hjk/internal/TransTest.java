package net.kimleo.hjk.internal;

import net.kimleo.hjk.$;
import org.junit.Test;

import java.util.function.UnaryOperator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class TransTest {
    @Test
    public void testInject() throws Exception {
        String str = $.on(Object::toString).inject(x -> x + " is a String").apply(1);
        assertThat(str, is("1 is a String"));
    }

    @Test
    public void testInjectIdentity() throws Exception {
        String str1 = $.on(Object::toString).inject(UnaryOperator.identity()).apply(1);
        String str2 = $.on(Object::toString).apply(1);
        assertThat(str1, is(str2));
    }
}
