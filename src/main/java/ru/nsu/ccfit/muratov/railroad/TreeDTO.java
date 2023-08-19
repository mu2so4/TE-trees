package ru.nsu.ccfit.muratov.railroad;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TreeDTO {
    private Integer id;
    private String name;
    private List<TreeDTO> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TreeDTO> getChildren() {
        return children;
    }

    public void setChildren(List<TreeDTO> children) {
        this.children = children;
    }

    private String toString(int level) {
        StringBuilder builder = new StringBuilder();
        builder.append("\t".repeat(Math.max(0, level)));
        builder.append(String.format("{\"id\": %d, \"name\": \"%s\"", id, name));
        if (!children.isEmpty()) {
            builder.append(", \"children\": [\n");
            for (TreeDTO child : children) {
                builder.append(child.toString(level + 1));
            }
            builder.append("\t".repeat(Math.max(0, level)));
            builder.append("]");
        }
        builder.append("},\n");
        return builder.toString();
    }

    @Override
    public String toString() {
        return toString(0);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof TreeDTO dto)) {
            return false;
        }
        if (!id.equals(dto.id) || !name.equals(dto.name)) {
            return false;
        }
        if (children.isEmpty() && dto.children.isEmpty()) {
            return true;
        }
        if (children.size() != dto.children.size()) {
            return false;
        }
        List<TreeDTO> ourChildren = new ArrayList<>(children);
        List<TreeDTO> theirChildren = new ArrayList<>(dto.children);
        ourChildren.sort(Comparator.comparingInt(TreeDTO::getId));
        theirChildren.sort(Comparator.comparingInt(TreeDTO::getId));
        int size = ourChildren.size();

        for(int index = 0; index < size; index++) {
            if(!ourChildren.get(index).equals(theirChildren.get(index))) {
                return false;
            }
        }
        return true;
    }
}
