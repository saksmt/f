package run.smt.f.definition.predicate;

import org.junit.Test;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public class Predicate1Test extends PredicateTest {
    private static final Predicate1<Object> T = T1;
    private static final Predicate1<Object> F = F1;

    @Test
    public void testNegate() throws Exception {
        assertFalse(T.negate());
    }

    @Test
    public void testOr() throws Exception {
        assertFalse(F.or(F0));
        assertTrue (F.or(T0));
        assertTrue (T.or(F0));
        assertTrue (T.or(T0));
    }

    @Test
    public void testOr1() throws Exception {
        assertFalse(F.or(F1));
        assertTrue (F.or(T1));
        assertTrue (T.or(F1));
        assertTrue (T.or(T1));
    }

    @Test
    public void testOr2() throws Exception {
        assertFalse(F.or(F2));
        assertTrue (F.or(T2));
        assertTrue (T.or(F2));
        assertTrue (T.or(T2));
    }

    @Test
    public void testAnd() throws Exception {
        assertFalse(F.and(F0));
        assertFalse(F.and(T0));
        assertFalse(T.and(F0));
        assertTrue (T.and(T0));
    }

    @Test
    public void testAnd1() throws Exception {
        assertFalse(F.and(F1));
        assertFalse(F.and(T1));
        assertFalse(T.and(F1));
        assertTrue (T.and(T1));
    }

    @Test
    public void testAnd2() throws Exception {
        assertFalse(F.and(F2));
        assertFalse(F.and(T2));
        assertFalse(T.and(F2));
        assertTrue (T.and(T2));
    }

    @Test
    public void testXor() throws Exception {
        assertFalse(F.xor(F0));
        assertTrue (F.xor(T0));
        assertTrue (T.xor(F0));
        assertFalse(T.xor(T0));
    }

    @Test
    public void testXor1() throws Exception {
        assertFalse(F.xor(F1));
        assertTrue (F.xor(T1));
        assertTrue (T.xor(F1));
        assertFalse(T.xor(T1));
    }

    @Test
    public void testXor2() throws Exception {
        assertFalse(F.xor(F2));
        assertTrue (F.xor(T2));
        assertTrue (T.xor(F2));
        assertFalse(T.xor(T2));
    }

    @Test
    public void testImplies() throws Exception {
        assertTrue (F.implies(F0));
        assertTrue (F.implies(T0));
        assertFalse(T.implies(F0));
        assertTrue (T.implies(T0));
    }

    @Test
    public void testImplies1() throws Exception {
        assertTrue (F.implies(F1));
        assertTrue (F.implies(T1));
        assertFalse(T.implies(F1));
        assertTrue (T.implies(T1));
    }

    @Test
    public void testImplies2() throws Exception {
        assertTrue (F.implies(F2));
        assertTrue (F.implies(T2));
        assertFalse(T.implies(F2));
        assertTrue (T.implies(T2));
    }

    @Test
    public void testEquality() throws Exception {
        assertTrue (F.equality(F0));
        assertFalse(F.equality(T0));
        assertFalse(T.equality(F0));
        assertTrue (T.equality(T0));
    }

    @Test
    public void testEquality1() throws Exception {
        assertTrue (F.equality(F1));
        assertFalse(F.equality(T1));
        assertFalse(T.equality(F1));
        assertTrue (T.equality(T1));
    }

    @Test
    public void testEquality2() throws Exception {
        assertTrue (F.equality(F2));
        assertFalse(F.equality(T2));
        assertFalse(T.equality(F2));
        assertTrue (T.equality(T2));
    }
}