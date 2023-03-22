package com.javatrail.rediseventdrivenpubsub.controller;
import com.javatrail.rediseventdrivenpubsub.configs.RedisData;
import com.javatrail.rediseventdrivenpubsub.service.publisher.RedisPublisher;
import com.javatrail.rediseventdrivenpubsub.service.subscriber.RedisMessageSubscriber;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messaging")
@AllArgsConstructor
public class PublisherController {

    private final RedisPublisher redisPublisher;

    @PostMapping(value = "/produce")
    public ResponseEntity<String> publishMessage(@RequestBody RedisData redisData){
        redisPublisher.publish(redisData);
        return new ResponseEntity<>("Success !!! ", HttpStatus.OK);
    }

    @GetMapping(value = "/subscribe")
    public List<String> getMessage(){
        return RedisMessageSubscriber.messages;
    }

}