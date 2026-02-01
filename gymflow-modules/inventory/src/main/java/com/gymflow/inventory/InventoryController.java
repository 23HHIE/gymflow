package com.gymflow.inventory;

import com.gymflow.inventory.dto.MachineDto;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/gyms")
public class InventoryController {

    private final MachineRepository machineRepository;

    public InventoryController(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    @GetMapping("/{gymId}/machines")
    public List<MachineDto> listMachines(@PathVariable Long gymId) {
        return machineRepository.findByGymId(gymId)
                .stream()
                .map(m -> new MachineDto(
                        m.getId(),
                        m.getName(),
                        m.getType(),
                        m.getLocation(),
                        m.getAvgDurationMinutes()
                ))
                .toList();
    }
}
