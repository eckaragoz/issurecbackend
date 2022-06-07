package com.isrc.configurations;

import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.ManagementCenterConfig;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.isrc.models.UserVO;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.hazelcast.config.Config;


@Configuration
public class HazelcastConfiguration {

  @Bean
  public Config hazelCastConfig() {
    Config config = new Config();
    config.setInstanceName("bpm");
    config.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(false);
    return config;
  }

  @Bean
  public HazelcastInstance hazelcastInstance(Config hazelCastConfig) {
    return Hazelcast.newHazelcastInstance(hazelCastConfig);
  }

  @Bean
  public Map<String, UserVO> accountMap(HazelcastInstance hazelcastInstance) {
    return hazelcastInstance.getMap("usermap");
  }




}
