package run.smt.f.functional.signaturemanip;

import org.junit.Assert;
import run.smt.f.tester.function.Function0Tester;
import run.smt.f.tester.function.Function1Tester;
import run.smt.f.tester.function.Function2Tester;
import run.smt.f.tester.procedure.Procedure0Tester;
import run.smt.f.tester.procedure.Procedure1Tester;
import run.smt.f.tester.procedure.Procedure2Tester;

import org.junit.Test;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public class ReturnManipulationTest {
    private static final String TEST_DATA0 = "test0";
    private static final String TEST_DATA1 = "test1";
    private static final String TEST_DATA2 = "test2";

    @Test
    public void testProvideReturnP0() throws Exception {
        Procedure0Tester tester = new Procedure0Tester();
        Assert.assertEquals(
            tester.getTestable().provideReturn(TEST_DATA0).apply(),
            ReturnManipulation.provideReturn(tester.getTestable(), TEST_DATA0).apply()
        );
        tester.assertCallCount(2);
    }

    @Test
    public void testProvideReturnP1() throws Exception {
        Procedure1Tester tester = new Procedure1Tester();
        Assert.assertEquals(
            tester.getTestable().provideReturn(TEST_DATA0).apply(TEST_DATA1),
            ReturnManipulation.provideReturn(tester.getTestable(), TEST_DATA0).apply(TEST_DATA1)
        );
        tester.verifyCalls();
    }

    @Test
    public void testProvideReturnP2() throws Exception {
        Procedure2Tester tester = new Procedure2Tester();
        Assert.assertEquals(
            tester.getTestable().provideReturn(TEST_DATA0).apply(TEST_DATA1, TEST_DATA2),
            ReturnManipulation.provideReturn(tester.getTestable(), TEST_DATA0).apply(TEST_DATA1, TEST_DATA2)
        );
        tester.verifyCalls();
    }

    @Test
    public void testSuppressReturnF0() throws Exception {
        Function0Tester tester = new Function0Tester();
        tester.getTestable().suppressReturn().apply();
        ReturnManipulation.suppressReturn(tester.getTestable()).apply();
        tester.assertCallCount(2);
    }

    @Test
    public void testSuppressReturnF1() throws Exception {
        Function1Tester tester = new Function1Tester();
        tester.getTestable().suppressReturn().apply(TEST_DATA0);
        ReturnManipulation.suppressReturn(tester.getTestable()).apply(TEST_DATA0);
        tester.verifyCalls();
    }

    @Test
    public void testSuppressReturnF2() throws Exception {
        Function2Tester tester = new Function2Tester();
        tester.getTestable().suppressReturn().apply(TEST_DATA0, TEST_DATA1);
        ReturnManipulation.suppressReturn(tester.getTestable()).apply(TEST_DATA0, TEST_DATA1);
        tester.verifyCalls();
    }
}