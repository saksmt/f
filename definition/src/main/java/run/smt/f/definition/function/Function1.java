package run.smt.f.definition.function;

import run.smt.f.definition.procedure.Procedure1;

/**
 * Represents function with one argument and a return value
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
@FunctionalInterface
public interface Function1<A, R> {
    /**
     * Execute function
     */
    R apply(A a);

    /**
     * Reverse functional composition
     */
    default <RR> Function1<A, RR> andThen(Function1<R, RR> g) {
        return a -> g.apply(apply(a));
    }

    /**
     * Reverse functional composition
     */
    default Procedure1<A> andThen(Procedure1<R> g) {
        return a -> g.apply(apply(a));
    }

    /**
     * Functional composition
     */
    default Function0<R> compose(Function0<A> f) {
        return () -> apply(f.apply());
    }

    /**
     * Functional composition
     */
    default <AA> Function1<AA, R> compose(Function1<AA, A> g) {
        return x -> apply(g.apply(x));
    }

    /**
     * Functional composition
     */
    default <AA, B> Function2<AA, B, R> compose(Function2<AA, B, A> g) {
        return (a, b) -> apply(g.apply(a, b));
    }


    /**
     * Bind specified argument to this function
     * <p>
     *     Transforms this function to function taking no arguments.
     *     You can this about as of explicit carrying
     * </p>
     */
    default Function0<R> bind(A arg) {
        return () -> apply(arg);
    }

    /**
     * Expand this function to take one more argument which would be ignored
     */
    default <B> Function2<A, B, R> expand() {
        return (a, b) -> apply(a);
    }

    /**
     * Suppress return for this function, transforming it to a procedure
     */
    default Procedure1<A> suppressReturn() {
        return this::apply;
    }

    /**
     * Represent constant as function
     */
    static <A, R> Function1<A, R> constant(R returnValue) {
        return a -> returnValue;
    }

    /**
     * Identity function with one argument and return value (returns same as takes)
     */
    static <A> Function1<A, A> identity() {
        return a -> a;
    }
}
