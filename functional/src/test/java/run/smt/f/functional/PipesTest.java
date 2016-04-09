package run.smt.f.functional;

import org.junit.Assert;
import org.junit.Test;
import run.smt.f.tester.procedure.Procedure1Tester;

import static run.smt.f.TestData.*;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public class PipesTest {

    @Test
    public void pipeF0toF1() throws Exception {
        Assert.assertEquals(
            F0_0.andThen(F1_0).apply(),
            Pipes.pipe(F0_0, F1_0).apply()
        );
    }

    @Test
    public void pipeF1toF1() throws Exception {
        Assert.assertEquals(
            F1_0.andThen(F1_1).apply(TEST_ARG0),
            Pipes.pipe(F1_0, F1_1).apply(TEST_ARG0)
        );
    }

    @Test
    public void pipeF2toF1() throws Exception {
        Assert.assertEquals(
            F2_0.andThen(F1_0).apply(TEST_ARG0, TEST_ARG1),
            Pipes.pipe(F2_0, F1_0).apply(TEST_ARG0, TEST_ARG1)
        );
    }

    @Test
    public void pipeF0toP1() throws Exception {
        Procedure1Tester<Integer> tester = new Procedure1Tester<>();
        F0_0.andThen(tester.getTestable()).apply();
        Pipes.pipe(F0_0, tester.getTestable()).apply();
        tester.verifyCalls();
    }

    @Test
    public void pipeF1toP1() throws Exception {
        Procedure1Tester<Integer> tester = new Procedure1Tester<>();
        F1_0.andThen(tester.getTestable()).apply(TEST_ARG0);
        Pipes.pipe(F1_0, tester.getTestable()).apply(TEST_ARG0);
        tester.verifyCalls();
    }

    @Test
    public void pipeF2toP1() throws Exception {
        Procedure1Tester<Integer> tester = new Procedure1Tester<>();
        F2_0.andThen(tester.getTestable()).apply(TEST_ARG0, TEST_ARG1);
        Pipes.pipe(F2_0, tester.getTestable()).apply(TEST_ARG0, TEST_ARG1);
        tester.verifyCalls();
    }
}