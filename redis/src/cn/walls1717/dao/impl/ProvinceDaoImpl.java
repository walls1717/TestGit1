package cn.walls1717.dao.impl;

import cn.walls1717.dao.ProvinceDao;
import cn.walls1717.domain.Province;
import cn.walls1717.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @version 2020-7-3
 * @author CJ
 */
public class ProvinceDaoImpl implements ProvinceDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> findAll() {
        // 定义 sql
        String sql = "select * from province";
        // 执行 sql
        List<Province> list = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }
}
