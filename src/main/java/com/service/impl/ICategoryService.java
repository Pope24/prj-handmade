package com.service.impl;

import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ICategoryService {
    Map<String, ?> getInformationProductSearch(String search, String page);
    Map<String, ?> getProductFilter(String[] brands, String[] types, String minPrice, String maxPrice, String page, String queryURL);
    Map<String, ?> getProductSearchByImage(String imageUpload) throws IOException;
}
