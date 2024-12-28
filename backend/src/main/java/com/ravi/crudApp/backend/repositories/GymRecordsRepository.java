package com.ravi.crudApp.backend.repositories;

import com.ravi.crudApp.backend.entities.GymRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymRecordsRepository extends JpaRepository<GymRecord, Long> {
}
