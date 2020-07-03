package cn.walls1717.service.impl;


import cn.walls1717.dao.ProvinceDao;
import cn.walls1717.dao.impl.ProvinceDaoImpl;
import cn.walls1717.domain.Province;
import cn.walls1717.jedis.utils.JedisPoolUtils;
import cn.walls1717.service.ProvinceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @version 2020-7-3
 * @author CJ
 */
public class ProvinceServiceImpl implements ProvinceService {

    private ProvinceDao dao = new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    /**
     * 使用 redis 缓存
     * @return
     */
    @Override
    public String findAllJson() {
        // 先从 redis 中查询数据
        // 获取 redis 客户端连接
        Jedis jedis = JedisPoolUtils.getJedis();
        String provinceJson = jedis.get("province");

        // 判断 provinceJson 数据是否为null
        if(provinceJson == null || provinceJson.length() == 0) {
            // 没有数据,从数据库中查询
            System.out.println("redis中没数据，查询数据库");

            List<Province> ps = dao.findAll();
            // 将 list 序列化为 json
            ObjectMapper mapper = new ObjectMapper();
            try {
                provinceJson = mapper.writeValueAsString(ps);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            // 将json 数据存入 redis
            jedis.set("province", provinceJson);
            // 归还连接
            jedis.close();
        } else {
            System.out.println("redis中有数据，查询缓存");
        }
        return provinceJson;
    }
}
