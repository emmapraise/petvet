package com.emmapraise.petvet.service.impl;

import com.emmapraise.petvet.entity.Appointment;
import com.emmapraise.petvet.entity.Owner;
import com.emmapraise.petvet.entity.Review;
import com.emmapraise.petvet.payload.ReviewDto;
import com.emmapraise.petvet.repo.AppointmentRepo;
import com.emmapraise.petvet.repo.OwnerRepo;
import com.emmapraise.petvet.repo.ReviewRepo;
import com.emmapraise.petvet.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepo reviewRepo;

    private final AppointmentRepo appointmentRepo;

    private final OwnerRepo ownerRepo;

    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<ReviewDto> getReviews() {
        return reviewRepo.findAll().stream().map(this::mapToDto).toList();
    }

    @Override
    public ReviewDto postReview(long ownerId, long appointmentId, ReviewDto reviewDto) {
        Owner owner = ownerRepo.findById(ownerId).orElseThrow(()-> new IllegalStateException("No Owner Found"));
        if (appointmentRepo.existsById(appointmentId)){
            Appointment appointment = appointmentRepo.findById(appointmentId);
            Review review = mapToEntity(reviewDto);
            review.setOwner(owner);
            review.setAppointment(appointment);
            return mapToDto(reviewRepo.save(review));
        }
        throw new IllegalStateException("No Appointment Found");
    }

    @Override
    public String deleteReview(long reviewId) {
        if (reviewRepo.existsById(reviewId)){
            reviewRepo.deleteById(reviewId);
            return "Review Deleted";
        }
        throw new IllegalStateException("No Review Found");
    }

    private ReviewDto mapToDto(Review review){
        return mapper.map(review, ReviewDto.class);
    }

    private Review mapToEntity(ReviewDto reviewDto){
        return mapper.map(reviewDto, Review.class);
    }
}
