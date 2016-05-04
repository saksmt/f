package run.smt.f.definition.function;

import run.smt.f.definition.procedure.Procedure0;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.Objects.requireNonNull;

/**
 * Represents function with no arguments and a return value
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
@FunctionalInterface
public interface Function0<R> extends Supplier<R> {
    @Override
    default R get() {
        return apply();
    }

    /**
     * Executes function
     */
    R apply();

    /**
     * Reverse functional composition
     */
    default <RR> Function0<RR> andThen(Function<? super R, ? extends RR> g) {
        requireNonNull(g);
        return () -> g.apply(apply());
    }

    /**
     * Reverse functional composition
     */
    default Procedure0 andThen(Consumer<? super R> g) {
        requireNonNull(g);
        return () -> g.accept(apply());
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
