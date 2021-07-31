package com.mkyong.helloworld.web;

import com.mkyong.helloworld.service.DummyCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author rumman
 * @since 7/31/21
 */
@Controller
@RequestMapping("cache")
public class CacheController {

    @Autowired
    private DummyCacheService cacheService;

    @RequestMapping(method = GET)
    public String showCachedValue(@RequestParam(defaultValue = "1") Integer id, ModelMap model) {

        model.put("cValue", cacheService.getValueByKey(id));

        return "cacheValue";
    }

    @RequestMapping(value = "update", method = GET)
    public String updateCache(@RequestParam(defaultValue = "1") Integer id, ModelMap model) {

        cacheService.updateValueStore(id);
        model.put("cValue", cacheService.getValueByKey(id));

        return "cacheValue";
    }

    @RequestMapping(value = "remove", method = GET)
    public String removeCache(@RequestParam(defaultValue = "1") Integer id, ModelMap model) {

        cacheService.removeMap(id);
        model.put("cValue", cacheService.getValueByKey(id));

        return "cacheValue";
    }
}
