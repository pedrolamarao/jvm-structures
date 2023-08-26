package br.dev.pedrolamarao.structure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class SortedIntegerArrayTest
{
    static final int size = 1024 * 10;

    final Integer[] array = new Integer[size];

    @Test
    public void sorted ()
    {
        assertThat( Traverse.sorted( ArrayTraveller.of(array), Comparator.naturalOrder() ) ).isTrue();
    }

    @BeforeEach
    void setUp ()
    {
        for (int i = 0; i != size; ++i) array[i] = i;
    }
}
