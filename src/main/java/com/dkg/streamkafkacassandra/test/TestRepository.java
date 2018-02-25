package com.dkg.streamkafkacassandra.test;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends CassandraRepository<TestEntity>{
}
