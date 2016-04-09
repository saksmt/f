package run.smt.f.functional.signaturemanip;

import org.junit.Assert;
import org.junit.Test;
import run.smt.f.definition.function.Function0;
import run.smt.f.definition.function.Function1;
import run.smt.f.definition.function.Function2;
import run.smt.f.tester.procedure.Procedure0Tester;
import run.smt.f.tester.procedure.Procedure1Tester;
import run.smt.f.tester.procedure.Procedure2Tester;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public class ArgumentManipulationTest {
    private static final String TEST_ARG1 = "testArg1";
    private static final String TEST_ARG2 = "testArg2";

    private static final Function0<Object> F0 = () -> TEST_ARG1;
    private static final Function1<Object, Object> F1 = (a) -> a;
    private static final Function2<Object, Object, Object> F2 = (a, b) -> a;

    @Test
    public void testBindF1() throws Exception {
        Assert.assertEquals(F1.bind(TEST_ARG1).apply(), ArgumentManipulation.bind(F1, TEST_ARG1).apply());
    }

    @Test
    public void testBindF2() throws Exception {
        Assert.assertEquals(F2.bind(TEST_ARG1).apply(TEST_ARG2), ArgumentManipulation.bind(F2, TEST_ARG1).apply(TEST_ARG2));
    }

    @Test
    public void testBindLastF2() throws Exception {
        Assert.assertEquals(F2.bindLast(TEST_ARG1).apply(TEST_ARG2), ArgumentManipulation.bindLast(F2, TEST_ARG1).apply(TEST_ARG2));
    }

    @Test
    public void testBindF2All() throws Exception {
        Assert.assertEquals(F2.bind(TEST_ARG1, TEST_ARG2).apply(), ArgumentManipulation.bind(F2, TEST_ARG1, TEST_ARG2).apply());
    }

    @Test
    public void testBindP1() throws Exception {
        Procedure1Tester tester = new Procedure1Tester();
        tester.getTestable().bind(TEST_ARG1).apply();
        ArgumentManipulation.bind(tester.getTestable(), TEST_ARG1).apply();
        tester.verifyCalls();
    }

    @Test
    public void testBindP2() throws Exception {
        Procedure2Tester tester = new Procedure2Tester();
        tester.getTestable().bind(TEST_ARG1).apply(TEST_ARG2);
        ArgumentManipulation.bind(tester.getTestable(), TEST_ARG1).apply(TEST_ARG2);
        tester.verifyCalls();
    }

    @Test
    public void testBindLastP2() throws Exception {
        Procedure2Tester tester = new Procedure2Tester();
        tester.getTestable().bindLast(TEST_ARG1).apply(TEST_ARG2);
        ArgumentManipulation.bindLast(tester.getTestable(), TEST_ARG1).apply(TEST_ARG2);
        tester.verifyCalls();
    }

    @Test
    public void testBindP2All() throws Exception {
        Procedure2Tester tester = new Procedure2Tester();
        tester.getTestable().bind(TEST_ARG1, TEST_ARG2).apply();
        ArgumentManipulation.bind(tester.getTestable(), TEST_ARG1, TEST_ARG2).apply();
        tester.verifyCalls();
    }

    @Test
    public void testExpandF0() throws Exception {
        Assert.assertEquals(F0.expand().apply(TEST_ARG2), ArgumentManipulation.expand(F0).apply(TEST_ARG2));
    }

    @Test
    public void testExpandF1() throws Exception {
        Assert.assertEquals(F1.expand().apply(TEST_ARG1, TEST_ARG2), ArgumentManipulation.expand(F1).apply(TEST_ARG1, TEST_ARG2));
    }

    @Test
    public void testExpandP0() throws Exception {
        Procedure0Tester tester = new Procedure0Tester();
        tester.getTestable().expand().apply(TEST_ARG1);
        ArgumentManipulation.expand(tester.getTestable()).apply(TEST_ARG1);
        tester.assertCallCount(2);
    }

    @Test
    public void testExpandP1() throws Exception {
        Procedure1Tester tester = new Procedure1Tester();
        tester.getTestable().expand().apply(TEST_ARG1, TEST_ARG2);
        ArgumentManipulation.expand(tester.getTestable()).apply(TEST_ARG1, TEST_ARG2);
        tester.verifyCalls();
    }

    @Test
    public void testFlipF() throws Exception {
        Assert.assertEquals(F2.flip().apply(TEST_ARG1, TEST_ARG2), ArgumentManipulation.flip(F2).apply(TEST_ARG1, TEST_ARG2));
    }

    @Test
    public void testFlipP() throws Exception {
        Procedure2Tester tester = new Procedure2Tester();
        tester.getTestable().flip().apply(TEST_ARG1, TEST_ARG2);
        ArgumentManipulation.flip(tester.getTestable()).apply(TEST_ARG1, TEST_ARG2);
        tester.verifyCalls();
    }
}