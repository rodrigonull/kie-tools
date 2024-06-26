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

package com.ait.lienzo.client.widget.panel.util;

import com.ait.lienzo.client.core.style.Style;
import elemental2.core.JsNumber;
import elemental2.dom.CSSProperties;
import elemental2.dom.CSSStyleDeclaration;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.ViewCSS;
import jsinterop.base.Js;

import static elemental2.dom.DomGlobal.document;

public class LienzoPanelUtils {

    private LienzoPanelUtils() {

    }

    public static HTMLDivElement createDiv() {
        return (HTMLDivElement) document.createElement("div");
    }

    public static int[] getPxSize(final HTMLDivElement element) {
        if (element == null) {
            return new int[]{0, 0};
        }
        final CSSStyleDeclaration cs = Js.<ViewCSS>uncheckedCast(DomGlobal.window).getComputedStyle(element);
        final double paddingX = JsNumber.parseFloat(cs.paddingLeft.asString()) + JsNumber.parseFloat(cs.paddingRight.asString());
        final double paddingY = JsNumber.parseFloat(cs.paddingTop.asString()) + JsNumber.parseFloat(cs.paddingBottom.asString());
        final double borderX = JsNumber.parseFloat(cs.borderLeftWidth.asString()) + JsNumber.parseFloat(cs.borderRightWidth.asString());
        final double borderY = JsNumber.parseFloat(cs.borderTopWidth.asString()) + JsNumber.parseFloat(cs.borderBottomWidth.asString());
        final int width = (int) (element.offsetWidth - paddingX - borderX);
        final int height = (int) (element.offsetHeight - paddingY - borderY);
        return new int[]{width, height};
    }

    public static void setPanelWidth(final HTMLDivElement panel,
                                     final int width) {
        panel.style.width = CSSProperties.WidthUnionType.of(width + Style.Unit.PX.getType());
    }

    public static void setPanelHeight(final HTMLDivElement panel,
                                      final int height) {
        panel.style.height = CSSProperties.HeightUnionType.of(height + Style.Unit.PX.getType());
    }

    public static void setPanelSize(final HTMLDivElement panel,
                                    final int width,
                                    final int height) {
        setPanelWidth(panel, width);
        setPanelHeight(panel, height);
    }
}
