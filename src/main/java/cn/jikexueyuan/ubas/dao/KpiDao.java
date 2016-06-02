package cn.jikexueyuan.ubas.dao;

import java.util.List;
import java.util.Map;

import cn.jikexueyuan.ubas.domain.ReportParam;
import cn.jikexueyuan.ubas.service.Mapper;

/**
 * @Date Mar 24, 2015
 *
 * @Author dengjie
 *
 * @Note TODO
 */
public interface KpiDao extends Mapper {
	/**
	 * get amount data list
	 * 
	 * @param param
	 * @return Object list
	 */
	public List<Map<Double, Double>> getAmount(ReportParam param);

	/**
	 * get ubas summary data list
	 * 
	 * @param param
	 * @return more result
	 */
	public Map<String, Double> getSummary(ReportParam param);

}
