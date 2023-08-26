package br.dev.pedrolamarao.structure;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EditEmptyTest
{
    static final int size = 10240;

    @ParameterizedTest
    @MethodSource("structures")
    void bubbleSort (EditableUniLinear<Object> structure)
    {
        final var ordering = Comparator.comparingInt(Object::hashCode);
        Edit.bubbleSort(structure,ordering);
        assertTrue( Traverse.sorted(structure,ordering) );
    }

    @ParameterizedTest
    @MethodSource("structures")
    void fill (EditableUniLinear<Object> structure)
    {
        final var element = new Object();
        Edit.fill(structure,element);
    }

    @ParameterizedTest
    @MethodSource("structures")
    void selectSort (EditableUniLinear<Object> structure)
    {
        final var ordering = Comparator.comparingInt(Object::hashCode);
        Edit.selectSort(structure,ordering);
        assertTrue( Traverse.sorted(structure,ordering) );
    }

    static List<EditableUniLinear<Object>> structures ()
    {
        return List.of(
            EditableArray.from(Object.class, new Object[0]),
            EditableMonoNodes.empty()
        );
    }
}
