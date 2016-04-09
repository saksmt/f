package run.smt.f.definition.function;

import run.smt.f.definition.procedure.Procedure1;
import run.smt.f.definition.procedure.Procedure2;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
@FunctionalInterface
public interface Function2<A, B, R> {
    R apply(A a, B b);

    default <AA> Function2<AA, B, R> composeLeft(Function2<AA, B, A> g) {
        return (a, b) -> apply(g.apply(a, b), b);
    }

    default <BB> Function2<A, BB, R> composeRight(Function2<A, BB, B> g) {
        return (a, b) -> apply(a, g.apply(a, b));
    }

    default <AA, BB> Function2<AA, BB, R> compose(Function1<AA, A> gA, Function1<BB, B> gB) {
        return (a, b) -> apply(gA.apply(a), gB.apply(b));
    }

    default <AA> Function1<AA, R> compose(Function1<AA, A> gA, Function0<B> gB) {
        return (a) -> apply(gA.apply(a), gB.apply());
    }

    default <BB> Function1<BB, R> compose(Function0<A> gB, Function1<BB, B> gA) {
        return (a) -> apply(gB.apply(), gA.apply(a));
    }

    default Function0<R> compose(Function0<A> gA, Function0<B> gB) {
        return () -> apply(gA.apply(), gB.apply());
    }


    default <RR> Function2<A, B, RR> andThen(Function1<R, RR> g) {
        return (a, b) -> g.apply(apply(a, b));
    }

    default Procedure2<A, B> andThen(Procedure1<R> g) {
        return (a, b) -> g.apply(apply(a, b));
    }

    default Procedure2<A, B> andThenRight(Procedure2<A, R> g) {
        return (a, b) -> g.apply(a, apply(a, b));
    }

    default Procedure2<A, B> andThenLeft(Procedure2<R, B> g) {
        return (a, b) -> g.apply(apply(a, b), b);
    }

    default <RR> Function2<A, B, RR> andThenRight(Function2<A, R, RR> g) {
        return (a, b) -> g.apply(a, apply(a, b));
    }

    default <RR> Function2<A, B, RR> andThenLeft(Function2<R, B, RR> g) {
        return (a, b) -> g.apply(apply(a, b), b);
    }


    default Function2<B, A, R> flip() {
        return (b, a) -> apply(a, b);
    }

    default Function1<B, R> bind(A arg) {
        return (b) -> apply(arg, b);
    }

    default Function1<A, R> bindLast(B arg) {
        return (a) -> apply(a, arg);
    }

    default Function0<R> bind(A a, B b) {
        return () -> apply(a, b);
    }

    default Procedure2<A, B> suppressReturn() {
        return this::apply;
    }
}
