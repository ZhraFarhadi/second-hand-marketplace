package com.secondhand.backend.mapper.interfaces;

import com.secondhand.backend.dto.province.response.ProvinceResponse;
import com.secondhand.backend.entity.Province;

public interface ProvinceMapper {

    ProvinceResponse toResponse(
            Province province
    );

}
