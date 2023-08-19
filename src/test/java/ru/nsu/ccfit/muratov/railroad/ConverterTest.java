package ru.nsu.ccfit.muratov.railroad;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class ConverterTest {
    @Test
    public void simpleTest() {
        Collection<Converter.TreeEntity> entities = new ArrayList<>();
        entities.add(new Converter.TreeEntity(1, "a", null));
        entities.add(new Converter.TreeEntity(2, "d", 1));
        entities.add(new Converter.TreeEntity(3, "h", 6));
        entities.add(new Converter.TreeEntity(4, "i", 6));
        entities.add(new Converter.TreeEntity(5, "j", 6));
        entities.add(new Converter.TreeEntity(6, "c", 1));
        entities.add(new Converter.TreeEntity(7, "e", 8));
        entities.add(new Converter.TreeEntity(8, "b", 1));
        entities.add(new Converter.TreeEntity(9, "f", 8));
        entities.add(new Converter.TreeEntity(0, "g", 9));

        Collection<Converter.TreeDTO> dtos = Converter.convert(entities);

        for(Converter.TreeDTO dto: dtos) {
            System.out.println(dto);
        }
    }
}
