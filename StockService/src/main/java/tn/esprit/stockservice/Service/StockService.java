package tn.esprit.stockservice.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.stockservice.Entity.Stock;
import tn.esprit.stockservice.Interface.IStockService;
import tn.esprit.stockservice.Repository.IStockRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class StockService implements IStockService {
    IStockRepository stockRepository;

    @Override
    public Stock addStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock modifyStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }

    @Override
    public Stock getStockById(Long id) {
        return stockRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Stock> getAllStock() {
        Set<Stock> stockList = new HashSet<>();
        stockRepository.findAll().forEach(stockList::add);
        return stockList;
    }
}
