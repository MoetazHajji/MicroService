package tn.esprit.stockservice.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.stockservice.Interface.IStockService;

@RestController
@AllArgsConstructor
@RequestMapping("/stock")
public class StockController {

    IStockService stockService;


}
