package com.teamexpat.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@MockitoSettings(strictness = Strictness.STRICT_STUBS)
@ExtendWith(MockitoExtension.class)
class UtilityTest {

    @Test
    void getArrayForTraversal() {
        int expected = 4;
        final Integer[][] actual = Utility.getArrayForTraversal();
        assertThat(actual.length).isEqualTo(expected);
    }

    @Test
    void convertMultidimensionalArrayToList() {

//        Utility.convertMultidimensionalArrayToList();

    }

    @Test
    void printResult() {
    }
}