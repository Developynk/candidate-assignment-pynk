package io.assignment.stockvaluebackend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity @Data
@Table(name = "tbl_stock_value")
public class TblStockValue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "seq")
	public Integer seq;
	
	@Column(name = "close")
	public double close;
	
	@Column(name = "high")
    public double high;
	
	@Column(name = "low")
    public double low;
	
	@Column(name = "open")
    public double open;
	
	@Column(name = "symbol")
    public String symbol;
	
	@Column(name = "volume")
    public int volume;
	
	@Column(name = "id")
    public String id;
	
	@Column(name = "key")
    public String key;
	
	@Column(name = "subkey")
    public String subkey;
	
	@Column(name = "date")
    public String date;
	
	@Column(name = "updated")
    public Integer updated;
	
	@Column(name = "changeovertime")
    public double changeOverTime;
	
	@Column(name = "marketchangeovertime")
    public double marketChangeOverTime;
	
	@Column(name = "uopen")
    public double uOpen;
	
	@Column(name = "uclose")
    public double uClose;
	
	@Column(name = "uhigh")
    public double uHigh;
	
	@Column(name = "ulow")
    public double uLow;
	
	@Column(name = "uvolume")
    public int uVolume;
	
	@Column(name = "fopen")
    public double fOpen;
	
	@Column(name = "fclose")
    public double fClose;
	
	@Column(name = "fhigh")
    public double fHigh;
	
	@Column(name = "flow")
    public double fLow;
	
	@Column(name = "fvolume")
    public int fVolume;
	
	@Column(name = "label")
    public String label;
	
	@Column(name = "change")
    public double change;
	
	@Column(name = "changepercent")
    public double changePercent;

}
