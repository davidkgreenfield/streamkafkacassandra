package com.dkg.streamkafkacassandra.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface TestChannel {

    String INPUT = "testchannel";

    @Input("testchannel")
    SubscribableChannel testTopic();
}