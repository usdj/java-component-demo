package com.usdj.es.service;

import com.usdj.es.dao.ElasticRepository;
import com.usdj.es.entity.DocBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * @Author gerrydeng
 * @Date 2020/2/14 5:58 PM
 * @Version 0.1
 * @Description: TODO
 */
@Service("elasticService")
public class ElasticServiceImpl implements IElasticService{

	@Autowired
	private ElasticsearchRestTemplate elasticsearchRestTemplate;

	@Autowired
	private ElasticRepository elasticRepository;

	private Pageable pageable = PageRequest.of(0,10);

	@Override
	public void createIndex() {
		elasticsearchRestTemplate.createIndex(DocBean.class);
	}

	@Override
	public void deleteIndex(String index) {
		elasticsearchRestTemplate.deleteIndex(index);
	}

	@Override
	public void save(DocBean docBean) {
		elasticRepository.save(docBean);
	}

	@Override
	public void saveAll(List<DocBean> list) {
		elasticRepository.saveAll(list);
	}

	@Override
	public Iterator<DocBean> findAll() {
		return elasticRepository.findAll().iterator();
	}

	@Override
	public Page<DocBean> findByContent(String content) {
		return elasticRepository.findByContent(content,pageable);
	}

	@Override
	public Page<DocBean> findByFirstCode(String firstCode) {
		return elasticRepository.findByFirstCode(firstCode,pageable);
	}

	@Override
	public Page<DocBean> findBySecondCode(String secondCode) {
		return elasticRepository.findBySecondCode(secondCode,pageable);
	}

	@Override
	public Page<DocBean> query(String key) {
		return elasticRepository.findByContent(key,pageable);
	}
}
