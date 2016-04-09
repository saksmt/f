package run.smt.f.definition.procedure;

import run.smt.f.definition.function.Function0;
import run.smt.f.definition.function.Function1;
import run.smt.f.definition.function.Function2;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
@FunctionalInterface
public interface Procedure1<A> {
    void apply(A a);

    default Procedure0 compose(Function0<A> g) {
        return () -> apply(g.apply());
    }

    default <AA> Procedure1<AA> compose(Function1<AA, A> g) {
        return (a) -> apply(g.apply(a));
    }

    default <AA, B> Procedure2<AA, B> compose(Function2<AA, B, A> g) {
        return (a, b) -> apply(g.apply(a, b));
    }


    default <B> Procedure2<A, B> expand() {
        return (a, b) -> apply(a);
    }

    default Procedure0 bind(A arg) {
        return () -> apply(arg);
    }

    default <R> Function1<A, R> provideReturn(R value) {
        return (a) -> {
            apply(a);
            return value;
        };
    }
}
