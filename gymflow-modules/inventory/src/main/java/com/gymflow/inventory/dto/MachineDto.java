package com.gymflow.inventory.dto;

public record MachineDto (
        Long id,
        String name,
        String type,
        String location,
        Integer avgDurationMinutes
){ }
