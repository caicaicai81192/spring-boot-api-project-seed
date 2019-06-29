package com.company.project.util;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liulu
 * @version 1.0.0
 * @date 2019/6/29 8:08 PM
 */
public class BeanTools {

    public static <S, T> T convert(S source, T target) {
        return convert(source, target, null);
    }

    public static <S, T> T convert(S source, T target, String[] ignoreProperties) {
        return convert(source, target, ignoreProperties, null);
    }

    private static <S, T> T convert(S source, T target, String[] ignoreProperties, ConvertCallBack<S, T> convertCallBack) {
        if (source == null || target == null) {
            return target;
        }
        BeanUtils.copyProperties(source, target, ignoreProperties);
        if (convertCallBack != null) {
            convertCallBack.callBack(source, target);
        }
        return target;
    }

    public static <S, T> List<T> convert(Class<T> clazz, List<S> sources) {
        return convert(clazz, sources, (ConvertCallBack<S, T>) null);
    }

    public static <S, T> List<T> convert(Class<T> clazz, List<S> sources, ConvertCallBack<S, T> convertCallBack) {
        //
        if (sources == null || sources.isEmpty()) {
            return Collections.emptyList();
        }
        //
        List<T> result = new ArrayList<>(sources.size());
        for (S source : sources) {
            T target = null;
            try {
                target = clazz.newInstance();
            } catch (Exception e) {
                // do nothing
            }
            if (target != null) {
                result.add(convert(source, target, null, convertCallBack));
            }
        }
        return result;
    }

    public interface ConvertCallBack<S, T> {
        void callBack(S source, T target);
    }
}
