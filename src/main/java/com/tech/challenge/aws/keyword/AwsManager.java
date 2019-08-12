package com.tech.challenge.aws.keyword;

import org.apache.commons.text.similarity.JaroWinklerSimilarity;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

public class AwsManager {

    @Autowired
    private JaroWinklerSimilarity jaroWinklerSimilarity;

    @Autowired
    private RestTemplate restTemplate;


    public Integer requestAWS(String keyword) throws URISyntaxException {
        int scoreFinal = 0;
        URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("completion.amazon.com")
                .setPath("/search/complete")
                .setParameter("q", keyword)
                .setParameter("search-alias", "aps")
                .setParameter("client", "amazon-search-ui")
                .setParameter("mkt", "1")
                .build();


        ResponseEntity<ArrayList> responseEntity = restTemplate.getForEntity(uri.toString(), ArrayList.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {

            if (!responseEntity.getBody().isEmpty()) {
                ArrayList<String> keywordsAws = (ArrayList<String>) responseEntity.getBody().get(1);
                HashMap<String, Integer> map = keywordsAws.stream().collect(toMap(Function.identity(), string -> calculateScore(keyword, string), (e1, e2) -> e2, HashMap::new));

                scoreFinal = map.values().stream().reduce(0, Integer::sum);

                return  scoreFinal;
            }
        }


        return scoreFinal;
    }

    private int calculateScore(String keywordMaster, String keywordSlave) {

        double similarity = jaroWinklerSimilarity.apply(keywordMaster, keywordSlave) * 10;
        return (int) similarity;

    }

}