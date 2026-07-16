package com.secondhand.backend.service.impl;

import com.secondhand.backend.dto.province.response.ProvinceResponse;
import com.secondhand.backend.mapper.interfaces.ProvinceMapper;
import com.secondhand.backend.repository.ProvinceRepository;
import com.secondhand.backend.service.interfaces.ProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProvinceServiceImpl
        implements ProvinceService {

    private final ProvinceRepository provinceRepository;

    private final ProvinceMapper provinceMapper;

    @Override
    public List<ProvinceResponse> getProvinces() {

        return provinceRepository
                .findAllByOrderByNameAsc()
                .stream()
                .map(provinceMapper::toResponse)
                .toList();

    }

}
