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

package co.marlonlom.google.staticmaps.demo;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import co.marlonlom.google.staticmaps.StaticMapMarker;
import co.marlonlom.google.staticmaps.StaticMapUrl;

/**
 * The type Main activity.
 *
 * @author marlonlom
 * @version 1.0.0
 */
public class MainActivity extends AppCompatActivity {

    /**
     * The Sample image view.
     */
    @BindView(R.id.generated_image)
    ImageView sampleImageView;

    /**
     * The Toolbar.
     */
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    /**
     * The Spinner.
     */
    @BindView(R.id.spinner)
    Spinner spinner;

    /**
     * The Progress bar.
     */
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    /**
     * The Coordinates.
     */
    @BindArray(R.array.spinner_coordinates)
    String[] coordinates;

    /**
     * The Description text.
     */
    @BindView(R.id.description_text)
    TextView descriptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        setupSpinner();
    }

    /**
     * Sets spinner.
     */
    private void setupSpinner() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String coordinateList = coordinates[position];
                boolean containsCoordinates = !coordinateList.equalsIgnoreCase("_");
                if (containsCoordinates) {
                    String[] split = coordinateList.split(";");
                    sampleImageView.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                    loadImageMap(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
                } else {
                    descriptionText.setText(R.string.pre_text);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    /**
     * Gets coordinator layout.
     *
     * @return the coordinator layout
     */
    private CoordinatorLayout getCoordinatorLayout() {
        return (CoordinatorLayout) findViewById(R.id.home_coordinator_layout);
    }

    /**
     * Load image map.
     *
     * @param latitude  the latitude
     * @param longitude the longitude
     */
    private void loadImageMap(final double latitude, final double longitude) {
        descriptionText.setText(R.string.during_text);

        final String sampleImageMapUrl = generateImageMap(latitude, longitude);
        Picasso.with(getApplication()).load(sampleImageMapUrl).centerCrop()
                .placeholder(R.drawable.default_staticmap)
                .resize(240, 240).into(sampleImageView, new Callback() {
            @Override
            public void onSuccess() {
                sampleImageView.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
                Snackbar.make(getCoordinatorLayout(), R.string.snackbar_sucess_loading_img, Snackbar.LENGTH_SHORT).show();
                final String postText = getResources().getString(R.string.post_text);
                descriptionText.setText(postText.replace("_0", sampleImageMapUrl));
            }

            @Override
            public void onError() {
                sampleImageView.setVisibility(View.GONE);
                progressBar.setVisibility(View.GONE);
                Snackbar.make(getCoordinatorLayout(), R.string.snackbar_error_loading_img, Snackbar.LENGTH_INDEFINITE)
                        .setAction(R.string.action_retry, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                loadImageMap(latitude, longitude);
                            }
                        }).show();
            }
        });
    }

    /**
     * Generate image map string.
     *
     * @param latitude  the latitude
     * @param longitude the longitude
     * @return the string
     */
    private String generateImageMap(Double latitude, Double longitude) {
        return StaticMapUrl.create().centered(latitude.floatValue(), longitude.floatValue())
                .size(320, 320).zoom(8)
                .mark(StaticMapMarker.create("blue", latitude.floatValue(), longitude.floatValue()).medium())
                .build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
