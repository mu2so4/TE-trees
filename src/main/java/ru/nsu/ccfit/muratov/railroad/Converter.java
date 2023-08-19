package ru.nsu.ccfit.muratov.railroad;

import java.util.*;

public class Converter {
    public static Collection<TreeDTO> convert(Collection<TreeEntity> entities) {
        List<TreeDTO> roots = new ArrayList<>();
        Map<Integer, TreeDTO> entitiesById = new HashMap<>();
        for(TreeEntity entity: entities) {
            TreeDTO dto = entitiesById.get(entity.id);
            if (dto == null) {
                dto = new TreeDTO();
                dto.id = entity.id;
                dto.children = new ArrayList<>();
            }
            dto.name = entity.name;

            entitiesById.put(entity.id, dto);
            if(entity.parentId == null) {
                roots.add(dto);
                continue;
            }
            TreeDTO directParent = entitiesById.get(entity.parentId);
            if(directParent == null) {
                directParent = new TreeDTO();
                directParent.children = new ArrayList<>();
                directParent.id = entity.parentId;
            }
            directParent.children.add(dto);
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
