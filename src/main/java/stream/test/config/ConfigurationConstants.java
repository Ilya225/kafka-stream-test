package stream.test.config;

public final class ConfigurationConstants {
    private ConfigurationConstants() {}

    public final static String BROKER_HOST = "localhost:9092";
    public final static String SCHEMA_REGISTRY = "http://localhost:8081";
    public final static String P_SENSOR_TOPIC = "P_sensor_data";
    public final static String T_SENSOR_TOPIC = "T_sensor_data";
    public final static String SO_SENSOR_TOPIC = "SO";
    public final static int STREAM_WINDOWS_SIZE_SECONDS = 5;
}
