/*
 * Copyright (c) 2016, marlonlom
 *
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.github.marlonlom.staticmaps_builder;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * The type Static map url test.
 *
 * @author marlonlom
 * @version 1.0.0.
 */
@RunWith(JUnit4.class)
public class StaticMapUrlTest {

    /**
     * Should generate static map url.
     */
    @Test
    public void shouldGenerateStaticMapUrl() {
        float lat = (float) 4.0;
        float lng = (float) -74.1;
        int imgSize = 250;
        int zoom = 8;
        String imageUrl = StaticMapUrl.create().satellite().centered(lat, lng)
                .size(imgSize, imgSize).zoom(zoom)
                .mark(StaticMapMarker.create("0x4545AA", lat, lng).medium())
                .build();

        Assert.assertFalse(imageUrl.equalsIgnoreCase(""));
    }
}