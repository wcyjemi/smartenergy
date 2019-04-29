package xin.cymall.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 电能实时数据
 * 
 * @author wcy
 * @email 3304737387@qq.com
 * @date 2019-04-27 00:41:08
 */
public class EnElecBaseData implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/****/
	private String id;
	/****/
	private String pointId;
	/****/
	private Date dataTime;
	/**正向有功总电量**/
	private BigDecimal eleFa;
	/**正向无功总电量**/
	private BigDecimal eleFr;
	/**反向有功总电量**/
	private BigDecimal eleRa;
	/**反向无功总电量**/
	private BigDecimal eleRr;
	/**总有功功率**/
	private BigDecimal powAt;
	/**A相有功功率**/
	private BigDecimal powAa;
	/**B相有功功率**/
	private BigDecimal powAb;
	/**C相有功功率**/
	private BigDecimal powAc;
	/**总无功功率**/
	private BigDecimal powRt;
	/**A相无功功率**/
	private BigDecimal powRa;
	/**B相无功功率**/
	private BigDecimal powRb;
	/**C相无功功率**/
	private BigDecimal powRc;
	/**总功率因数**/
	private BigDecimal powfT;
	/**A相功率因数**/
	private BigDecimal powfA;
	/**B相功率因数**/
	private BigDecimal powfB;
	/**C相功率因数**/
	private BigDecimal powfC;
	/**A相电压**/
	private BigDecimal volA;
	/**B相电压**/
	private BigDecimal volB;
	/**C相电压**/
	private BigDecimal volC;
	/**A相电流**/
	private BigDecimal curA;
	/**B相电流**/
	private BigDecimal curB;
	/**C相电流**/
	private BigDecimal curC;
	/**A相电压相位角**/
	private BigDecimal vpaA;
	/**B相电压相位角**/
	private BigDecimal vpaB;
	/**C相电压相位角**/
	private BigDecimal vpaC;
	/**A相电流相位角**/
	private BigDecimal cpaA;
	/**B相电流相位角**/
	private BigDecimal cpaB;
	/****/
	private BigDecimal cpaC;
	/**有功总需量**/
	private BigDecimal xlTo;
	/**发生时间**/
	private Date xlTodt;
	/**有功尖费率**/
	private BigDecimal xlPi;
	/**有功尖费率发生时间**/
	private Date xlPidt;
	/**有功峰费率数值**/
	private BigDecimal xlPe;
	/**有功峰费率发生时间**/
	private Date xlPedt;
	/**有功平费率数值**/
	private BigDecimal xlFl;
	/**有功峰费率发生时间**/
	private Date xlFldt;
	/**有功谷费率数值**/
	private BigDecimal xlVa;
	/**有功谷费率发生时间**/
	private Date xlVadt;
	/**无功总需量**/
	private BigDecimal xlfrTo;
	/**无功发生时间**/
	private Date xlfrTodt;
	/**无功尖费率**/
	private BigDecimal xlfrPi;
	/**无功尖费率发生时间**/
	private Date xlfrPidt;
	/**无功峰费率数值**/
	private BigDecimal xlfrPe;
	/**无功峰费率发生时间**/
	private Date xlfrPedt;
	/**无功平费率数值**/
	private BigDecimal xlfrFl;
	/**无功峰费率发生时间**/
	private Date xlfrFldt;
	/**无功谷费率数值**/
	private BigDecimal xlfrVa;
	/**无功谷费率发生时间**/
	private Date xlfrVadt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPointId() {
		return pointId;
	}

	public void setPointId(String pointId) {
		this.pointId = pointId;
	}

	public Date getDataTime() {
		return dataTime;
	}

	public void setDataTime(Date dataTime) {
		this.dataTime = dataTime;
	}

	public BigDecimal getEleFa() {
		return eleFa;
	}

	public void setEleFa(BigDecimal eleFa) {
		this.eleFa = eleFa;
	}

	public BigDecimal getEleFr() {
		return eleFr;
	}

	public void setEleFr(BigDecimal eleFr) {
		this.eleFr = eleFr;
	}

	public BigDecimal getEleRa() {
		return eleRa;
	}

	public void setEleRa(BigDecimal eleRa) {
		this.eleRa = eleRa;
	}

	public BigDecimal getEleRr() {
		return eleRr;
	}

	public void setEleRr(BigDecimal eleRr) {
		this.eleRr = eleRr;
	}

	public BigDecimal getPowAt() {
		return powAt;
	}

	public void setPowAt(BigDecimal powAt) {
		this.powAt = powAt;
	}

	public BigDecimal getPowAa() {
		return powAa;
	}

	public void setPowAa(BigDecimal powAa) {
		this.powAa = powAa;
	}

	public BigDecimal getPowAb() {
		return powAb;
	}

	public void setPowAb(BigDecimal powAb) {
		this.powAb = powAb;
	}

	public BigDecimal getPowAc() {
		return powAc;
	}

	public void setPowAc(BigDecimal powAc) {
		this.powAc = powAc;
	}

	public BigDecimal getPowRt() {
		return powRt;
	}

	public void setPowRt(BigDecimal powRt) {
		this.powRt = powRt;
	}

	public BigDecimal getPowRa() {
		return powRa;
	}

	public void setPowRa(BigDecimal powRa) {
		this.powRa = powRa;
	}

	public BigDecimal getPowRb() {
		return powRb;
	}

	public void setPowRb(BigDecimal powRb) {
		this.powRb = powRb;
	}

	public BigDecimal getPowRc() {
		return powRc;
	}

	public void setPowRc(BigDecimal powRc) {
		this.powRc = powRc;
	}

	public BigDecimal getPowfT() {
		return powfT;
	}

	public void setPowfT(BigDecimal powfT) {
		this.powfT = powfT;
	}

	public BigDecimal getPowfA() {
		return powfA;
	}

	public void setPowfA(BigDecimal powfA) {
		this.powfA = powfA;
	}

	public BigDecimal getPowfB() {
		return powfB;
	}

	public void setPowfB(BigDecimal powfB) {
		this.powfB = powfB;
	}

	public BigDecimal getPowfC() {
		return powfC;
	}

	public void setPowfC(BigDecimal powfC) {
		this.powfC = powfC;
	}

	public BigDecimal getVolA() {
		return volA;
	}

	public void setVolA(BigDecimal volA) {
		this.volA = volA;
	}

	public BigDecimal getVolB() {
		return volB;
	}

	public void setVolB(BigDecimal volB) {
		this.volB = volB;
	}

	public BigDecimal getVolC() {
		return volC;
	}

	public void setVolC(BigDecimal volC) {
		this.volC = volC;
	}

	public BigDecimal getCurA() {
		return curA;
	}

	public void setCurA(BigDecimal curA) {
		this.curA = curA;
	}

	public BigDecimal getCurB() {
		return curB;
	}

	public void setCurB(BigDecimal curB) {
		this.curB = curB;
	}

	public BigDecimal getCurC() {
		return curC;
	}

	public void setCurC(BigDecimal curC) {
		this.curC = curC;
	}

	public BigDecimal getVpaA() {
		return vpaA;
	}

	public void setVpaA(BigDecimal vpaA) {
		this.vpaA = vpaA;
	}

	public BigDecimal getVpaB() {
		return vpaB;
	}

	public void setVpaB(BigDecimal vpaB) {
		this.vpaB = vpaB;
	}

	public BigDecimal getVpaC() {
		return vpaC;
	}

	public void setVpaC(BigDecimal vpaC) {
		this.vpaC = vpaC;
	}

	public BigDecimal getCpaA() {
		return cpaA;
	}

	public void setCpaA(BigDecimal cpaA) {
		this.cpaA = cpaA;
	}

	public BigDecimal getCpaB() {
		return cpaB;
	}

	public void setCpaB(BigDecimal cpaB) {
		this.cpaB = cpaB;
	}

	public BigDecimal getCpaC() {
		return cpaC;
	}

	public void setCpaC(BigDecimal cpaC) {
		this.cpaC = cpaC;
	}

	public BigDecimal getXlTo() {
		return xlTo;
	}

	public void setXlTo(BigDecimal xlTo) {
		this.xlTo = xlTo;
	}

	public Date getXlTodt() {
		return xlTodt;
	}

	public void setXlTodt(Date xlTodt) {
		this.xlTodt = xlTodt;
	}

	public BigDecimal getXlPi() {
		return xlPi;
	}

	public void setXlPi(BigDecimal xlPi) {
		this.xlPi = xlPi;
	}

	public Date getXlPidt() {
		return xlPidt;
	}

	public void setXlPidt(Date xlPidt) {
		this.xlPidt = xlPidt;
	}

	public BigDecimal getXlPe() {
		return xlPe;
	}

	public void setXlPe(BigDecimal xlPe) {
		this.xlPe = xlPe;
	}

	public Date getXlPedt() {
		return xlPedt;
	}

	public void setXlPedt(Date xlPedt) {
		this.xlPedt = xlPedt;
	}

	public BigDecimal getXlFl() {
		return xlFl;
	}

	public void setXlFl(BigDecimal xlFl) {
		this.xlFl = xlFl;
	}

	public Date getXlFldt() {
		return xlFldt;
	}

	public void setXlFldt(Date xlFldt) {
		this.xlFldt = xlFldt;
	}

	public BigDecimal getXlVa() {
		return xlVa;
	}

	public void setXlVa(BigDecimal xlVa) {
		this.xlVa = xlVa;
	}

	public Date getXlVadt() {
		return xlVadt;
	}

	public void setXlVadt(Date xlVadt) {
		this.xlVadt = xlVadt;
	}

	public BigDecimal getXlfrTo() {
		return xlfrTo;
	}

	public void setXlfrTo(BigDecimal xlfrTo) {
		this.xlfrTo = xlfrTo;
	}

	public Date getXlfrTodt() {
		return xlfrTodt;
	}

	public void setXlfrTodt(Date xlfrTodt) {
		this.xlfrTodt = xlfrTodt;
	}

	public BigDecimal getXlfrPi() {
		return xlfrPi;
	}

	public void setXlfrPi(BigDecimal xlfrPi) {
		this.xlfrPi = xlfrPi;
	}

	public Date getXlfrPidt() {
		return xlfrPidt;
	}

	public void setXlfrPidt(Date xlfrPidt) {
		this.xlfrPidt = xlfrPidt;
	}

	public BigDecimal getXlfrPe() {
		return xlfrPe;
	}

	public void setXlfrPe(BigDecimal xlfrPe) {
		this.xlfrPe = xlfrPe;
	}

	public Date getXlfrPedt() {
		return xlfrPedt;
	}

	public void setXlfrPedt(Date xlfrPedt) {
		this.xlfrPedt = xlfrPedt;
	}

	public BigDecimal getXlfrFl() {
		return xlfrFl;
	}

	public void setXlfrFl(BigDecimal xlfrFl) {
		this.xlfrFl = xlfrFl;
	}

	public Date getXlfrFldt() {
		return xlfrFldt;
	}

	public void setXlfrFldt(Date xlfrFldt) {
		this.xlfrFldt = xlfrFldt;
	}

	public BigDecimal getXlfrVa() {
		return xlfrVa;
	}

	public void setXlfrVa(BigDecimal xlfrVa) {
		this.xlfrVa = xlfrVa;
	}

	public Date getXlfrVadt() {
		return xlfrVadt;
	}

	public void setXlfrVadt(Date xlfrVadt) {
		this.xlfrVadt = xlfrVadt;
	}
}
