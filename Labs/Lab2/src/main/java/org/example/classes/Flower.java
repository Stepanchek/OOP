package org.example.classes;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Flower {
    private int id;
    private String name;
    private Soil soil;
    private String origin;
    private VisualParameters visualParameters;
    private GrowingTips growingTips;
    private Multiplying multiplying;

    public Flower() {
        this.visualParameters = new VisualParameters();
        this.growingTips = new GrowingTips();
    }

    @Override
    public String toString() {
        return String.format("Id : %d\n" +
                        "Name : %s\n" +
                        "Soil : %s\n" +
                        "Origin : %s\n" +
                        "%s\n" +
                        "%s\n" +
                        "Multiplying : %s",
                id,
                name,
                soil,
                origin,
                visualParameters,
                growingTips,
                multiplying);
    }
}
