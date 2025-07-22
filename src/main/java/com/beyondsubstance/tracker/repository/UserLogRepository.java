package com.beyondsubstance.tracker.repository;

import com.beyondsubstance.tracker.model.UserLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLogRepository extends JpaRepository<UserLog, Long> {
}
