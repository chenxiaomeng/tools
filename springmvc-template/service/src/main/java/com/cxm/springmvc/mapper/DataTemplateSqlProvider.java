package com.cxm.springmvc.mapper;

import com.cxm.springmvc.entity.DataTemplate;
import com.cxm.springmvc.entity.DataTemplateExample.Criteria;
import com.cxm.springmvc.entity.DataTemplateExample.Criterion;
import com.cxm.springmvc.entity.DataTemplateExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class DataTemplateSqlProvider {

    public String countByExample(DataTemplateExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("data_template");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(DataTemplateExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("data_template");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(DataTemplate record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("data_template");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getNameZh() != null) {
            sql.VALUES("name_zh", "#{nameZh,jdbcType=VARCHAR}");
        }
        
        if (record.getNameEn() != null) {
            sql.VALUES("name_en", "#{nameEn,jdbcType=VARCHAR}");
        }
        
        if (record.getOwner() != null) {
            sql.VALUES("owner", "#{owner,jdbcType=VARCHAR}");
        }
        
        if (record.getOwnerName() != null) {
            sql.VALUES("owner_name", "#{ownerName,jdbcType=VARCHAR}");
        }
        
        if (record.getIsDeploy() != null) {
            sql.VALUES("is_deploy", "#{isDeploy,jdbcType=INTEGER}");
        }
        
        if (record.getTag() != null) {
            sql.VALUES("tag", "#{tag,jdbcType=VARCHAR}");
        }
        
        if (record.getTagName() != null) {
            sql.VALUES("tag_name", "#{tagName,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getIsValid() != null) {
            sql.VALUES("is_valid", "#{isValid,jdbcType=INTEGER}");
        }
        
        if (record.getAddTime() != null) {
            sql.VALUES("add_time", "#{addTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDetail() != null) {
            sql.VALUES("detail", "#{detail,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(DataTemplateExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("name_zh");
        sql.SELECT("name_en");
        sql.SELECT("owner");
        sql.SELECT("owner_name");
        sql.SELECT("is_deploy");
        sql.SELECT("tag");
        sql.SELECT("tag_name");
        sql.SELECT("description");
        sql.SELECT("is_valid");
        sql.SELECT("add_time");
        sql.SELECT("update_time");
        sql.SELECT("detail");
        sql.FROM("data_template");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(DataTemplateExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("name_zh");
        sql.SELECT("name_en");
        sql.SELECT("owner");
        sql.SELECT("owner_name");
        sql.SELECT("is_deploy");
        sql.SELECT("tag");
        sql.SELECT("tag_name");
        sql.SELECT("description");
        sql.SELECT("is_valid");
        sql.SELECT("add_time");
        sql.SELECT("update_time");
        sql.FROM("data_template");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        DataTemplate record = (DataTemplate) parameter.get("record");
        DataTemplateExample example = (DataTemplateExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("data_template");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        }
        
        if (record.getNameZh() != null) {
            sql.SET("name_zh = #{record.nameZh,jdbcType=VARCHAR}");
        }
        
        if (record.getNameEn() != null) {
            sql.SET("name_en = #{record.nameEn,jdbcType=VARCHAR}");
        }
        
        if (record.getOwner() != null) {
            sql.SET("owner = #{record.owner,jdbcType=VARCHAR}");
        }
        
        if (record.getOwnerName() != null) {
            sql.SET("owner_name = #{record.ownerName,jdbcType=VARCHAR}");
        }
        
        if (record.getIsDeploy() != null) {
            sql.SET("is_deploy = #{record.isDeploy,jdbcType=INTEGER}");
        }
        
        if (record.getTag() != null) {
            sql.SET("tag = #{record.tag,jdbcType=VARCHAR}");
        }
        
        if (record.getTagName() != null) {
            sql.SET("tag_name = #{record.tagName,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{record.description,jdbcType=VARCHAR}");
        }
        
        if (record.getIsValid() != null) {
            sql.SET("is_valid = #{record.isValid,jdbcType=INTEGER}");
        }
        
        if (record.getAddTime() != null) {
            sql.SET("add_time = #{record.addTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDetail() != null) {
            sql.SET("detail = #{record.detail,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("data_template");
        
        sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        sql.SET("name_zh = #{record.nameZh,jdbcType=VARCHAR}");
        sql.SET("name_en = #{record.nameEn,jdbcType=VARCHAR}");
        sql.SET("owner = #{record.owner,jdbcType=VARCHAR}");
        sql.SET("owner_name = #{record.ownerName,jdbcType=VARCHAR}");
        sql.SET("is_deploy = #{record.isDeploy,jdbcType=INTEGER}");
        sql.SET("tag = #{record.tag,jdbcType=VARCHAR}");
        sql.SET("tag_name = #{record.tagName,jdbcType=VARCHAR}");
        sql.SET("description = #{record.description,jdbcType=VARCHAR}");
        sql.SET("is_valid = #{record.isValid,jdbcType=INTEGER}");
        sql.SET("add_time = #{record.addTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("detail = #{record.detail,jdbcType=LONGVARCHAR}");
        
        DataTemplateExample example = (DataTemplateExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("data_template");
        
        sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        sql.SET("name_zh = #{record.nameZh,jdbcType=VARCHAR}");
        sql.SET("name_en = #{record.nameEn,jdbcType=VARCHAR}");
        sql.SET("owner = #{record.owner,jdbcType=VARCHAR}");
        sql.SET("owner_name = #{record.ownerName,jdbcType=VARCHAR}");
        sql.SET("is_deploy = #{record.isDeploy,jdbcType=INTEGER}");
        sql.SET("tag = #{record.tag,jdbcType=VARCHAR}");
        sql.SET("tag_name = #{record.tagName,jdbcType=VARCHAR}");
        sql.SET("description = #{record.description,jdbcType=VARCHAR}");
        sql.SET("is_valid = #{record.isValid,jdbcType=INTEGER}");
        sql.SET("add_time = #{record.addTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        DataTemplateExample example = (DataTemplateExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(DataTemplate record) {
        SQL sql = new SQL();
        sql.UPDATE("data_template");
        
        if (record.getNameZh() != null) {
            sql.SET("name_zh = #{nameZh,jdbcType=VARCHAR}");
        }
        
        if (record.getNameEn() != null) {
            sql.SET("name_en = #{nameEn,jdbcType=VARCHAR}");
        }
        
        if (record.getOwner() != null) {
            sql.SET("owner = #{owner,jdbcType=VARCHAR}");
        }
        
        if (record.getOwnerName() != null) {
            sql.SET("owner_name = #{ownerName,jdbcType=VARCHAR}");
        }
        
        if (record.getIsDeploy() != null) {
            sql.SET("is_deploy = #{isDeploy,jdbcType=INTEGER}");
        }
        
        if (record.getTag() != null) {
            sql.SET("tag = #{tag,jdbcType=VARCHAR}");
        }
        
        if (record.getTagName() != null) {
            sql.SET("tag_name = #{tagName,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getIsValid() != null) {
            sql.SET("is_valid = #{isValid,jdbcType=INTEGER}");
        }
        
        if (record.getAddTime() != null) {
            sql.SET("add_time = #{addTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDetail() != null) {
            sql.SET("detail = #{detail,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, DataTemplateExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}