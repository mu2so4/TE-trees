package ru.nsu.ccfit.muratov.railroad;

import java.util.*;

public class Converter {
    public static Collection<TreeDTO> convert(Collection<TreeEntity> entities) {
        List<TreeDTO> roots = new ArrayList<>();
        Map<Integer, TreeDTO> forest = new HashMap<>();
        for(TreeEntity entity: entities) {
            TreeDTO dto = new TreeDTO();
            dto.children = new ArrayList<>();
            dto.id = entity.id;
            dto.name = entity.name;
            //TODO getting direct children from map
            if(entity.parentId == null) {
                //...
                forest.put(entity.id, dto);
                roots.add(dto);
            }
            //TODO getting suptree in map
        }
        return roots;
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