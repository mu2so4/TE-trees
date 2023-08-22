package ru.nsu.ccfit.muratov.railroad;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class ConverterTest {
    private static Collection<TreeEntity> createTree1() {
        Collection<TreeEntity> entities = new ArrayList<>();
        entities.add(new TreeEntity(1, "a", null));
        entities.add(new TreeEntity(2, "d", 1));
        entities.add(new TreeEntity(3, "h", 6));
        entities.add(new TreeEntity(4, "i", 6));
        entities.add(new TreeEntity(5, "j", 6));
        entities.add(new TreeEntity(6, "c", 1));
        entities.add(new TreeEntity(7, "e", 8));
        entities.add(new TreeEntity(8, "b", 1));
        entities.add(new TreeEntity(9, "f", 8));
        entities.add(new TreeEntity(10, "g", 9));
        return entities;
    }

    private static Collection<TreeDTO> getAnswer1() {
        List<TreeDTO> dtos = new ArrayList<>();
        for(int index = 0; index < 10; index++) {
            dtos.add(new TreeDTO(index + 1, null));
        }
        dtos.get(0).setName("a");
        dtos.get(1).setName("d");
        dtos.get(2).setName("h");
        dtos.get(3).setName("i");
        dtos.get(4).setName("j");
        dtos.get(5).setName("c");
        dtos.get(6).setName("e");
        dtos.get(7).setName("b");
        dtos.get(8).setName("f");
        dtos.get(9).setName("g");

        dtos.get(0).addChild(dtos.get(1));
        dtos.get(0).addChild(dtos.get(5));
        dtos.get(0).addChild(dtos.get(7));
        dtos.get(7).addChild(dtos.get(6));
        dtos.get(7).addChild(dtos.get(8));
        dtos.get(8).addChild(dtos.get(9));
        dtos.get(5).addChild(dtos.get(2));
        dtos.get(5).addChild(dtos.get(3));
        dtos.get(5).addChild(dtos.get(4));

        List<TreeDTO> result = new ArrayList<>();
        result.add(dtos.get(0));
        return result;
    }

    private static Collection<TreeEntity> createForest1() {
        Collection<TreeEntity> entities = new ArrayList<>();
        entities.add(new TreeEntity(1, "arm", 11));
        entities.add(new TreeEntity(2, "denial", 1));
        entities.add(new TreeEntity(3, "indirect", 9));
        entities.add(new TreeEntity(4, "couple", 5));
        entities.add(new TreeEntity(5, "confrontation", null));
        entities.add(new TreeEntity(6, "daughter", null));
        entities.add(new TreeEntity(7, "live", 10));
        entities.add(new TreeEntity(8, "home", 1));
        entities.add(new TreeEntity(9, "fever", null));
        entities.add(new TreeEntity(10, "resignation", 1));
        entities.add(new TreeEntity(11, "absorb", 6));
        entities.add(new TreeEntity(12, "fit", null));
        entities.add(new TreeEntity(13, "forward", null));
        return entities;
    }

    @Test
    public void simpleTest() {
        Collection<TreeDTO> actual = Converter.convert(createTree1());
        Collection<TreeDTO> expected = getAnswer1();
        Assert.assertEquals(actual.size(), expected.size());

        List<TreeDTO> expectedList = new ArrayList<>(expected);
        List<TreeDTO> actualList = new ArrayList<>(actual);

        expectedList.sort(Comparator.comparingInt(TreeDTO::getId));
        actualList.sort(Comparator.comparingInt(TreeDTO::getId));

        for(int index = 0; index < actualList.size(); index++) {
            Assert.assertEquals(expectedList.get(index), actualList.get(index));
        }
    }

    @Test
    public void shuffleChildren() {

    }

    public void forestTest() {

    }


}
