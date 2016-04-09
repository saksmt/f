package run.smt.f;

import run.smt.f.definition.function.Function0;
import run.smt.f.definition.function.Function1;
import run.smt.f.definition.function.Function2;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public final class TestData {
    public static final Integer TEST_ARG0 = 10;
    public static final Integer TEST_ARG1 = 5;

    public static final Function0<Integer> F0_0 = () -> 56;
    public static final Function0<Integer> F0_1 = () -> 37;
    public static final Function1<Integer, Integer> F1_0 = (a) -> a + 1;
    public static final Function1<Integer, Integer> F1_1 = (a) -> a / 2;
    public static final Function2<Integer, Integer, Integer> F2_0 = (a, b) -> a + b;
    public static final Function2<Integer, Integer, Integer> F2_1 = (a, b) -> a + b;

    private TestData() {
    }
}
