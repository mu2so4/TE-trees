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
                entitiesById.put(entity.id, dto);
            }
            dto.name = entity.name;

            if(entity.parentId == null) {
                roots.add(dto);
                continue;
            }
            TreeDTO directParent = entitiesById.get(entity.parentId);
            if(directParent == null) {
                directParent = new TreeDTO();
                directParent.children = new ArrayList<>();
                directParent.id = entity.parentId;
                entitiesById.put(entity.parentId, directParent);
            }
            directParent.children.add(dto);
        }
        return roots;
    }

    public static class TreeEntity {
        private Integer id;
        private String name;
        private Integer parentId;

        public TreeEntity(Integer id, String name, Integer parentId) {
            this.id = id;
            this.name = name;
            this.parentId = parentId;
        }
    }

    public static class TreeDTO {
        private Integer id;
        private String name;
        private List<TreeDTO> children;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(String.format("{\"id\": %d, \"name\": \"%s\", \"children\": [", id, name));
            for(TreeDTO child: children) {
                builder.append(child);
            }
            builder.append("]},\n");
            return builder.toString();
        }
    }
}
