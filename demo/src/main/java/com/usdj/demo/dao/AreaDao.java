package com.usdj.demo.dao;

import com.usdj.demo.entity.Area;

import java.util.List;

/**
 * The interface Area dao.
 *
 * @author gerrydeng
 * @date 2019 -07-29 13:20
 * @Description:
 */
public interface AreaDao {
	/**
	 * Query area list.
	 *
	 * @return the list
	 */
	List<Area> queryArea();

	/**
	 * Query area by id area.
	 *
	 * @param areaId the area id
	 * @return the area
	 */
	Area queryAreaById(int areaId);

	/**
	 * Insert area int.
	 *
	 * @param area the area
	 * @return the int
	 */
	int insertArea(Area area);

	/**
	 * Update area int.
	 *
	 * @param area the area
	 * @return the int
	 */
	int updateArea(Area area);

	/**
	 * Delete area int.
	 *
	 * @param areaId the area id
	 * @return the int
	 */
	int deleteArea(int areaId);
}
