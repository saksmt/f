package run.smt.f.definition.procedure;

import run.smt.f.definition.function.Function2;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.Objects.requireNonNull;

/**
 * Represents function taking 2 arguments and returning no value
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
@FunctionalInterface
public interface Procedure2<A, B> extends BiConsumer<A, B> {
    @Override
    default void accept(A a, B b) {
        apply(a, b);
    }

    /**
     * Execute function
     */
    void apply(A a, B b);



    /**
     * Functional composition
     */
    default <AA, BB> Procedure2<AA, BB> compose(Function<AA, A> gA, Function<BB, B> gB) {
        requireNonNull(gA);
        requireNonNull(gB);
        return (a, b) -> apply(gA.apply(a), gB.apply(b));
    }

    /**
     * Functional composition
     */
    default <BB> Procedure1<BB> compose(Supplier<A> gA, Function<BB, B> gB) {
        requireNonNull(gA);
        requireNonNull(gB);
        return b -> apply(gA.get(), gB.apply(b));
    }

    /**
     * Functional composition
     */
    default <AA> Procedure1<AA> compose(Function<AA, A> gA, Supplier<B> gB) {
        requireNonNull(gA);
        requireNonNull(gB);
        return b -> apply(gA.apply(b), gB.get());
    }

    /**
     * Functional composition
     */
    default Procedure0 compose(Supplier<A> gA, Supplier<B> gB) {
        requireNonNull(gA);
        requireNonNull(gB);
        return () -> apply(gA.get(), gB.get());
    }

    /**
     * Functional composition for right argument
     */
    default <BB> Procedure2<A, BB> composeRight(BiFunction<A, BB, B> g) {
        requireNonNull(g);
        return (a, b) -> apply(a, g.apply(a, b));
    }

    /**
     * Functional composition for left argument
     */
    default <AA> Procedure2<AA, B> composeLeft(BiFunction<AA, B, A> g) {
        requireNonNull(g);
        return (a, b) -> apply(g.apply(a, b), b);
    }

    /**
     * Flip arguments for this function
     */
    default Procedure2<B, A> flip() {
        return (b, a) -> apply(a, b);
    }

    /**
     * Bind left argument for this function (explicit carrying)
     */
    default Procedure1<B> bind(A arg) {
        return b -> apply(arg, b);
    }

    /**
     * Bind right argument for this function (explicit reverse carrying)
     */
    default Procedure1<A> bindLast(B arg) {
        return a -> apply(a, arg);
    }

    /**
     * Bind all arguments for this function
     */
    default Procedure0 bind(A a, B b) {
        return () -> apply(a, b);
    }

    /**
     * Provide constant return value for this function
     */
    default <R> Function2<A, B, R> provideReturn(R value) {
        return (a, b) -> {
            apply(a, b);
            return value;
        };
    }

    /**
     * Identity function taking 2 arguments and returning no value
     */
    static <A, B> Procedure2<A, B> identity() {
        return (a, b) -> {};
    }
}
