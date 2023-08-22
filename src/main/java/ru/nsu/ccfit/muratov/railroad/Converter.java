package ru.nsu.ccfit.muratov.railroad;

import java.util.*;

public class Converter {
    public static Collection<TreeDTO> convert(Collection<TreeEntity> entities) {
        List<TreeDTO> roots = new ArrayList<>();
        Map<Integer, TreeDTO> entitiesById = new HashMap<>();
        for(TreeEntity entity: entities) {
            TreeDTO dto = entitiesById.get(entity.getId());
            if (dto == null) {
                dto = new TreeDTO(entity.getId(), null);
                entitiesById.put(entity.getId(), dto);
            }
            dto.setName(entity.getName());

            if(entity.getParentId() == null) {
                roots.add(dto);
                continue;
            }
            TreeDTO directParent = entitiesById.get(entity.getParentId());
            if(directParent == null) {
                directParent = new TreeDTO(entity.getParentId(), null);
                entitiesById.put(entity.getParentId(), directParent);
            }
            directParent.getChildren().add(dto);
        }
        return roots;
    }

}
