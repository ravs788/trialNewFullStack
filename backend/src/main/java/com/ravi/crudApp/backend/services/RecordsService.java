package com.ravi.crudApp.backend.services;

import com.ravi.crudApp.backend.dtos.GymRecordDto;
import com.ravi.crudApp.backend.entities.GymRecord;
import com.ravi.crudApp.backend.exceptions.AppException;
import com.ravi.crudApp.backend.mappers.GymRecordMapper;
import com.ravi.crudApp.backend.repositories.GymRecordsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordsService {

    private final GymRecordsRepository gymRecordsRepository;
    private final GymRecordMapper gymRecordMapper;

    public List<GymRecordDto> allRecords(){
        return gymRecordMapper.toGymRecordDtos(gymRecordsRepository.findAll());
    }

    public GymRecordDto createGymRecord(GymRecordDto gymRecordDto) {
        GymRecord gymRecord = gymRecordMapper.toGymRecord(gymRecordDto);

        GymRecord createdGymRecord = gymRecordsRepository.save(gymRecord);

        return gymRecordMapper.toGymRecordDto(createdGymRecord);
    }

    public GymRecordDto deleteGymRecord(Long id) {
        GymRecord searchedRecord = gymRecordsRepository.findById(id)
                .orElseThrow(() -> new AppException("Gym record not found", HttpStatus.NOT_FOUND));

        GymRecordDto toDeleteGymRecord = gymRecordMapper.toGymRecordDto(searchedRecord);

        gymRecordsRepository.deleteById(id);

        return toDeleteGymRecord;
    }

    public GymRecordDto updateGymRecord(Long id, GymRecordDto recordDto) {

        GymRecord gymRecord = gymRecordsRepository.findById(id)
                .orElseThrow(() -> new AppException("Gym record not found", HttpStatus.NOT_FOUND));

        gymRecordMapper.updateGymRecord(gymRecord, recordDto);
        GymRecord updatedGymRecord = gymRecordsRepository.save(gymRecord);

        return  gymRecordMapper.toGymRecordDto(updatedGymRecord);


    }
}
