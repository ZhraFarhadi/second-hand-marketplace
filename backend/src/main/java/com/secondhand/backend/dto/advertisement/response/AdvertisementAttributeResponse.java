
package com.secondhand.backend.dto.advertisement.response;

import com.secondhand.backend.enums.AttributeDataType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdvertisementAttributeResponse {

    private Long categoryAttributeId;

    private String attributeName;

    private AttributeDataType dataType;

    private String value;

}