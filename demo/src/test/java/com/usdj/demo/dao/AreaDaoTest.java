package com.usdj.demo.dao;

import com.usdj.demo.entity.Area;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author gerrydeng
 * @date 2019-07-29 13:43
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

	@Autowired
	private AreaDao areaDao;

	@Test
	public void queryArea() {
		List<Area> areas = areaDao.queryArea();
		Assert.assertEquals(2, areas.size());
	}

	@Test
	public void queryAreaById() {
	}

	@Test
	public void insertArea() {
	}

	@Test
	public void updateArea() {
	}

	@Test
	public void deleteArea() {
	}
}