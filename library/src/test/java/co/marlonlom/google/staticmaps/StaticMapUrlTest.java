package co.marlonlom.google.staticmaps;

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

        System.out.println(imageUrl);
        Assert.assertFalse(imageUrl.equalsIgnoreCase(""));
    }
}