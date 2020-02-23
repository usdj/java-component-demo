package com.usdj.es.dao;

import com.usdj.es.entity.DocBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author gerrydeng
 * @Date 2020/2/14 2:11 PM
 * @Version 0.1
 * @Description: TODO
 */
public interface ElasticRepository extends ElasticsearchRepository<DocBean, Long> {

	@Query("{\"bool\" : {\"must\" : {\"field\" : {\"content\" : \"?\"}}}}")
	Page<DocBean> findByContent(String content, Pageable pageable);

	@Query("{\"bool\" : {\"must\" : {\"field\" : {\"firstCode.keyword\" : \"?\"}}}}")
	Page<DocBean> findByFirstCode(String firstCode, Pageable pageable);

	@Query("{\"bool\" : {\"must\" : {\"field\" : {\"secondCode.keyword\" : \"?\"}}}}")
	Page<DocBean> findBySecondCode(String secondCode, Pageable pageable);

}
