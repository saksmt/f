package run.smt.f.definition.procedure;

import run.smt.f.definition.function.Function0;

/**
 * Represents function taking no arguments and returning no value
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
@FunctionalInterface
public interface Procedure0 extends Runnable {

    @Override
    default void run() {
        apply();
    }

    /**
     * Execute function
     */
    void apply();

    /**
     * Expand this function to take one argument, which would be ignored
     */
    default <A> Procedure1<A> expand() {
        return a -> apply();
    }

    /**
     * Provide constant return value for this function
     */
    default <R> Function0<R> provideReturn(R value) {
        return () -> {
            apply();
            return value;
        };
    }

    /**
     * Identity function with no arguments and returning no value
     */
    static Procedure0 identity() {
        return () -> {};
    }
}
