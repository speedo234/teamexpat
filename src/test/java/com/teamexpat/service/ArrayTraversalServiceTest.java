package com.teamexpat.service;

import com.teamexpat.service.impl.ArrayTraversalServiceImpl;
import com.teamexpat.service.impl.ValidationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@MockitoSettings(strictness = Strictness.STRICT_STUBS)
@ExtendWith(MockitoExtension.class)
class ArrayTraversalServiceTest {


    @InjectMocks
    ArrayTraversalServiceImpl arrayTraversalService;

    @Mock
    ValidationServiceImpl validationService;

    @BeforeEach
    void setUp() throws IOException {
    }

    @Test
    void doArrayTraversal() {

        List<List<Integer>> integerList1 = new ArrayList<>();
        List<Integer> integerList = Arrays.asList(1,2,3,4);
        integerList1.add(integerList);
        integerList = Arrays.asList(5,6,7,8);
        integerList1.add(integerList);
        integerList = Arrays.asList(9,10,11,12);
        integerList1.add(integerList);
        integerList = Arrays.asList(13,14,15,16);
        integerList1.add(integerList);

        final String expected = "1,2,3,4, 8,12,16, 15,14,13, 9,5, 6,7, 11,10";

        String actual = arrayTraversalService.doArrayTraversal(integerList1);

        assertThat(actual).isEqualTo(expected);
    }
}