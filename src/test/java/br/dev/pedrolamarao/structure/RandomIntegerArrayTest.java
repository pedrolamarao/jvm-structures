package br.dev.pedrolamarao.structure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class RandomIntegerArrayTest
{
    static final int size = 1024 * 10;

    final Integer[] array = new Integer[size];

    @Test
    public void sort ()
    {
        assertThat( Traverse.sorted( ArrayTraveller.of(array), Comparator.naturalOrder() ) ).isFalse();
        Edit.sort( ArrayEditor.from(array), Comparator.naturalOrder() );
        assertThat( Traverse.sorted( ArrayTraveller.of(array), Comparator.naturalOrder() ) ).isTrue();
    }

    @Test
    public void transform ()
    {
        Edit.transform( ArrayEditor.from(array), it -> it % 2 );
        assertThat( Traverse.every( ArrayTraveller.of(array), it -> it < 2 ) ).isTrue();
    }

    @BeforeEach
    void setUp ()
    {
        final var random = ThreadLocalRandom.current();
        for (int i = 0; i != size; ++i) array[i] = random.nextInt();
    }
}
