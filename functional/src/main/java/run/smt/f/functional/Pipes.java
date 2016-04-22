package run.smt.f.functional;

import run.smt.f.definition.function.Function0;
import run.smt.f.definition.function.Function1;
import run.smt.f.definition.function.Function2;
import run.smt.f.definition.procedure.Procedure0;
import run.smt.f.definition.procedure.Procedure1;
import run.smt.f.definition.procedure.Procedure2;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static run.smt.f.functional.Cast.f;

/**
 * Contains combinations for reverse functional composition (piping)
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public interface Pipes {
    static <R, RR> Function0<RR> pipe(Supplier<R> f, Function<R, RR> g) {
        return f(f).andThen(g);
    }

    static <R> Procedure0 pipe(Supplier<R> f, Consumer<R> g) {
        return f(f).andThen(g);
    }

    static <A, R, RR> Function1<A, RR> pipe(Function<A, R> f, Function<R, RR> g) {
        return f(f).andThen(g);
    }

    static <A, R> Procedure1<A> pipe(Function<A, R> f, Consumer<R> g) {
        return f(f).andThen(g);
    }

    static <A, B, R, RR> Function2<A, B, RR> pipe(BiFunction<A, B, R> f, Function<R, RR> g) {
        return f(f).andThen(g);
    }

    static <A, B, R> Procedure2<A, B> pipe(BiFunction<A, B, R> f, Consumer<R> g) {
        return f(f).andThen(g);
    }
}
