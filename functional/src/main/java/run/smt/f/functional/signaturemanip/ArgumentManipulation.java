package run.smt.f.functional.signaturemanip;

import run.smt.f.definition.function.Function0;
import run.smt.f.definition.function.Function1;
import run.smt.f.definition.function.Function2;
import run.smt.f.definition.procedure.Procedure0;
import run.smt.f.definition.procedure.Procedure1;
import run.smt.f.definition.procedure.Procedure2;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public interface ArgumentManipulation {
    static <A> Function0<?> bind(Function1<A, ?> f, A arg) {
        return f.bind(arg);
    }

    static <A, B> Function0<?> bind(Function2<A, B, ?> f, A a, B b) {
        return f.bind(a, b);
    }

    static <A, B> Function1<B, ?> bind(Function2<A, B, ?> f, A arg) {
        return f.bind(arg);
    }

    static <A, B> Function1<A, ?> bindLast(Function2<A, B, ?> f, B arg) {
        return f.bindLast(arg);
    }


    static <A> Procedure0 bind(Procedure1<A> f, A arg) {
        return f.bind(arg);
    }

    static <A, B> Procedure0 bind(Procedure2<A, B> f, A a, B b) {
        return f.bind(a, b);
    }

    static <A, B> Procedure1<B> bind(Procedure2<A, B> f, A arg) {
        return f.bind(arg);
    }

    static <A, B> Procedure1<A> bindLast(Procedure2<A, B> f, B arg) {
        return f.bindLast(arg);
    }


    static <A> Function1<A, ?> expand(Function0<?> f) {
        return f.expand();
    }

    static <A, B> Function2<A, B, ?> expand(Function1<A, ?> f) {
        return f.expand();
    }


    static <A> Procedure1<A> expand(Procedure0 f) {
        return f.expand();
    }

    static <A, B> Procedure2<A, B> expand(Procedure1<A> f) {
        return f.expand();
    }


    static <A, B> Procedure2<B, A> flip(Procedure2<A, B> f) {
        return f.flip();
    }

    static <A, B> Function2<B, A, ?> flip(Function2<A, B, ?> f) {
        return f.flip();
    }
}
