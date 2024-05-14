package com.service.impl;

import java.util.Map;

public interface ICategoryService {
    Map<String, ?> getInformationProductSearch(String search, int page);
}
