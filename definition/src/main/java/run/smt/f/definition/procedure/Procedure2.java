package run.smt.f.definition.procedure;

import run.smt.f.definition.function.Function0;
import run.smt.f.definition.function.Function2;
import run.smt.f.definition.function.Function1;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
@FunctionalInterface
public interface Procedure2<A, B> {
    void apply(A a, B b);

    default <AA, BB> Procedure2<AA, BB> compose(Function1<AA, A> gA, Function1<BB, B> gB) {
        return (a, b) -> apply(gA.apply(a), gB.apply(b));
    }

    default <BB> Procedure1<BB> compose(Function0<A> gA, Function1<BB, B> gB) {
        return (b) -> apply(gA.apply(), gB.apply(b));
    }

    default <AA> Procedure1<AA> compose(Function1<AA, A> gA, Function0<B> gB) {
        return (b) -> apply(gA.apply(b), gB.apply());
    }

    default Procedure0 compose(Function0<A> gA, Function0<B> gB) {
        return () -> apply(gA.apply(), gB.apply());
    }

    default <BB> Procedure2<A, BB> composeRight(Function2<A, BB, B> g) {
        return (a, b) -> apply(a, g.apply(a, b));
    }

    default <AA> Procedure2<AA, B> composeLeft(Function2<AA, B, A> g) {
        return (a, b) -> apply(g.apply(a, b), b);
    }


    default Procedure2<B, A> flip() {
        return (b, a) -> apply(a, b);
    }

    default Procedure1<B> bind(A arg) {
        return (b) -> apply(arg, b);
    }

    default Procedure1<A> bindLast(B arg) {
        return (a) -> apply(a, arg);
    }

    default Procedure0 bind(A a, B b) {
        return () -> apply(a, b);
    }

    default <R> Function2<A, B, R> provideReturn(R value) {
        return (a, b) -> {
            apply(a, b);
            return value;
        };
    }
}
