package run.smt.f.definition.function;

import run.smt.f.definition.procedure.Procedure1;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
@FunctionalInterface
public interface Function1<A, R> {
    R apply(A a);

    default <RR> Function1<A, RR> andThen(Function1<R, RR> g) {
        return (a) -> g.apply(apply(a));
    }

    default Procedure1<A> andThen(Procedure1<R> g) {
        return (a) -> g.apply(apply(a));
    }


    default Function0<R> compose(Function0<A> f) {
        return () -> apply(f.apply());
    }

    default <AA> Function1<AA, R> compose(Function1<AA, A> g) {
        return (x) -> apply(g.apply(x));
    }

    default <AA, B> Function2<AA, B, R> compose(Function2<AA, B, A> g) {
        return (a, b) -> apply(g.apply(a, b));
    }


    default Function0<R> bind(A arg) {
        return () -> apply(arg);
    }

    default <B> Function2<A, B, R> expand() {
        return (a, b) -> apply(a);
    }

    default Procedure1<A> suppressReturn() {
        return this::apply;
    }
}
