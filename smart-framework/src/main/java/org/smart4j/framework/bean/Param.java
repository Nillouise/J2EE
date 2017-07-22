package org.smart4j.framework.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.smart4j.framework.util.CastUtil;
import org.smart4j.framework.util.CollectionUtil;
import org.smart4j.framework.util.StringUtil;

/**
 * 请求参数对象
 *
 * @author huangyong
 * @since 1.0.0
 */
//自定义controller用来接收参数的东西
public class Param {
    private Map<String,Object> paramMap;
    public Param(Map<String,Object> paramMap)
    {
        this.paramMap = paramMap;
    }
    public long getLong(String name)
    {
        return CastUtil.castLong(paramMap.get(name));
    }

    public Map<String,Object> getMap()
    {
        return paramMap;
    }



}
