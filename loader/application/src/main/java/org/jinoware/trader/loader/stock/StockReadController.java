package org.jinoware.trader.loader.stock;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockReadController {

    @GetMapping("/stocks/")
    public List<StockValue> findBy(){
        return null;
    }


}
