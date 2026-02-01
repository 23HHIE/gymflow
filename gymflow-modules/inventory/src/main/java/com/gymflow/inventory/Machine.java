package com.gymflow.inventory;

import jakarta.persistence.*;

@Entity
@Table(name = "machines")
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gym_id", nullable = false)
    private Long gymId;

    @Column(nullable = false)
    private String name;

    private String type;
    private String location;

    @Column(name = "avg_duration_minutes", nullable = false)
    private Integer avgDurationMinutes;

    public Long getId() { return id; }
    public Long getGymId() { return gymId; }
    public void setGymId(Long gymId) { this.gymId = gymId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public Integer getAvgDurationMinutes() { return avgDurationMinutes; }
    public void setAvgDurationMinutes(Integer avgDurationMinutes) { this.avgDurationMinutes = avgDurationMinutes; }
}
