package com.github.paulosalonso.spel.builder;

import org.junit.Test;

import static com.github.paulosalonso.spel.builder.AnyEnum.ENUM_CONSTANT_A;
import static com.github.paulosalonso.spel.builder.HasAuthority.hasAuthority;
import static com.github.paulosalonso.spel.builder.HasRole.hasRole;
import static com.github.paulosalonso.spel.builder.HasScope.hasScope;
import static com.github.paulosalonso.spel.builder.IsAuthenticated.isAuthenticated;
import static org.junit.Assert.assertEquals;

public class BuiltInExpressionsTest {

    @Test
    public void testIsAuthenticatedBuild() {
        String spel = isAuthenticated().build();
        assertEquals("isAuthenticated()", spel);
    }

    @Test
    public void testHasAuthorityWithStringBuild() {
        String spel = hasAuthority("ADMIN").build();
        assertEquals("hasAuthority('ADMIN')", spel);
    }

    @Test
    public void testHasAuthorityWithEnumBuild() {
        String spel = hasAuthority(ENUM_CONSTANT_A).build();
        assertEquals("hasAuthority('ENUM_CONSTANT_A')", spel);
    }

    @Test
    public void testHasRoleWithStringBuild() {
        String spel = hasRole("ADMIN").build();
        assertEquals("hasRole('ADMIN')", spel);
    }

    @Test
    public void testHasRoleWithEnumBuild() {
        String spel = hasRole(ENUM_CONSTANT_A).build();
        assertEquals("hasRole('ENUM_CONSTANT_A')", spel);
    }

    @Test
    public void testHasScopeWithStringBuild() {
        String spel = hasScope("WRITE").build();
        assertEquals("hasScope('WRITE')", spel);
    }

    @Test
    public void testHasScopeWithEnumBuild() {
        String spel = hasScope(ENUM_CONSTANT_A).build();
        assertEquals("hasScope('ENUM_CONSTANT_A')", spel);
    }
}
