package com.emmapraise.petvet.repo;

import com.emmapraise.petvet.entity.Appointment;
import com.emmapraise.petvet.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ReviewRepo extends JpaRepository<Review, Long> {

    Review findAllByAppointment(Appointment appointment);
}
