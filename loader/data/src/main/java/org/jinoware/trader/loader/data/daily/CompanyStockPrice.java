package org.jinoware.trader.loader.data.daily;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jinoware.trader.loader.api.CompanyName;
import org.jinoware.trader.loader.price.StockPrice;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyStockPrice {
    public static CompanyStockPrice createEmpty(){
        return new CompanyStockPrice(new CompanyName(""),
                StockPrice.createEmpty());
    }

    CompanyName companyName;

    StockPrice price;

}
