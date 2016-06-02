package cn.jikexueyuan.ubas.domain;

import com.google.gson.Gson;

/**
 * @Date Mar 25, 2015  1.0 bug fixed test
 *
 * @Author dengjie
 *
 * @Note TODO
 */
public class ReportParam {
	private String beginDate;
	private String endDate;

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
