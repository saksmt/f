package run.smt.f.definition.function;

import run.smt.f.definition.procedure.Procedure1;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.Objects.requireNonNull;

/**
 * Represents function with one argument and a return value
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
@FunctionalInterface
public interface Function1<A, R> extends Function<A, R> {
    /**
     * Execute function
     */
    @Override
    R apply(A a);

    @Override
    default <RR> Function1<A, RR> andThen(Function<? super R, ? extends RR> g) {
        requireNonNull(g);
        return a -> g.apply(apply(a));
    }

    /**
     * Reverse functional composition
     */
    default Procedure1<A> andThen(Consumer<R> g) {
        requireNonNull(g);
        return a -> g.accept(apply(a));
    }

    /**
     * Functional composition
     */
    default Function0<R> compose(Supplier<A> f) {
        requireNonNull(f);
        return () -> apply(f.get());
    }

    @Override
    default <RR> Function1<RR, R> compose(Function<? super RR, ? extends A> g) {
        requireNonNull(g);
        return x -> apply(g.apply(x));
    }

    /**
     * Functional composition
     */
    default <AA, B> Function2<AA, B, R> compose(BiFunction<AA, B, A> g) {
        requireNonNull(g);
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
