package com.usdj.es.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @Author gerrydeng
 * @Date 2020/2/14 12:15 AM
 * @Version 0.1
 * @Description: TODO
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@Document(indexName = "ems", type = "_doc", shards = 1, replicas = 0)
public class DocBean {

	@Id
	private Long id;

	@Field(type = FieldType.Keyword)
	private String firstCode;

	@Field(type = FieldType.Keyword)
	private String secondCode;

	@Field(type = FieldType.Text)
	private String content;

	@Field(type = FieldType.Integer)
	private Integer type;

	public DocBean(Long id, String firstCode, String secondCode, String content, Integer type) {
		this.id = id;
		this.firstCode = firstCode;
		this.secondCode = secondCode;
		this.content = content;
		this.type = type;
	}
}
