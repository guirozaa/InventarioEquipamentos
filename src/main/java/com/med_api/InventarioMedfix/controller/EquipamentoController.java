package com.med_api.InventarioMedfix.controller;

import com.med_api.InventarioMedfix.dto.EquipamentoDTO;
import com.med_api.InventarioMedfix.service.EquipamentoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/equipamento")
public class EquipamentoController {
    @Autowired
    private EquipamentoService equipamentoService;

    @GetMapping("/")
    public ResponseEntity<List<EquipamentoDTO>> findAll() {
        List<EquipamentoDTO> equipamentos = equipamentoService.findAll();
        return ResponseEntity.ok(equipamentos);
    }

    @PostMapping("/")
    public ResponseEntity<EquipamentoDTO> create(@RequestBody EquipamentoDTO equipamentoDTO){
        EquipamentoDTO savedEquipamento = equipamentoService.save(equipamentoDTO);
        return ResponseEntity.ok(savedEquipamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipamentoDTO> getById(@PathVariable UUID id){
        return equipamentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipamentoDTO> update(@PathVariable UUID id, @RequestBody EquipamentoDTO equipamentoDTO) {
        return equipamentoService.update(id, equipamentoDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (equipamentoService.deleteById(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }
}

