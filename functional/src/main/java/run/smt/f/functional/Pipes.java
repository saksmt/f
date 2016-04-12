package run.smt.f.functional;

import run.smt.f.definition.function.Function0;
import run.smt.f.definition.function.Function1;
import run.smt.f.definition.function.Function2;
import run.smt.f.definition.procedure.Procedure0;
import run.smt.f.definition.procedure.Procedure1;
import run.smt.f.definition.procedure.Procedure2;

/**
 * Contains combinations for reverse functional composition (piping)
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public interface Pipes {
    static <R, RR> Function0<RR> pipe(Function0<R> f, Function1<R, RR> g) {
        return f.andThen(g);
    }

    static <R> Procedure0 pipe(Function0<R> f, Procedure1<R> g) {
        return f.andThen(g);
    }

    static <A, R, RR> Function1<A, RR> pipe(Function1<A, R> f, Function1<R, RR> g) {
        return f.andThen(g);
    }

    static <A, R> Procedure1<A> pipe(Function1<A, R> f, Procedure1<R> g) {
        return f.andThen(g);
    }

    static <A, B, R, RR> Function2<A, B, RR> pipe(Function2<A, B, R> f, Function1<R, RR> g) {
        return f.andThen(g);
    }

    static <A, B, R> Procedure2<A, B> pipe(Function2<A, B, R> f, Procedure1<R> g) {
        return f.andThen(g);
    }
}
