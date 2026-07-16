package com.secondhand.backend.service.interfaces;


import com.secondhand.backend.dto.province.response.ProvinceResponse;

import java.util.List;

public interface ProvinceService {

    List<ProvinceResponse> getProvinces();

}
