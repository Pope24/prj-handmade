package com.extensions;

public class PagingExtension {
    public static int getEndPage(int totalPage) {
        if (totalPage % 6 == 0) {
            return totalPage/6;
        } else {
            return totalPage/6 + 1;
        }
    }

}
