package com.usdj.es.controller;

import com.usdj.es.entity.DocBean;
import com.usdj.es.service.IElasticService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author gerrydeng
 * @Date 2020/2/14 6:14 PM
 * @Version 0.1
 * @Description: TODO
 */
@Log4j2
@RestController
@RequestMapping("/elastic")
public class ElasticController {

	@Autowired
	private IElasticService elasticService;

	@GetMapping("/init")
	public void init(){
		elasticService.createIndex();
		List<DocBean> list = new ArrayList<>();
		list.add(new DocBean(1L,"XX0193","XX8064","xxxxxx",1));
		list.add(new DocBean(2L,"XX0210","XX7475","xxxxxxxxxx",1));
		list.add(new DocBean(3L,"XX0257","XX8097","xxxxxxxxxxxxxxxxxx",1));
		elasticService.saveAll(list);
	}

	@GetMapping("/all")
	public Iterator<DocBean> all() {
		return elasticService.findAll();
	}
}
