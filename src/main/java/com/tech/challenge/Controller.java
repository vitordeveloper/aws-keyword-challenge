package com.tech.challenge;

import com.tech.challenge.aws.keyword.AwsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping
public class Controller {

    @Autowired
    private AwsManager awsManager;

    @GetMapping(value = "/estimate", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public KeywordResponse getMapping(@RequestParam("keyword") String keyword) throws URISyntaxException {

        Integer score = awsManager.requestAWS(keyword);

        return new KeywordResponse(keyword, score);
    }


}