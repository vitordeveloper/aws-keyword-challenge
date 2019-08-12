package com.tech.challenge;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"Keyword", "score"})
public class KeywordResponse {

    private final String keyword;

    private final Integer score;

    public Integer getScore() {
        return score;
    }

    @JsonProperty("Keyword")
    public String getKeyword() {
        return keyword;
    }

    public KeywordResponse(String keyword, Integer score) {
        this.keyword = keyword;
        this.score = score;
    }
}