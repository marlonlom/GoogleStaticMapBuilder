package co.marlonlom.google.staticmaps;

/**
 * Utility Class that builds a static map url.
 *
 * @author marlonlom
 * @version 1.0.0
 */
public final class StaticMapUrl {
    /**
     * The constant TYPE_DEFAULT.
     */
    private static final String TYPE_DEFAULT = "roadmap";
    /**
     * The constant TYPE_SATELLITE.
     */
    private static final String TYPE_SATELLITE = "satellite";
    /**
     * The constant TYPE_TERRAIN.
     */
    private static final String TYPE_TERRAIN = "terrain";
    /**
     * The constant TYPE_HYBRID.
     */
    private static final String TYPE_HYBRID = "hybrid";
    /**
     * The constant ROOT_URL.
     */
    private static final String ROOT_URL = "http://maps.googleapis.com/maps/api/staticmap";

    /**
     * Private default constructor
     */
    private StaticMapUrl() {
        super();
    }

    /**
     * Prepares a builder for static map url
     *
     * @return the builder instance
     */
    public static Builder create() {
        return new Builder(ROOT_URL);
    }

    /**
     * Interface definition for {@link Builder} class, used when a {@link StaticMapMarker} is added
     * to the url.
     */
    public interface IMarker {
        /**
         * Adds a {@link StaticMapMarker} to the url
         *
         * @param marker
         *         a static map marker.
         * @return the reference that implements this interface.
         */
        IMarker mark(StaticMapMarker marker);

        /**
         * Builds the static map url.
         *
         * @return the generated url as string.
         */
        String build();
    }

    /**
     * Interface definition for {@link Builder} class, used when zoom level is set.
     */
    public interface IZoom {

        /**
         * Adds a {@link StaticMapMarker} to the url
         *
         * @param marker
         *         a static map marker.
         * @return the reference that implements this interface.
         */
        IMarker mark(StaticMapMarker marker);
    }

    /**
     * Interface definition for {@link Builder} class, used when image size for url is set.
     */
    public interface ISize {

        /**
         * Applies the selected zoom level.
         *
         * @param zoom
         *         zoom level for the map
         * @return the reference that implements this interface.
         */
        IZoom zoom(int zoom);
    }

    /**
     * Interface definition for {@link Builder} class, used when coordinates are set.
     */
    public interface ICenter {

        /**
         * Adds the image size for static map url
         *
         * @param width
         *         image width
         * @param height
         *         image height
         * @return the reference that implements this interface.
         */
        ISize size(int width, int height);
    }

    /**
     * Interface definition for {@link Builder} class, used when map type is selected.
     */
    public interface IType {

        /**
         * Sets the latitude and longitude for static map url
         *
         * @param latitude
         *         center latitude
         * @param longitude
         *         center longitude
         * @return the reference that implements this interface.
         */
        ICenter centered(float latitude, float longitude);
    }

    /**
     * Interface definition for {@link Builder} class, used when builder is created.
     */
    public interface IFrom {

        /**
         * Adds the TYPE_DEFAULT map type to the url
         *
         * @return the reference that implements this interface.
         */
        IType roadmap();

        /**
         * Adds the TYPE_SATELLITE map type to the url
         *
         * @return the reference that implements this interface.
         */
        IType satellite();

        /**
         * Adds the TYPE_TERRAIN map type to the url
         *
         * @return the reference that implements this interface.
         */
        IType terrain();

        /**
         * Adds the TYPE_HYBRID map type to the url
         *
         * @return the reference that implements this interface.
         */
        IType hybrid();
    }

    /**
     * The inner Builder for the StaticMapUrl class.
     *
     * @author marlonlom
     * @version 0.0.1
     */
    public static class Builder implements IFrom, IType, ICenter, ISize, IZoom,
            IMarker {
        private static final String SEP_URL = "&";
        private static final String SEP_START = "?";
        private static final String PARAM_TYPE = "maptype=";
        private static final String PARAM_ZOOM = "zoom=";
        private static final String PARAM_SIZE = "size=";
        private static final String PARAM_CENTER = "center=";
        private StringBuilder builder = new StringBuilder();

        /**
         * Instantiates a new Builder.
         *
         * @param from
         *         the url base for the static maps url
         */
        private Builder(String from) {
            this.builder.append(from).append(SEP_START);
        }

        /**
         * From create.
         *
         * @param from
         *         the url base for the static maps url
         * @return the builder instance
         */
        public static IFrom from(String from) {
            return new Builder(from);
        }

        @Override
        public ICenter centered(float latitude, float longitude) {
            this.builder.append(PARAM_CENTER).append(latitude)
                    .append(",").append(longitude);
            return this;
        }

        @Override
        public ISize size(int width, int height) {
            this.builder.append(SEP_URL).append(PARAM_SIZE).append(width)
                    .append("x").append(height);
            return this;
        }

        @Override
        public IZoom zoom(int zoom) {
            this.builder.append(SEP_URL).append(PARAM_ZOOM).append(zoom);
            return this;
        }

        @Override
        public IType roadmap() {
            this.builder.append(PARAM_TYPE).append(TYPE_DEFAULT);
            return this;
        }

        @Override
        public IType satellite() {
            this.builder.append(PARAM_TYPE).append(TYPE_SATELLITE);
            return this;
        }

        @Override
        public IType terrain() {
            this.builder.append(PARAM_TYPE).append(TYPE_TERRAIN);
            return this;
        }

        @Override
        public IType hybrid() {
            this.builder.append(SEP_URL).append(PARAM_TYPE).append(TYPE_HYBRID);
            return this;
        }

        @Override
        public IMarker mark(StaticMapMarker marker) {
            if (marker != null) {
                this.builder.append(SEP_URL).append(marker.toString());
            }
            return this;
        }

        @Override
        public String build() {
            return this.builder.toString();
        }

    }

}
