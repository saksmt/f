package run.smt.f.definition.function;

import run.smt.f.definition.procedure.Procedure1;
import run.smt.f.definition.procedure.Procedure2;

/**
 * Represents function taking 2 arguments and returning a value
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
@FunctionalInterface
public interface Function2<A, B, R> {
    /**
     * Executes function
     */
    R apply(A a, B b);

    /**
     * Functional composition for left argument
     */
    default <AA> Function2<AA, B, R> composeLeft(Function2<AA, B, A> g) {
        return (a, b) -> apply(g.apply(a, b), b);
    }

    /**
     * Functional composition for right argument
     */
    default <BB> Function2<A, BB, R> composeRight(Function2<A, BB, B> g) {
        return (a, b) -> apply(a, g.apply(a, b));
    }

    /**
     * Functional composition
     */
    default <AA, BB> Function2<AA, BB, R> compose(Function1<AA, A> gA, Function1<BB, B> gB) {
        return (a, b) -> apply(gA.apply(a), gB.apply(b));
    }

    /**
     * Functional composition
     */
    default <AA> Function1<AA, R> compose(Function1<AA, A> gA, Function0<B> gB) {
        return (a) -> apply(gA.apply(a), gB.apply());
    }

    /**
     * Functional composition
     */
    default <BB> Function1<BB, R> compose(Function0<A> gB, Function1<BB, B> gA) {
        return (a) -> apply(gB.apply(), gA.apply(a));
    }

    /**
     * Functional composition
     */
    default Function0<R> compose(Function0<A> gA, Function0<B> gB) {
        return () -> apply(gA.apply(), gB.apply());
    }


    /**
     * Reverse functional composition
     */
    default <RR> Function2<A, B, RR> andThen(Function1<R, RR> g) {
        return (a, b) -> g.apply(apply(a, b));
    }

    /**
     * Reverse functional composition
     */
    default Procedure2<A, B> andThen(Procedure1<R> g) {
        return (a, b) -> g.apply(apply(a, b));
    }

    /**
     * Reverse functional composition for right argument
     */
    default Procedure2<A, B> andThenRight(Procedure2<A, R> g) {
        return (a, b) -> g.apply(a, apply(a, b));
    }

    /**
     * Reverse functional composition for left argument
     */
    default Procedure2<A, B> andThenLeft(Procedure2<R, B> g) {
        return (a, b) -> g.apply(apply(a, b), b);
    }

    /**
     * Reverse functional composition for right argument
     */
    default <RR> Function2<A, B, RR> andThenRight(Function2<A, R, RR> g) {
        return (a, b) -> g.apply(a, apply(a, b));
    }

    /**
     * Reverse functional composition for left argument
     */
    default <RR> Function2<A, B, RR> andThenLeft(Function2<R, B, RR> g) {
        return (a, b) -> g.apply(apply(a, b), b);
    }

    /**
     * Flip arguments for this function
     */
    default Function2<B, A, R> flip() {
        return (b, a) -> apply(a, b);
    }

    /**
     * Bind left argument to specified one (explicit carrying)
     */
    default Function1<B, R> bind(A arg) {
        return b -> apply(arg, b);
    }

    /**
     * Bind right argument to specified one (explicit reverse carrying)
     */
    default Function1<A, R> bindLast(B arg) {
        return a -> apply(a, arg);
    }

    /**
     * Bind all arguments to specified ones
     */
    default Function0<R> bind(A a, B b) {
        return () -> apply(a, b);
    }

    /**
     * Suppress return for this function, transforming it to a procedure
     */
    default Procedure2<A, B> suppressReturn() {
        return this::apply;
    }

    /**
     * Represent constant as function
     */
    static <A, B, R> Function2<A, B, R> constant(R returnValue) {
        return (a, b) -> returnValue;
    }

    /**
     * Identity function with 2 arguments and return value (returns left argument)
     */
    static <A, B> Function2<A, B, A> leftIdentity() {
        return (a, b) -> a;
    }

    /**
     * Identity function with 2 arguments and return value (returns right argument)
     */
    static <A, B> Function2<A, B, B> rightIdentity() {
        return (a, b) -> b;
    }

    /**
     * Identity function with 2 arguments and null return value
     */
    static <A, B, R> Function2<A, B, R> identity() {
        return (a, b) -> null;
    }
}
