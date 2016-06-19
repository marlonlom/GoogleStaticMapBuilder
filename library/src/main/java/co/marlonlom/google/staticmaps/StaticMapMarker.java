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

package co.marlonlom.google.staticmaps;

/**
 * POJO Class that represents a static map marker.
 *
 * @author marlonlom
 * @version 1.0.0
 */
public final class StaticMapMarker {
    /**
     * Specifies a 24-bit color (example: color=0xFFFFCC) or a predefined color create the set
     * {black, brown, green, purple, yellow, blue, gray, orange, red, white}.
     */
    private String color;

    /**
     * Specifies the size of marker create the set {tiny, mid, small}, If no size parameter is set,
     * the marker will appear in its default (normal) size.
     */
    private String size;

    /**
     * Defines the marker's location (latitude) on the map
     */
    private float latitude;

    /**
     * Defines the marker's location (longitude) on the map
     */
    private float longitude;

    /**
     * Instantiates a new Static map marker.
     *
     * @param color
     *         marker color text or hexadecimal
     * @param lat
     *         marker latitude
     * @param lng
     *         marker longitude
     */
    private StaticMapMarker(String color, float lat, float lng) {
        super();
        this.setColor(color);
        this.setLatitude(lat);
        this.setLongitude(lng);
    }

    /**
     * Performs map marker creation
     *
     * @param colour
     *         marker color text
     * @param lat
     *         marker latitude
     * @param lng
     *         marker longitude
     * @return the static map marker
     */
    public static StaticMapMarker create(String colour, float lat, float lng) {
        return new StaticMapMarker(colour, lat, lng);
    }

    /**
     * Sets marker color
     *
     * @param color
     *         new color text
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Modifies latitude coordinate value
     *
     * @param latitude
     *         coordinate value
     */
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    /**
     * Modifies longitude coordinate value
     *
     * @param longitude
     *         coordinate value
     */
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    /**
     * Modifies marker size
     *
     * @param size
     *         new marker size
     */
    private void setSize(String size) {
        this.size = size;
    }

    /**
     * Indicates marker size as small
     *
     * @return updated static map marker
     */
    public StaticMapMarker small() {
        this.setSize("small");
        return this;
    }

    /**
     * Indicates marker size as medium
     *
     * @return updated static map marker
     */
    public StaticMapMarker medium() {
        this.setSize("mid");
        return this;
    }

    /**
     * Indicates marker size as tiny
     *
     * @return updated static map marker
     */
    public StaticMapMarker tiny() {
        this.setSize("tiny");
        return this;
    }

    /**
     * (non-Javadoc)
     *
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "markers=".concat("color:").concat(this.color)
                .concat("|size:").concat(this.size)
                .concat("|").concat(String.valueOf(this.latitude))
                .concat(",").concat(String.valueOf(this.longitude));
    }
}
