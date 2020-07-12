package com.github.paulosalonso.spel.builder;

import com.github.paulosalonso.spel.builder.common.Expression;
import org.junit.Assert;
import org.junit.Test;

import static com.github.paulosalonso.spel.builder.IsAuthenticated.isAuthenticated;
import static org.junit.Assert.assertEquals;

public class ToStringTest {

    @Test
    public void testToString() {
        Expression spel = isAuthenticated();
        assertEquals(spel.build(), spel.toString());
    }
}
