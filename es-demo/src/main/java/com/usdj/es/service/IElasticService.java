package com.usdj.es.service;

import com.usdj.es.entity.DocBean;
import org.springframework.data.domain.Page;

import java.util.Iterator;
import java.util.List;

/**
 * @Author gerrydeng
 * @Date 2020/2/14 5:56 PM
 * @Version 0.1
 * @Description: TODO
 */
public interface IElasticService {

	void createIndex();

	void deleteIndex(String index);

	void save(DocBean docBean);

	void saveAll(List<DocBean> list);

	Iterator<DocBean> findAll();

	Page<DocBean> findByContent(String content);

	Page<DocBean> findByFirstCode(String firstCode);

	Page<DocBean> findBySecondCode(String secondCode);

	Page<DocBean> query(String key);

}
