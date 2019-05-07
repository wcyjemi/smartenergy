package xin.cymall.vo;

import java.math.BigDecimal;

public class EnRealDataTableVo {
    private String pointName;
    private BigDecimal maxValue;
    private String maxDataTime;
    private BigDecimal minValue;
    private String minDataTime;
    private BigDecimal avgVal;
    private BigDecimal dataPer;

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public BigDecimal getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(BigDecimal maxValue) {
        this.maxValue = maxValue;
    }

    public String getMaxDataTime() {
        return maxDataTime;
    }

    public void setMaxDataTime(String maxDataTime) {
        this.maxDataTime = maxDataTime;
    }

    public BigDecimal getMinValue() {
        return minValue;
    }

    public void setMinValue(BigDecimal minValue) {
        this.minValue = minValue;
    }

    public String getMinDataTime() {
        return minDataTime;
    }

    public void setMinDataTime(String minDataTime) {
        this.minDataTime = minDataTime;
    }

    public BigDecimal getAvgVal() {
        return avgVal;
    }

    public void setAvgVal(BigDecimal avgVal) {
        this.avgVal = avgVal;
    }

    public BigDecimal getDataPer() {
        return dataPer;
    }

    public void setDataPer(BigDecimal dataPer) {
        this.dataPer = dataPer;
    }
}
