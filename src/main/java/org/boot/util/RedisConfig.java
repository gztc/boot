package org.boot.util;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

@Configuration
public class RedisConfig {
	//注入集群信息
	@Value("${spring.redis.cluster.nodes}")
	private String clusterNodes;
	
	@Bean
	public JedisCluster getJedisCluster() {
		//分割集群节点
		String[] cNodes = clusterNodes.split(",");
		System.out.println(cNodes);
		//创建set集合
		Set<HostAndPort> nodes = new HashSet<HostAndPort>();
		for(String node:cNodes) {
			String[] hp = node.split(":");
			nodes.add(new HostAndPort(hp[0], Integer.parseInt(hp[1])));
		}
		//创建redis对象
		JedisCluster jedisCluster = new JedisCluster(nodes);
		return jedisCluster;
	}
}
