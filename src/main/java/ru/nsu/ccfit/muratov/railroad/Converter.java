package ru.nsu.ccfit.muratov.railroad;

import java.util.Collection;
import java.util.List;

public class Converter {
    public static Collection<TreeDTO> convert(Collection<TreeEntity> entities) {
        //TODO
        return null;
    }

    private static class TreeEntity {
        private Integer id;
        private String name;
        private Integer parentId;
    }

    private static class TreeDTO {
        private Integer id;
        private String name;
        private List<TreeDTO> children;
    }
}