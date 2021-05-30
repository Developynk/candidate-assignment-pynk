package io.assignment.stockvaluebackend.model;

import lombok.Data;

@Data
public class Chart {
	
	public double close;
    public double high;
    public double low;
    public double open;
    public String symbol;
    public int volume;
    public String id;
    public String key;
    public String subkey;
    public String date;
    public Object updated;
    public double changeOverTime;
    public double marketChangeOverTime;
    public double uOpen;
    public double uClose;
    public double uHigh;
    public double uLow;
    public int uVolume;
    public double fOpen;
    public double fClose;
    public double fHigh;
    public double fLow;
    public int fVolume;
    public String label;
    public double change;
    public double changePercent;

}
