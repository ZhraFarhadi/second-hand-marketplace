package com.secondhand.frontend.dto.rating.request;

public class CreateSellerRatingRequest {

    private Integer score;

    private String comment;

    public CreateSellerRatingRequest() {
    }

    public CreateSellerRatingRequest(Integer score, String comment) {
        this.score = score;
        this.comment = comment;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}