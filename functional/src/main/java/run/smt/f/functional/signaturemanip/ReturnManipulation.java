package run.smt.f.functional.signaturemanip;

import run.smt.f.definition.function.Function0;
import run.smt.f.definition.function.Function1;
import run.smt.f.definition.function.Function2;
import run.smt.f.definition.procedure.Procedure0;
import run.smt.f.definition.procedure.Procedure1;
import run.smt.f.definition.procedure.Procedure2;

import java.util.function.*;

import static run.smt.f.functional.Cast.f;

/**
 * Contains functions for providing and suppressing return of functions
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public interface ReturnManipulation {
    static <R> Function0<R> provideReturn(Runnable f, R value) {
        return f(f).provideReturn(value);
    }

    static <A, R> Function1<A, R> provideReturn(Consumer<A> f, R value) {
        return f(f).provideReturn(value);
    }

    static <A, B, R> Function2<A, B, R> provideReturn(BiConsumer<A, B> f, R value) {
        return f(f).provideReturn(value);
    }


    static Procedure0 suppressReturn(Supplier<?> f) {
        return f(f).suppressReturn();
    }

    static <A> Procedure1<A> suppressReturn(Function<A, ?> f) {
        return f(f).suppressReturn();
    }

    static <A, B> Procedure2<A, B> suppressReturn(BiFunction<A, B, ?> f) {
        return f(f).suppressReturn();
    }
}
