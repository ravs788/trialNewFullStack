package com.ravi.crudApp.backend.controllers;

import com.ravi.crudApp.backend.dtos.GymRecordDto;
import com.ravi.crudApp.backend.entities.GymRecord;
import com.ravi.crudApp.backend.services.RecordsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecordsController {
    private final RecordsService recordsService;

    @GetMapping("/gym/records")
    public ResponseEntity<List<GymRecordDto>> allRecords(){
        return ResponseEntity.ok(recordsService.allRecords());
    }

    @PostMapping("/gym/records")
    public ResponseEntity<GymRecordDto> createGymRecord(@RequestBody GymRecordDto recordDto) {
        GymRecordDto createdRecord = recordsService.createGymRecord(recordDto);
        return ResponseEntity.created(URI.create("/gym/records/"+recordDto.getId()))
        .body(createdRecord);
    }

    @DeleteMapping("/gym/records/{id}")
    public  ResponseEntity<GymRecordDto> deleteGymRecord(@PathVariable Long id){
        return ResponseEntity.ok(recordsService.deleteGymRecord(id));
    }

    @PutMapping("/gym/records/{id}")
    public ResponseEntity<GymRecordDto> updateGymRecord(@PathVariable Long id, @RequestBody GymRecordDto recordDto){
        return ResponseEntity.ok(recordsService.updateGymRecord(id, recordDto));
    }

}
