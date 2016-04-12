package run.smt.f.definition.function;

import run.smt.f.definition.procedure.Procedure0;
import run.smt.f.definition.procedure.Procedure1;

/**
 * Represents function with no arguments and a return value
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
@FunctionalInterface
public interface Function0<R> {
    /**
     * Executes function
     */
    R apply();

    /**
     * Reverse functional composition
     */
    default <RR> Function0<RR> andThen(Function1<R, RR> g) {
        return () -> g.apply(apply());
    }

    /**
     * Reverse functional composition
     */
    default Procedure0 andThen(Procedure1<R> g) {
        return () -> g.apply(apply());
    }

    /**
     * Suppress return for this function, transforming it to a procedure
     */
    default Procedure0 suppressReturn() {
        return this::apply;
    }

    /**
     * Expand this function to take one argument, which would be ignored
     */
    default <A> Function1<A, R> expand() {
        return a -> apply();
    }

    /**
     * Represent constant as function
     */
    static <R> Function0<R> constant(R returnValue) {
        return () -> returnValue;
    }

    /**
     * Identity function with no arguments and a null return value
     */
    static <R> Function0<R> identity() {
        return () -> null;
    }
}
