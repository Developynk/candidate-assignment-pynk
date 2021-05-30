package io.assignment.stockvaluebackend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.assignment.stockvaluebackend.entities.TblStockValue;

@Repository
public interface StockValueRepository extends JpaRepository<TblStockValue, Integer> {
	
	public List<TblStockValue> findDistinctBySymbol(@Param("symbol") String symbol);

}
