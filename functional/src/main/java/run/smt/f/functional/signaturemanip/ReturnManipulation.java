package run.smt.f.functional.signaturemanip;

import run.smt.f.definition.function.Function0;
import run.smt.f.definition.function.Function1;
import run.smt.f.definition.function.Function2;
import run.smt.f.definition.procedure.Procedure0;
import run.smt.f.definition.procedure.Procedure1;
import run.smt.f.definition.procedure.Procedure2;

/**
 * Contains functions for providing and suppressing return of functions
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public interface ReturnManipulation {
    static <R> Function0<R> provideReturn(Procedure0 f, R value) {
        return f.provideReturn(value);
    }

    static <A, R> Function1<A, R> provideReturn(Procedure1<A> f, R value) {
        return f.provideReturn(value);
    }

    static <A, B, R> Function2<A, B, R> provideReturn(Procedure2<A, B> f, R value) {
        return f.provideReturn(value);
    }


    static Procedure0 suppressReturn(Function0<?> f) {
        return f.suppressReturn();
    }

    static <A> Procedure1<A> suppressReturn(Function1<A, ?> f) {
        return f.suppressReturn();
    }

    static <A, B> Procedure2<A, B> suppressReturn(Function2<A, B, ?> f) {
        return f.suppressReturn();
    }
}
