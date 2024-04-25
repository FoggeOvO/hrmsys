package com.peo.util;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

import java.util.List;

public class JSONUtil {
    public static void getDepIds(JSONArray deps, List<Integer> keys) {
        for (int i = 0; i < deps.size(); i++) {
            JSONObject jsonObject = deps.getJSONObject(i);
            Integer key = jsonObject.getInteger("key");
            keys.add(key);
            if (jsonObject.containsKey("children") && !jsonObject.getJSONArray("children").isEmpty()) {
                getDepIds(jsonObject.getJSONArray("children"), keys);
            }
        }
    }
}
