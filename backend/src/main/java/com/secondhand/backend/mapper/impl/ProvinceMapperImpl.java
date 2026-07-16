package com.secondhand.backend.mapper.impl;

import com.secondhand.backend.dto.province.response.ProvinceResponse;
import com.secondhand.backend.entity.Province;
import com.secondhand.backend.mapper.interfaces.ProvinceMapper;
import org.springframework.stereotype.Component;

@Component
public class ProvinceMapperImpl
        implements ProvinceMapper {

    @Override
    public ProvinceResponse toResponse(
            Province province
    ) {

        if (province == null) {
            return null;
        }

        return new ProvinceResponse(
                province.getId(),
                province.getName()
        );

    }

}