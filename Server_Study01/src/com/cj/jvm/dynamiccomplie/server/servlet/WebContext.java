package com.cj.jvm.dynamiccomplie.server.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author CJ
 */

@SuppressWarnings("all")
public class WebContext {
    private List<Entity> entities = null;
    private List<Mapping> mappings = null;

    //key-->servlet-name value-->servlet-class
    private Map<String, String> entityMap = new HashMap<String, String>();
    //key-->url-pattern value-->servlet-name
    private Map<String, String> mappingMap = new HashMap<String, String>();

    public WebContext(List<Entity> entities, List<Mapping> mappings) {
        this.entities = entities;
        this.mappings = mappings;

        //将entity的List转成对应的Map
        for (Entity entity : entities) {
            entityMap.put(entity.getName(), entity.getClz());
        }
        //将Map的List转成对应的Map
        for (Mapping mapping : mappings) {
            for (String pattern : mapping.getPatterns()) {
                mappingMap.put(pattern, mapping.getName());
            }
        }
    }

    /**
     * 通过URL的路径找到了对应的class
     * @param pattern
     * @return
     */
    public String getClz(String pattern) {
        String name = mappingMap.get(pattern);
        return entityMap.get(name);
    }
}
