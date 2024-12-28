package com.ravi.crudApp.backend.mappers;

import com.ravi.crudApp.backend.dtos.GymRecordDto;
import com.ravi.crudApp.backend.entities.GymRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GymRecordMapper {

    GymRecord toGymRecord(GymRecordDto gymRecordDto);

    GymRecordDto toGymRecordDto(GymRecord gymRecord);

    List<GymRecordDto> toGymRecordDtos(List<GymRecord> gymRecords);

    @Mapping(target = "id", ignore = true)
    void updateGymRecord(@MappingTarget GymRecord gymRecord, GymRecordDto recordDto);
}
