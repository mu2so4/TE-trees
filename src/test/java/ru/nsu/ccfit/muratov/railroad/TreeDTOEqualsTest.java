package ru.nsu.ccfit.muratov.railroad;

import org.junit.Test;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;

public class TreeDTOEqualsTest {
    @Test
    @DisplayName("reflexivity test")
    public void testReflexivity() {
        TreeDTO dto = new TreeDTO();
        for(int index = 0; index < 100; index++) {
            dto.setId(index);
            Assert.assertEquals(dto, dto);
        }
    }
    @Test
    @DisplayName("symmetric test")
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

    @Test
    @DisplayName("test with children nodes")
    public void withChildrenTest() {
        TreeDTO root1 = new TreeDTO(1, "root");
        TreeDTO root2 = new TreeDTO(1, "root");

        root1.addChild(new TreeDTO(2, "ab"));
        root2.addChild(new TreeDTO(2, "ab"));
        Assert.assertEquals(root1, root2);
    }
}
