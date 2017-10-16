package com.rocketchat.common.listener;

import org.json.JSONObject;

public interface StreamCollectionListener<T> {
    void onAdded(T document);

    void onChanged(JSONObject value);

    void onRemoved(String key);
}