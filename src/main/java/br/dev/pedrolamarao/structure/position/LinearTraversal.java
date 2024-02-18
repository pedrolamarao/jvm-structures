package br.dev.pedrolamarao.structure.position;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class LinearTraversal
{
    public static <T> int distance (LinearPosition<T> begin, LinearPosition<T> end)
    {
        int d = 0;
        for (var p = begin; p != end; p = p.next())
            d++;
        return d;
    }

    public static <T> LinearPosition<T> find (LinearPosition<T> begin, LinearPosition<T> end, Predicate<T> predicate)
    {
        for (var p = begin; p != end; p = p.next())
            if (predicate.test(p.value()))
                return p;
        return null;
    }

    public static <T> void forEach (LinearPosition<T> begin, LinearPosition<T> end, Consumer<T> consumer)
    {
        for (var p = begin; p != end; p = p.next())
            consumer.accept(p.value());
    }
}
