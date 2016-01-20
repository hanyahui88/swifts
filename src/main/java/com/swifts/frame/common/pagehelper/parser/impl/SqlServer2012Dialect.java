package com.swifts.frame.common.pagehelper.parser.impl;

import com.swifts.frame.common.pagehelper.Page;
import com.swifts.frame.common.pagehelper.parser.impl.*;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;

import java.util.Map;

/**
 * Take note that at least one column
 * needs to be defined for ORDER BY
 * in oder for OFFSET .. ROWS to work
 */
public class SqlServer2012Dialect extends com.swifts.frame.common.pagehelper.parser.impl.AbstractParser {

    @Override
    public String getPageSql(String sql) {
        StringBuilder sqlBuilder = new StringBuilder(sql.length() + 14);
        sqlBuilder.append(sql);
        sqlBuilder.append(" OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
        return sqlBuilder.toString();
    }

    @Override
    public Map<String, Object> setPageParameter(MappedStatement ms, Object parameterObject, BoundSql boundSql, Page<?> page) {
        Map<String, Object> paramMap = super.setPageParameter(ms, parameterObject, boundSql, page);
        // OFFSET (@PageNumber-1)*@RowsPerPage ROWS
        paramMap.put(PAGEPARAMETER_FIRST, page.getStartRow());
        paramMap.put(PAGEPARAMETER_SECOND, page.getPageSize());
        return paramMap;
    }

}
