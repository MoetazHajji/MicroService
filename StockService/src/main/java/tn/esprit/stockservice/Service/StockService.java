package tn.esprit.stockservice.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.stockservice.Entity.Product;
import tn.esprit.stockservice.Entity.Stock;
import tn.esprit.stockservice.Exception.ElementNotFoundException;
import tn.esprit.stockservice.Exception.NoProductException;
import tn.esprit.stockservice.Exception.OutOfStockException;
import tn.esprit.stockservice.Interface.IProductService;
import tn.esprit.stockservice.Interface.IStockService;
import tn.esprit.stockservice.Repository.IProductRepository;
import tn.esprit.stockservice.Repository.IStockRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class StockService implements IStockService {
    IStockRepository stockRepository;
    IProductRepository productRepository;

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

    @Override
    public Stock withdrawStock(Double quantity, Long idstock) {
        Stock stock = stockRepository.findById(idstock).orElseThrow(() -> new ElementNotFoundException("Stock with id " + idstock + " not found : "));
        Double newQuantity = stock.getTotal_quantity() - quantity;
        Double newFreeQuantity = stock.getFree_storage() + quantity;
        Double newUsedQuantity = stock.getUsed_storage() - quantity;
        stock.setTotal_quantity(newQuantity);
        stock.setFree_storage(newFreeQuantity);
        stock.setUsed_storage(newUsedQuantity);
        for (Product product : stock.getProducts()) {
            if (product.getQuantity() < 0 || stock.getFree_storage() < 0 || stock.getUsed_storage() < 0 || stock.getTotal_quantity() < 0) {
                throw new NoProductException("quantity and Storage cannot be negative");
            }
            if (stock.getFree_storage() >= stock.getStorage() || stock.getUsed_storage() >= stock.getStorage()) {
                throw new OutOfStockException("Free and used storage can't over pass total storage ");
            }
        }
        stockRepository.save(stock);
        return stock;
    }

    @Override
    @Transactional
    public Stock addProductToStock(Long id, Long idProduct) {
        Stock stock = this.stockRepository.findById(id).orElseThrow(() -> new ElementNotFoundException("Stock with id " + id + " not found : "));
        Product product = this.productRepository.findById(idProduct).orElseThrow(() -> new ElementNotFoundException("Product with id " + idProduct + " not found : "));
        System.out.println("Product: " + product.toString() + "Stock: " + stock.toString());
        this.stockRepository.save(stock);
        if (stock.getProducts() == null) {
            //            Long nbquantity = stock.getNbProduct();
//            nbquantity = nbquantity + quantity;
//            Long productQuantity = product.getQuantity();
//            productQuantity = productQuantity - quantity;
//            stock.setNbProduct(nbquantity);
            Set<Product> productList = new HashSet<>();
            productList.add(product);
            stock.setProducts(productList);
        } else {
            stock.getProducts().add(product);
        }


        return stock;
    }

}
