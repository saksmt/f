package run.smt.f.functional;

import run.smt.f.definition.function.Function0;
import run.smt.f.definition.function.Function1;
import run.smt.f.definition.function.Function2;
import run.smt.f.definition.procedure.Procedure0;
import run.smt.f.definition.procedure.Procedure1;
import run.smt.f.definition.procedure.Procedure2;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public interface Cast {
    static <R> Function0<R> f(Function0<R> f) {
        return f;
    }

    static <A, R> Function1<A, R> f(Function1<A, R> f) {
        return f;
    }

    static <A, B, R> Function2<A, B, R> f(Function2<A, B, R> f) {
        return f;
    }


    static Procedure0 f(Procedure0 f) {
        return f;
    }

    static <A> Procedure1<A> f(Procedure1<A> f) {
        return f;
    }

    static <A, B> Procedure2<A, B> f(Procedure2<A, B> f) {
        return f;
    }
}
