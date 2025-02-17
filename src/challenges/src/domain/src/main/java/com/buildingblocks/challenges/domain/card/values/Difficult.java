package com.buildingblocks.challenges.domain.card.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidationUtils;

public class Difficult implements IValueObject {

    private final String level;
    private final Integer points;

    private Difficult(String level, Integer points) {
        validate();
        this.level = level;
        this.points = points;
    }

    public static Difficult of(String level, Integer points) {
        return new Difficult(level, points);
    }

    @Override
    public void validate() {
        ValidationUtils.validateTextNotEmpty(level, "Difficult level cannot be empty");
        ValidationUtils.validateNumberNotNull(points, "Difficult points cannot be empty");
        ValidationUtils.validateNumberNotNegative(points, "Difficult points cannot be negative");
    }

    public String getLevel() {
        return level;
    }

    public Integer getPoints() {
        return points;
    }
}
