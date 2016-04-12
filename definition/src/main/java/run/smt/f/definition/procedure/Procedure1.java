package run.smt.f.definition.procedure;

import run.smt.f.definition.function.Function0;
import run.smt.f.definition.function.Function1;
import run.smt.f.definition.function.Function2;

/**
 * Represents function taking one argument and returning no value
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
@FunctionalInterface
public interface Procedure1<A> {
    /**
     * Execute function
     */
    void apply(A a);

    /**
     * Functional composition
     */
    default Procedure0 compose(Function0<A> g) {
        return () -> apply(g.apply());
    }

    /**
     * Functional composition
     */
    default <AA> Procedure1<AA> compose(Function1<AA, A> g) {
        return a -> apply(g.apply(a));
    }

    /**
     * Functional composition
     */
    default <AA, B> Procedure2<AA, B> compose(Function2<AA, B, A> g) {
        return (a, b) -> apply(g.apply(a, b));
    }

    /**
     * Expand this function to take one more argument, which would be ignored
     */
    default <B> Procedure2<A, B> expand() {
        return (a, b) -> apply(a);
    }

    /**
     * Bind argument to specified one (explicit carrying)
     */
    default Procedure0 bind(A arg) {
        return () -> apply(arg);
    }

    /**
     * Provide constant return value for this function
     */
    default <R> Function1<A, R> provideReturn(R value) {
        return a -> {
            apply(a);
            return value;
        };
    }

    /**
     * Identity function taking one argument and returning no value
     */
    static <A> Procedure1<A> identity() {
        return a -> {};
    }
}
