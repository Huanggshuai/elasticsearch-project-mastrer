package com.es.demo.esdemo.esresposity;

import com.es.demo.esdemo.domain.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.support.ElasticsearchEntityInformation;

import java.util.List;

/**
 * @Author: huangS
 * @ClassName: Esresposity
 * @Description: TODO
 * @DateTime: 2023/7/28-20:10
 * @Version: 1.0
 **/
public interface Esresposity extends ElasticsearchRepository<User,Integer> {
}
