package tn.esprit.stockservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.stockservice.Entity.Stock;

@Repository
public interface IStockRepository extends JpaRepository<Stock,Long> {
}
