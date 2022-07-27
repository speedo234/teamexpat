package com.teamexpat.util;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;


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

        final int expected = 4;

        Integer[][] integerArrays = new Integer[4][4];
            integerArrays[0][0] = 1;
            integerArrays[0][1] = 2;
            integerArrays[0][2] = 3;
            integerArrays[0][3] = 4;
            //
            integerArrays[1][0] = 5;
            integerArrays[1][1] = 6;
            integerArrays[1][2] = 7;
            integerArrays[1][3] = 8;
            //
            integerArrays[2][0] = 9;
            integerArrays[2][1] = 10;
            integerArrays[2][2] = 11;
            integerArrays[2][3] = 12;
            //
            integerArrays[3][0] = 13;
            integerArrays[3][1] = 14;
            integerArrays[3][2] = 15;
            integerArrays[3][3] = 16;

        final List<List<Integer>> actual = Utility.convertMultidimensionalArrayToList(integerArrays);

        assertThat(actual.size()).isEqualTo(expected);

    }

    @Disabled
    void printResult() {
    }
}