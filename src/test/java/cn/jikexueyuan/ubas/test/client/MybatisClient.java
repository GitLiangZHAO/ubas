package cn.jikexueyuan.ubas.test.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jikexueyuan.ubas.dao.KpiDao;
import cn.jikexueyuan.ubas.domain.ReportParam;
import cn.jikexueyuan.ubas.util.MySQLFactory;

/**
 * @Date May 27, 2015dfsadfadf
 *
 * @Author dengjie
 *
 * @Note TODO
 */
public class MybatisClient {

	private static Logger LOGGER = LoggerFactory.getLogger(MybatisClient.class);

	public static void main(String[] args) {
		try {
			ReportParam param = new ReportParam();
			param.setBeginDate("2015-5-25");
			param.setEndDate("2015-5-26");
			LOGGER.info("get ubas day:" + ((KpiDao) MySQLFactory.createMapper(KpiDao.class)).getSummary(param));
			LOGGER.info("get amount hour:" + ((KpiDao) MySQLFactory.createMapper(KpiDao.class)).getAmount(param));
			List<Map<Double, Double>> list = ((KpiDao) MySQLFactory.createMapper(KpiDao.class)).getAmount(param);
			System.out.println(list.toString());
			Map<Double, Double> map2 = new HashMap<Double, Double>();
			for (Map<Double, Double> map : list) {
				map2.put(map.get("kpi_code"), map.get("kpi_value"));
			}
			System.out.println(map2.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
