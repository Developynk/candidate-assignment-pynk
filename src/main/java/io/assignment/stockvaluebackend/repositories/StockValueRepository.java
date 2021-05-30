package io.assignment.stockvaluebackend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.assignment.stockvaluebackend.entities.TblStockValue;

@Repository
public interface StockValueRepository extends JpaRepository<TblStockValue, Integer> {
	
//	@Query("select distinct s.change, s.changeovertime, s.changepercent, s.close, s.date, s.fclose, s.fhigh, s.flow, s.fopen, s.fvolume, s.high, s.id, s.key "
//			+ ", s.label, s.low, s.marketchangeovertime, s.open, s.subkey, s.symbol, s.uclose, s.uhigh, s.ulow, s.uopen, s.uvolume, s.updated, s.volume "
//			+ "from TblStockValue s "
//			+ "where s.symbol = :symbol")
//	public List<TblStockValue> findOnlyBySymbol(@Param("symbol") String symbol);
	
	public List<TblStockValue> findDistinctBySymbol(@Param("symbol") String symbol);

}
