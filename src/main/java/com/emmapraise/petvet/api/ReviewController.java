package com.emmapraise.petvet.api;

import com.emmapraise.petvet.payload.ReviewDto;
import com.emmapraise.petvet.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/review/all")
    public ResponseEntity<List<ReviewDto>> getReviews(){
        return ResponseEntity.ok().body(reviewService.getReviews());
    }

    @PostMapping("/review/owner/{ownerId}/appointment/{appointmentId}")
    public ResponseEntity<ReviewDto> postReview(@PathVariable(value = "ownerId") long ownerId,
                                                @PathVariable(value = "appointmentId") long appointmentId,
                                                @RequestBody ReviewDto reviewDto){
        return ResponseEntity.ok().body(reviewService.postReview(ownerId, appointmentId, reviewDto));
    }

    @DeleteMapping("/review/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable(value = "id") long reviewId){
        return ResponseEntity.ok().body(reviewService.deleteReview(reviewId));
    }
}
