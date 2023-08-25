package br.dev.pedrolamarao.structure;

import br.dev.pedrolamarao.structure.editable.Edit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ArrayEditingTest
{
    final Object[] array = new Object[size];

    static final int size = 1024;

    @Test
    void bubbleSort ()
    {
        final var editable = EditableArray.of(array);
        final var ordering = Comparator.comparingInt(Object::hashCode);
        Edit.bubbleSort(editable,ordering);
        assertThat(array).isSortedAccordingTo(ordering);
    }

    @Test
    void selectSort ()
    {
        final var editable = EditableArray.of(array);
        final var ordering = Comparator.comparingInt(Object::hashCode);
        Edit.selectSort(editable,ordering);
        assertThat(array).isSortedAccordingTo(ordering);
    }

    @BeforeEach
    void fill ()
    {
        for (int i = 0, j = array.length; i != j; ++i) {
            array[i] = new Object();
        }
    }
}
