package stream.rest.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SODto {
    private Long pMeasurementTime;
    private Long tMeasurementTime;
    private String deviceId;
    private Double latitude;
    private Double longitude;
    private Double temperature;
}
