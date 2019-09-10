package com.qa.repository;

import com.qa.models.Workouts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workouts, Long> {
}
