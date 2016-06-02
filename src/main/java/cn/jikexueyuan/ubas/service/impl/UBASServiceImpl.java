package cn.jikexueyuan.ubas.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.thrift.TException;

import cn.jikexueyuan.ubas.dao.KpiDao;
import cn.jikexueyuan.ubas.domain.ReportParam;
import cn.jikexueyuan.ubas.service.UBASService;
import cn.jikexueyuan.ubas.util.MySQLFactory;

/**
 * @Date May 27, 2015
 *
 * @Author dengjie
 *
 * @Note TODO
 */
public class UBASServiceImpl implements UBASService.Iface {

	public Map<String, Double> queryDayKPI(String beginDate, String endDate) throws TException {
		ReportParam param = new ReportParam();
		param.setBeginDate(beginDate);
		param.setEndDate(endDate);
		return ((KpiDao) MySQLFactory.createMapper(KpiDao.class)).getSummary(param);
	}

	public Map<Double, Double> queryHourKPI(String beginDate, String endDate) throws TException {
		ReportParam param = new ReportParam();
		param.setBeginDate(beginDate);
		param.setEndDate(endDate);

		Map<Double, Double> map = new HashMap<Double, Double>();
		List<Map<Double, Double>> list = ((KpiDao) MySQLFactory.createMapper(KpiDao.class)).getAmount(param);
		for (Map<Double, Double> map2 : list) {
			map.put(map2.get("kpi_code"), map2.get("kpi_value"));
		}
		return map;
	}

}
