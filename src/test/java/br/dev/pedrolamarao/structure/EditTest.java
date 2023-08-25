package br.dev.pedrolamarao.structure;

import br.dev.pedrolamarao.structure.editable.Edit;
import br.dev.pedrolamarao.structure.editable.UniLinearEditable;
import br.dev.pedrolamarao.structure.traversable.Traverse;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EditTest
{
    @ParameterizedTest
    @MethodSource("structures")
    void bubbleSort (UniLinearEditable<Object> structure)
    {
        final var ordering = Comparator.comparingInt(Object::hashCode);
        Edit.bubbleSort(structure,ordering);
    }

    @ParameterizedTest
    @MethodSource("structures")
    void fill (UniLinearEditable<Object> structure)
    {
        final var element = new Object();
        assertThat( Traverse.find(structure,element) ).isNull();
        Edit.fill(structure,element);
        assertThat( Traverse.find(structure,element) ).isNotNull();
    }

    @ParameterizedTest
    @MethodSource("structures")
    void selectSort (UniLinearEditable<Object> structure)
    {
        final var ordering = Comparator.comparingInt(Object::hashCode);
        Edit.selectSort(structure,ordering);
    }

    static List<UniLinearEditable<Object>> structures ()
    {
        final int size = 10240;
        final var array = new Object[size];
        for (int i = 0; i != array.length; ++i) array[i] = new Object();

        return List.of(
            EditableArray.of(array)
        );
    }
}
