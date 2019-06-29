package com.company.project.util;


import com.ipampas.framework.model.Page;

import java.util.Collections;
import java.util.List;

/**
 * @author liulu
 * @version 1.0.0
 * @date 2019/6/29 8:07 PM
 */
public class PageUtils {

    public static <T> Page<T> transToPage(List<T> list) {
        //
        Page<T> result = new Page<>();
        result.setPageRecords(list);
        result.setTotalRecords((long) list.size());
        //
        if (list instanceof com.github.pagehelper.Page) {
            com.github.pagehelper.Page page = (com.github.pagehelper.Page) list;
            result.setPageNo(page.getPageNum());
            result.setPageSize(page.getPageSize());
            result.setTotalRecords(page.getTotal());
        }
        return result;
    }

    public static <S, T> Page<T> convertToPage(Class<T> targetClass, List<S> sourceList) {
        return convertToPage(targetClass, sourceList, null);
    }

    public static <S, T> Page<T> convertToPage(Class<T> targetClass, List<S> sourceList, BeanTools.ConvertCallBack<S, T> convertCallBack) {
        Page<S> sPage = transToPage(sourceList);
        return convertPage(targetClass, sPage, convertCallBack);
    }

    public static <S, T> Page<T> convertPage(Class<T> targetClass, Page<S> sourcePage) {
        return convertPage(targetClass, sourcePage, null);
    }

    public static <S, T> Page<T> convertPage(Class<T> targetClass, Page<S> sourcePage, BeanTools.ConvertCallBack<S, T> convertCallBack) {
        //
        Page<T> result = new Page<>(sourcePage.getPageNo(), sourcePage.getPageSize());
        result.setTotalRecords(sourcePage.getTotalRecords());
        //
        List<S> sourceRecords = sourcePage.getPageRecords();
        if (sourceRecords == null || sourceRecords.isEmpty()) {
            result.setPageRecords(Collections.emptyList());
        } else {
            result.setPageRecords(BeanTools.convert(targetClass, sourceRecords, convertCallBack));
        }
        return result;
    }

    public static <T> Page<T> emptyPage() {
        Page<T> result = new Page<>();
        result.setPageNo(1);
        result.setTotalRecords(0L);
        result.setPageRecords(Collections.emptyList());
        return result;
    }


}
