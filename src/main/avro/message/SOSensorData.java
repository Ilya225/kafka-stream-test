/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package message;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class SOSensorData extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 8690510123977152150L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"SOSensorData\",\"namespace\":\"message\",\"fields\":[{\"name\":\"p_measurement_time\",\"type\":[\"long\",\"null\"]},{\"name\":\"t_measurement_time\",\"type\":[\"long\",\"null\"]},{\"name\":\"device_id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"latitude\",\"type\":[\"double\",\"null\"]},{\"name\":\"longitude\",\"type\":[\"double\",\"null\"]},{\"name\":\"temperature\",\"type\":[\"double\",\"null\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.Long p_measurement_time;
  @Deprecated public java.lang.Long t_measurement_time;
  @Deprecated public java.lang.String device_id;
  @Deprecated public java.lang.Double latitude;
  @Deprecated public java.lang.Double longitude;
  @Deprecated public java.lang.Double temperature;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public SOSensorData() {}

  /**
   * All-args constructor.
   * @param p_measurement_time The new value for p_measurement_time
   * @param t_measurement_time The new value for t_measurement_time
   * @param device_id The new value for device_id
   * @param latitude The new value for latitude
   * @param longitude The new value for longitude
   * @param temperature The new value for temperature
   */
  public SOSensorData(java.lang.Long p_measurement_time, java.lang.Long t_measurement_time, java.lang.String device_id, java.lang.Double latitude, java.lang.Double longitude, java.lang.Double temperature) {
    this.p_measurement_time = p_measurement_time;
    this.t_measurement_time = t_measurement_time;
    this.device_id = device_id;
    this.latitude = latitude;
    this.longitude = longitude;
    this.temperature = temperature;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return p_measurement_time;
    case 1: return t_measurement_time;
    case 2: return device_id;
    case 3: return latitude;
    case 4: return longitude;
    case 5: return temperature;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: p_measurement_time = (java.lang.Long)value$; break;
    case 1: t_measurement_time = (java.lang.Long)value$; break;
    case 2: device_id = (java.lang.String)value$; break;
    case 3: latitude = (java.lang.Double)value$; break;
    case 4: longitude = (java.lang.Double)value$; break;
    case 5: temperature = (java.lang.Double)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'p_measurement_time' field.
   * @return The value of the 'p_measurement_time' field.
   */
  public java.lang.Long getPMeasurementTime() {
    return p_measurement_time;
  }

  /**
   * Sets the value of the 'p_measurement_time' field.
   * @param value the value to set.
   */
  public void setPMeasurementTime(java.lang.Long value) {
    this.p_measurement_time = value;
  }

  /**
   * Gets the value of the 't_measurement_time' field.
   * @return The value of the 't_measurement_time' field.
   */
  public java.lang.Long getTMeasurementTime() {
    return t_measurement_time;
  }

  /**
   * Sets the value of the 't_measurement_time' field.
   * @param value the value to set.
   */
  public void setTMeasurementTime(java.lang.Long value) {
    this.t_measurement_time = value;
  }

  /**
   * Gets the value of the 'device_id' field.
   * @return The value of the 'device_id' field.
   */
  public java.lang.String getDeviceId() {
    return device_id;
  }

  /**
   * Sets the value of the 'device_id' field.
   * @param value the value to set.
   */
  public void setDeviceId(java.lang.String value) {
    this.device_id = value;
  }

  /**
   * Gets the value of the 'latitude' field.
   * @return The value of the 'latitude' field.
   */
  public java.lang.Double getLatitude() {
    return latitude;
  }

  /**
   * Sets the value of the 'latitude' field.
   * @param value the value to set.
   */
  public void setLatitude(java.lang.Double value) {
    this.latitude = value;
  }

  /**
   * Gets the value of the 'longitude' field.
   * @return The value of the 'longitude' field.
   */
  public java.lang.Double getLongitude() {
    return longitude;
  }

  /**
   * Sets the value of the 'longitude' field.
   * @param value the value to set.
   */
  public void setLongitude(java.lang.Double value) {
    this.longitude = value;
  }

  /**
   * Gets the value of the 'temperature' field.
   * @return The value of the 'temperature' field.
   */
  public java.lang.Double getTemperature() {
    return temperature;
  }

  /**
   * Sets the value of the 'temperature' field.
   * @param value the value to set.
   */
  public void setTemperature(java.lang.Double value) {
    this.temperature = value;
  }

  /**
   * Creates a new SOSensorData RecordBuilder.
   * @return A new SOSensorData RecordBuilder
   */
  public static message.SOSensorData.Builder newBuilder() {
    return new message.SOSensorData.Builder();
  }

  /**
   * Creates a new SOSensorData RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new SOSensorData RecordBuilder
   */
  public static message.SOSensorData.Builder newBuilder(message.SOSensorData.Builder other) {
    return new message.SOSensorData.Builder(other);
  }

  /**
   * Creates a new SOSensorData RecordBuilder by copying an existing SOSensorData instance.
   * @param other The existing instance to copy.
   * @return A new SOSensorData RecordBuilder
   */
  public static message.SOSensorData.Builder newBuilder(message.SOSensorData other) {
    return new message.SOSensorData.Builder(other);
  }

  /**
   * RecordBuilder for SOSensorData instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<SOSensorData>
    implements org.apache.avro.data.RecordBuilder<SOSensorData> {

    private java.lang.Long p_measurement_time;
    private java.lang.Long t_measurement_time;
    private java.lang.String device_id;
    private java.lang.Double latitude;
    private java.lang.Double longitude;
    private java.lang.Double temperature;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(message.SOSensorData.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.p_measurement_time)) {
        this.p_measurement_time = data().deepCopy(fields()[0].schema(), other.p_measurement_time);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.t_measurement_time)) {
        this.t_measurement_time = data().deepCopy(fields()[1].schema(), other.t_measurement_time);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.device_id)) {
        this.device_id = data().deepCopy(fields()[2].schema(), other.device_id);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.latitude)) {
        this.latitude = data().deepCopy(fields()[3].schema(), other.latitude);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.longitude)) {
        this.longitude = data().deepCopy(fields()[4].schema(), other.longitude);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.temperature)) {
        this.temperature = data().deepCopy(fields()[5].schema(), other.temperature);
        fieldSetFlags()[5] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing SOSensorData instance
     * @param other The existing instance to copy.
     */
    private Builder(message.SOSensorData other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.p_measurement_time)) {
        this.p_measurement_time = data().deepCopy(fields()[0].schema(), other.p_measurement_time);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.t_measurement_time)) {
        this.t_measurement_time = data().deepCopy(fields()[1].schema(), other.t_measurement_time);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.device_id)) {
        this.device_id = data().deepCopy(fields()[2].schema(), other.device_id);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.latitude)) {
        this.latitude = data().deepCopy(fields()[3].schema(), other.latitude);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.longitude)) {
        this.longitude = data().deepCopy(fields()[4].schema(), other.longitude);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.temperature)) {
        this.temperature = data().deepCopy(fields()[5].schema(), other.temperature);
        fieldSetFlags()[5] = true;
      }
    }

    /**
      * Gets the value of the 'p_measurement_time' field.
      * @return The value.
      */
    public java.lang.Long getPMeasurementTime() {
      return p_measurement_time;
    }

    /**
      * Sets the value of the 'p_measurement_time' field.
      * @param value The value of 'p_measurement_time'.
      * @return This builder.
      */
    public message.SOSensorData.Builder setPMeasurementTime(java.lang.Long value) {
      validate(fields()[0], value);
      this.p_measurement_time = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'p_measurement_time' field has been set.
      * @return True if the 'p_measurement_time' field has been set, false otherwise.
      */
    public boolean hasPMeasurementTime() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'p_measurement_time' field.
      * @return This builder.
      */
    public message.SOSensorData.Builder clearPMeasurementTime() {
      p_measurement_time = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 't_measurement_time' field.
      * @return The value.
      */
    public java.lang.Long getTMeasurementTime() {
      return t_measurement_time;
    }

    /**
      * Sets the value of the 't_measurement_time' field.
      * @param value The value of 't_measurement_time'.
      * @return This builder.
      */
    public message.SOSensorData.Builder setTMeasurementTime(java.lang.Long value) {
      validate(fields()[1], value);
      this.t_measurement_time = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 't_measurement_time' field has been set.
      * @return True if the 't_measurement_time' field has been set, false otherwise.
      */
    public boolean hasTMeasurementTime() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 't_measurement_time' field.
      * @return This builder.
      */
    public message.SOSensorData.Builder clearTMeasurementTime() {
      t_measurement_time = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'device_id' field.
      * @return The value.
      */
    public java.lang.String getDeviceId() {
      return device_id;
    }

    /**
      * Sets the value of the 'device_id' field.
      * @param value The value of 'device_id'.
      * @return This builder.
      */
    public message.SOSensorData.Builder setDeviceId(java.lang.String value) {
      validate(fields()[2], value);
      this.device_id = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'device_id' field has been set.
      * @return True if the 'device_id' field has been set, false otherwise.
      */
    public boolean hasDeviceId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'device_id' field.
      * @return This builder.
      */
    public message.SOSensorData.Builder clearDeviceId() {
      device_id = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'latitude' field.
      * @return The value.
      */
    public java.lang.Double getLatitude() {
      return latitude;
    }

    /**
      * Sets the value of the 'latitude' field.
      * @param value The value of 'latitude'.
      * @return This builder.
      */
    public message.SOSensorData.Builder setLatitude(java.lang.Double value) {
      validate(fields()[3], value);
      this.latitude = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'latitude' field has been set.
      * @return True if the 'latitude' field has been set, false otherwise.
      */
    public boolean hasLatitude() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'latitude' field.
      * @return This builder.
      */
    public message.SOSensorData.Builder clearLatitude() {
      latitude = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'longitude' field.
      * @return The value.
      */
    public java.lang.Double getLongitude() {
      return longitude;
    }

    /**
      * Sets the value of the 'longitude' field.
      * @param value The value of 'longitude'.
      * @return This builder.
      */
    public message.SOSensorData.Builder setLongitude(java.lang.Double value) {
      validate(fields()[4], value);
      this.longitude = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'longitude' field has been set.
      * @return True if the 'longitude' field has been set, false otherwise.
      */
    public boolean hasLongitude() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'longitude' field.
      * @return This builder.
      */
    public message.SOSensorData.Builder clearLongitude() {
      longitude = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'temperature' field.
      * @return The value.
      */
    public java.lang.Double getTemperature() {
      return temperature;
    }

    /**
      * Sets the value of the 'temperature' field.
      * @param value The value of 'temperature'.
      * @return This builder.
      */
    public message.SOSensorData.Builder setTemperature(java.lang.Double value) {
      validate(fields()[5], value);
      this.temperature = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'temperature' field has been set.
      * @return True if the 'temperature' field has been set, false otherwise.
      */
    public boolean hasTemperature() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'temperature' field.
      * @return This builder.
      */
    public message.SOSensorData.Builder clearTemperature() {
      temperature = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    public SOSensorData build() {
      try {
        SOSensorData record = new SOSensorData();
        record.p_measurement_time = fieldSetFlags()[0] ? this.p_measurement_time : (java.lang.Long) defaultValue(fields()[0]);
        record.t_measurement_time = fieldSetFlags()[1] ? this.t_measurement_time : (java.lang.Long) defaultValue(fields()[1]);
        record.device_id = fieldSetFlags()[2] ? this.device_id : (java.lang.String) defaultValue(fields()[2]);
        record.latitude = fieldSetFlags()[3] ? this.latitude : (java.lang.Double) defaultValue(fields()[3]);
        record.longitude = fieldSetFlags()[4] ? this.longitude : (java.lang.Double) defaultValue(fields()[4]);
        record.temperature = fieldSetFlags()[5] ? this.temperature : (java.lang.Double) defaultValue(fields()[5]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
