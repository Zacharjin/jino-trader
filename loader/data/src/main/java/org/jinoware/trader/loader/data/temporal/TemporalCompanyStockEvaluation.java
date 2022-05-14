package org.jinoware.trader.loader.data.temporal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jinoware.trader.loader.common.model.CompanyName;
import org.jinoware.trader.loader.data.model.IdentifiableByCompanyName;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemporalCompanyStockEvaluation implements IdentifiableByCompanyName {

    CompanyName companyName;

    List<StockTick> ticks;
}
