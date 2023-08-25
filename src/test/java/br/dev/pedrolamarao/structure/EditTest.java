package br.dev.pedrolamarao.structure;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EditTest
{
    static final int size = 10240;

    @ParameterizedTest
    @MethodSource("structures")
    void bubbleSort (EditableUniLinear<Object> structure)
    {
        final var ordering = Comparator.comparingInt(Object::hashCode);
        Edit.bubbleSort(structure,ordering);
    }

    @ParameterizedTest
    @MethodSource("structures")
    void fill (EditableUniLinear<Object> structure)
    {
        final var element = new Object();
        assertFalse( Traverse.every(structure,element::equals) );
        Edit.fill(structure,element);
        assertTrue( Traverse.every(structure,element::equals) );
    }

    @ParameterizedTest
    @MethodSource("structures")
    void selectSort (EditableUniLinear<Object> structure)
    {
        final var ordering = Comparator.comparingInt(Object::hashCode);
        Edit.selectSort(structure,ordering);
    }

    static List<EditableUniLinear<Object>> structures ()
    {
        final var array = new Object[size];
        for (int i = 0; i != array.length; ++i) array[i] = new Object();

        MonoNode<Object> node = null;
        for (int i = 0; i != size; ++i) node = new MonoNode<>(node, new Object());

        return List.of(
            EditableArray.of(array),
            EditableMonoNodes.of(node)
        );
    }
}
