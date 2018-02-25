package com.dkg.streamkafkacassandra.test;

import lombok.Builder;
import lombok.Data;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;


@Builder
@Data
@Table("t_test")
public class TestEntity {

    @PrimaryKeyColumn(name = "org_id", type = PrimaryKeyType.PARTITIONED)
    String orgId;

    @PrimaryKeyColumn(name = "gps_imei", type = PrimaryKeyType.CLUSTERED)
    String imei;

    @Column("gps_event_time")
    Long gpsEventTime;

    @Column("longitude")
    Float longitude;

    @Column("latitude")
    Float latitude;

}
