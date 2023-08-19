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
    @Test
    public void testSymmetric() {
        TreeDTO dto1 = new TreeDTO();
        TreeDTO dto2 = new TreeDTO();
        Assert.assertEquals(dto1, dto2);

        dto1.setId(10);
        dto2.setId(10);
        Assert.assertEquals(dto1, dto2);
        Assert.assertEquals(dto1.equals(dto2), dto2.equals(dto1));

        dto1.setName("test");
        dto2.setName("test");
        Assert.assertEquals(dto1, dto2);
        Assert.assertEquals(dto1.equals(dto2), dto2.equals(dto1));

        dto2.setName("repeat");
        Assert.assertNotEquals(dto1, dto2);
        Assert.assertEquals(dto1.equals(dto2), dto2.equals(dto1));
    }
}
