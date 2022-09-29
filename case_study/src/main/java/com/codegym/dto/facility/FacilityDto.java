package com.codegym.dto.facility;

import com.codegym.model.facility.FacilityType;
import com.codegym.model.facility.RentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FacilityDto {
    private int id;
    private String name;
    private int area;
    private Double cost;
    private int maxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private Double poolArea;
    private int numberOfFloors;
    private String facilityFree;
    private RentType rentType;
    private FacilityType facilityType;

    public FacilityDto() {
    }

    public FacilityDto(int id, String name, int area, Double cost, int maxPeople, String standardRoom,
                       String descriptionOtherConvenience, Double poolArea, int numberOfFloors,
                       String facilityFree, RentType rentType, FacilityType facilityType) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.facilityFree = facilityFree;
        this.rentType = rentType;
        this.facilityType = facilityType;
    }
}
