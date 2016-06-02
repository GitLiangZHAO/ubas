package cn.jikexueyuan.ubas.test.client;

import java.util.Map;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import cn.jikexueyuan.ubas.service.UBASService;

/**
 * @Date Mar 23, 2015
 *
 * @Author dengjie
 * 
 * @Note Test thrift client
 */
public class StatsClient {

	public static final String ADDRESS = "10.211.55.18";
	public static final int PORT = 9090;
	public static final int TIMEOUT = 30000;

	public static void main(String[] args) {
		TTransport transport = new TFramedTransport(new TSocket(ADDRESS, PORT, TIMEOUT));
		TProtocol protocol = new TCompactProtocol(transport);
		UBASService.Client client = new UBASService.Client(protocol);
		String beginDate = "20150525";
		String endDate = "20150526";

		try {
			transport.open();
			Map<String, Double> dayKpi = client.queryDayKPI(beginDate, endDate);
			System.out.println("dayKpi:" + dayKpi.toString());

			Map<Double, Double> hourKpi = client.queryHourKPI(beginDate, endDate);
			System.out.println("hourKpi:" + hourKpi);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			transport.close();
		}
	}

}
