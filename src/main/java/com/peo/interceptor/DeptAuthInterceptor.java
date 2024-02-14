package com.peo.interceptor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.handler.DataPermissionHandler;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;



public class DeptAuthInterceptor implements DataPermissionHandler {

    @Override
    public Expression getSqlSegment(Expression where, String mappedStatementId) {
        System.out.println("拦截执行了！" + where);

        try {
            Expression expression = CCJSqlParserUtil.parseCondExpression("1 = 1");
            if (null == where) {
                //设置where
                EqualsTo equals = new EqualsTo();
                equals.withRightExpression(new LongValue(1));
                equals.withLeftExpression(new LongValue(1));
                return equals;
            }
            //添加and sql
            return new AndExpression(where, expression);

        } catch (JSQLParserException e) {
            throw new RuntimeException(e);
        }
    }
}
