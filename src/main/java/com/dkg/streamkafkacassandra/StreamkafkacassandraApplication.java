package com.dkg.streamkafkacassandra;

import com.dkg.streamkafkacassandra.channels.TestChannel;
import com.dkg.streamkafkacassandra.test.TestEntity;
import com.dkg.streamkafkacassandra.test.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.messaging.Message;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@EnableBinding(TestChannel.class)
@EnableCassandraRepositories(basePackages = {"com.dkg.streamkafkacassandra"})
@ComponentScan("com.dkg.streamkafkacassandra")
public class StreamkafkacassandraApplication {

	@Autowired
	TestRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(StreamkafkacassandraApplication.class, args);
	}

	@StreamListener(value = TestChannel.INPUT)
	public void processInput(Message<byte[]> message) {
		System.out.println(new String(message.getPayload()));
		repo.save(TestEntity.builder()
				.orgId("1234")
				.gpsEventTime(123L)
				.imei("imei")
				.latitude(123.34f)
				.longitude(45.345f)
				.build());


	}
}
