package com.service.impl;

import java.math.BigDecimal;
import java.util.Map;

public interface ICategoryService {
    Map<String, ?> getInformationProductSearch(String search, String page);
    Map<String, ?> getProductFilter(String[] brands, String[] types, String minPrice, String maxPrice, String page, String queryURL);
}
