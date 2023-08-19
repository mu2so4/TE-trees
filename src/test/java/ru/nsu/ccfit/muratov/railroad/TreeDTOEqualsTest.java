package ru.nsu.ccfit.muratov.railroad;

import org.junit.Test;
import org.junit.Assert;

public class TreeDTOEqualsTest {
    @Test
    public void testReflexivity() {
        TreeDTO dto = new TreeDTO();
        for(int index = 0; index < 100; index++) {
            dto.setId(index);
            Assert.assertEquals(dto, dto);
        }
    }
}
