/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License. 
 */

package com.ait.lienzo.client.core.util;

import java.util.function.Function;

import com.ait.lienzo.tools.client.collection.NFastArrayList;
import com.ait.lienzo.tools.client.collection.NFastStringMap;
import elemental2.core.JsArray;
import elemental2.core.JsIIterableResult;
import elemental2.core.JsIteratorIterable;
import elemental2.dom.DomGlobal;

public class JsInteropUtils {

    public static void logMap(NFastStringMap map) {

        if (!map.isEmpty()) {
            DomGlobal.console.log("Map size = " + map.size());
            JsIteratorIterable keys = map.keys();
            JsIIterableResult next1 = keys.next();
            while (!next1.isDone()) {
                String key = (String) next1.getValue();
                Object value = map.get(key);
                DomGlobal.console.log("* Item [" + key + "] = [" + value + "]");
                next1.setDone(true);
                next1 = keys.next();
            }
        } else {
            DomGlobal.console.log("Map is Empty");
        }
    }

    public static <V> JsArray<V> toValuesJsArray(NFastStringMap<V> map) {
        JsArray<V> result = new JsArray<>();
        if (!map.isEmpty()) {
            JsIteratorIterable<V> values = map.values();
            JsIIterableResult<V> next1 = values.next();
            while (!next1.isDone()) {
                result.push(next1.getValue());
                next1.setDone(true);
                next1 = values.next();
            }
        }
        return result;
    }

    public static <V> NFastArrayList<V> clone(NFastArrayList<V> list,
                                              Function<V, V> clone) {
        if (null != list) {
            final NFastArrayList<V> result = new NFastArrayList<>();
            if (!list.isEmpty()) {
                for (int i = 0; i < list.getLength(); i++) {
                    result.add(clone.apply(list.get(i)));
                }
            }
            return result;
        }
        return null;
    }

    public static <V> void populate(NFastArrayList<V> sourceList,
                                    NFastArrayList<V> targetList,
                                    Function<V, V> clone) {
        if (null != sourceList && !sourceList.isEmpty()) {
            for (int i = 0; i < sourceList.getLength(); i++) {
                targetList.add(clone.apply(sourceList.get(i)));
            }
        }
    }
}
