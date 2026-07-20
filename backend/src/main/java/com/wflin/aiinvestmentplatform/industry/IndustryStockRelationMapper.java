package com.wflin.aiinvestmentplatform.industry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IndustryStockRelationMapper {

    private static final List<IndustryStockRelation> STOCK_RELATIONS = Collections.unmodifiableList(Arrays.asList(
            new IndustryStockRelation("688981", "Semiconductor Manufacturing International", 1L),
            new IndustryStockRelation("002371", "NAURA Technology Group", 1L),
            new IndustryStockRelation("300750", "Contemporary Amperex Technology", 2L),
            new IndustryStockRelation("601012", "LONGi Green Energy Technology", 2L),
            new IndustryStockRelation("600276", "Jiangsu Hengrui Pharmaceuticals", 3L),
            new IndustryStockRelation("300122", "Chongqing Zhifei Biological Products", 3L),
            new IndustryStockRelation("688012", "Advanced Micro-Fabrication Equipment", 4L),
            new IndustryStockRelation("688599", "Trina Solar", 5L)
    ));

    public List<IndustryStockRelation> selectByIndustryId(Long industryId) {
        List<IndustryStockRelation> result = new ArrayList<IndustryStockRelation>();
        for (IndustryStockRelation relation : STOCK_RELATIONS) {
            if (relation.getIndustryId().equals(industryId)) {
                result.add(relation);
            }
        }
        return Collections.unmodifiableList(result);
    }
}
