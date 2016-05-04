package run.smt.f.functional;

import run.smt.f.definition.function.Function0;
import run.smt.f.definition.function.Function1;
import run.smt.f.definition.function.Function2;
import run.smt.f.definition.procedure.Procedure0;
import run.smt.f.definition.procedure.Procedure1;
import run.smt.f.definition.procedure.Procedure2;

import java.util.function.*;

/**
 * Class for simple cast of functions, especially useful for method references
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public interface Cast {
    static <R> Function0<R> f(Supplier<R> f) {
        if (f instanceof Function0) {
            return (Function0<R>) f;
        }
        return f::get;
    }

    static <A, R> Function1<A, R> f(Function<A, R> f) {
        if (f instanceof Function1) {
            return (Function1<A, R>) f;
        }
        return f::apply;
    }

    static <A, B, R> Function2<A, B, R> f(BiFunction<A, B, R> f) {
        if (f instanceof Function2) {
            return (Function2<A, B, R>) f;
        }
        return f::apply;
    }


    static Procedure0 f(Runnable f) {
        if (f instanceof Procedure0) {
            return (Procedure0) f;
        }
        return f::run;
    }

    static <A> Procedure1<A> f(Consumer<A> f) {
        if (f instanceof Procedure1) {
            return (Procedure1<A>) f;
        }
        return f::accept;
    }

    static <A, B> Procedure2<A, B> f(BiConsumer<A, B> f) {
        if (f instanceof Procedure2) {
            return (Procedure2<A, B>) f;
        }
        return f::accept;
    }
}
