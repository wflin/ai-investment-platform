package com.wflin.aiinvestmentplatform.stock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class StockService {

    private static final List<Stock> STOCKS = Collections.unmodifiableList(Arrays.asList(
            new Stock("600519", "Kweichow Moutai", "Consumer Staples", "Shanghai Stock Exchange"),
            new Stock("300750", "Contemporary Amperex Technology", "Renewable Energy", "Shenzhen Stock Exchange"),
            new Stock("688981", "Semiconductor Manufacturing International", "Semiconductors",
                    "Shanghai Stock Exchange STAR Market")
    ));

    public List<Stock> findAll(String industry) {
        if (!StringUtils.hasText(industry)) {
            return STOCKS;
        }

        String normalizedIndustry = industry.trim().toLowerCase(Locale.ENGLISH);
        List<Stock> filteredStocks = new ArrayList<Stock>();
        for (Stock stock : STOCKS) {
            if (stock.getIndustry().toLowerCase(Locale.ENGLISH).equals(normalizedIndustry)) {
                filteredStocks.add(stock);
            }
        }
        return Collections.unmodifiableList(filteredStocks);
    }

    public Optional<Stock> findByCode(String code) {
        if (!StringUtils.hasText(code)) {
            return Optional.empty();
        }

        String normalizedCode = code.trim();
        for (Stock stock : STOCKS) {
            if (stock.getCode().equals(normalizedCode)) {
                return Optional.of(stock);
            }
        }
        return Optional.empty();
    }
}
