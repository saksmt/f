package run.smt.f.functional;

import org.junit.Assert;
import org.junit.Test;
import run.smt.f.tester.procedure.Procedure1Tester;
import run.smt.f.tester.procedure.Procedure2Tester;

import static run.smt.f.TestData.*;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public class CompositionTest {

    @Test
    public void testComposeF1andF0() throws Exception {
        Assert.assertEquals(
            F1_0.compose(F0_0).apply(),
            Composition.compose(F1_0, F0_0).apply()
        );
    }

    @Test
    public void testComposeF1andF1() throws Exception {
        Assert.assertEquals(
            F1_0.compose(F1_1).apply(TEST_ARG0),
            Composition.compose(F1_0, F1_1).apply(TEST_ARG0)
        );
    }

    @Test
    public void testComposeF1andF2() throws Exception {
        Assert.assertEquals(
            F1_0.compose(F2_0).apply(TEST_ARG0, TEST_ARG1),
            Composition.compose(F1_0, F2_0).apply(TEST_ARG0, TEST_ARG1)
        );
    }

    @Test
    public void testComposeLeftF2() throws Exception {
        Assert.assertEquals(
            F2_0.composeLeft(F2_1).apply(TEST_ARG0, TEST_ARG1),
            Composition.composeLeft(F2_0, F2_1).apply(TEST_ARG0, TEST_ARG1)
        );
    }

    @Test
    public void testComposeRightF2() throws Exception {
        Assert.assertEquals(
            F2_0.composeRight(F2_1).apply(TEST_ARG0, TEST_ARG1),
            Composition.composeRight(F2_0, F2_1).apply(TEST_ARG0, TEST_ARG1)
        );
    }

    @Test
    public void testComposeF2andF0withF0() throws Exception {
        Assert.assertEquals(
            F2_0.compose(F0_0, F0_1).apply(),
            Composition.compose(F2_0, F0_0, F0_1).apply()
        );
    }

    @Test
    public void testComposeF2andF0withF1() throws Exception {
        Assert.assertEquals(
            F2_0.compose(F0_0, F1_0).apply(TEST_ARG0),
            Composition.compose(F2_0, F0_0, F1_0).apply(TEST_ARG0)
        );
    }

    @Test
    public void testComposeF2andF1withF0() throws Exception {
        Assert.assertEquals(
            F2_0.compose(F1_0, F0_0).apply(TEST_ARG0),
            Composition.compose(F2_0, F1_0, F0_0).apply(TEST_ARG0)
        );
    }

    @Test
    public void testComposeF2withF1andF1() throws Exception {
        Assert.assertEquals(
            F2_0.compose(F1_0, F1_1).apply(TEST_ARG0, TEST_ARG1),
            Composition.compose(F2_0, F1_0, F1_1).apply(TEST_ARG0, TEST_ARG1)
        );
    }

    @Test
    public void testComposeP1withF0() throws Exception {
        Procedure1Tester<Integer> tester = new Procedure1Tester<>();
        tester.getTestable().compose(F0_0).apply();
        Composition.compose(tester.getTestable(), F0_0).apply();
        tester.verifyCalls();
    }

    @Test
    public void testComposeP1withF1() throws Exception {
        Procedure1Tester<Integer> tester = new Procedure1Tester<>();
        tester.getTestable().compose(F1_0).apply(TEST_ARG0);
        Composition.compose(tester.getTestable(), F1_0).apply(TEST_ARG0);
        tester.verifyCalls();
    }

    @Test
    public void testComposeP1withF2() throws Exception {
        Procedure1Tester<Integer> tester = new Procedure1Tester<>();
        tester.getTestable().compose(F2_0).apply(TEST_ARG0, TEST_ARG1);
        Composition.compose(tester.getTestable(), F2_0).apply(TEST_ARG0, TEST_ARG1);
        tester.verifyCalls();
    }

    @Test
    public void testComposeP2withF0andF0() throws Exception {
        Procedure2Tester<Integer, Integer> tester = new Procedure2Tester<>();
        tester.getTestable().compose(F0_0, F0_1).apply();
        Composition.compose(tester.getTestable(), F0_0, F0_1).apply();
        tester.verifyCalls();
    }

    @Test
    public void testComposeP2withF0andF1() throws Exception {
        Procedure2Tester<Integer, Integer> tester = new Procedure2Tester<>();
        tester.getTestable().compose(F0_0, F1_0).apply(TEST_ARG0);
        Composition.compose(tester.getTestable(), F0_0, F1_0).apply(TEST_ARG0);
        tester.verifyCalls();
    }

    @Test
    public void testComposeP2withF1andF0() throws Exception {
        Procedure2Tester<Integer, Integer> tester = new Procedure2Tester<>();
        tester.getTestable().compose(F1_0, F0_0).apply(TEST_ARG0);
        Composition.compose(tester.getTestable(), F1_0, F0_0).apply(TEST_ARG0);
        tester.verifyCalls();
    }

    @Test
    public void testComposeP2withF1andF1() throws Exception {
        Procedure2Tester<Integer, Integer> tester = new Procedure2Tester<>();
        tester.getTestable().compose(F1_0, F1_1).apply(TEST_ARG0, TEST_ARG1);
        Composition.compose(tester.getTestable(), F1_0, F1_1).apply(TEST_ARG0, TEST_ARG1);
        tester.verifyCalls();
    }

    @Test
    public void testComposeRightP2() throws Exception {
        Procedure2Tester<Integer, Integer> tester = new Procedure2Tester<>();
        tester.getTestable().composeRight(F2_0).apply(TEST_ARG0, TEST_ARG1);
        Composition.composeRight(tester.getTestable(), F2_0).apply(TEST_ARG0, TEST_ARG1);
        tester.verifyCalls();
    }

    @Test
    public void testComposeLeftP2() throws Exception {
        Procedure2Tester<Integer, Integer> tester = new Procedure2Tester<>();
        tester.getTestable().composeLeft(F2_0).apply(TEST_ARG0, TEST_ARG1);
        Composition.composeLeft(tester.getTestable(), F2_0).apply(TEST_ARG0, TEST_ARG1);
        tester.verifyCalls();
    }
}