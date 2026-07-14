package com.secondhand.backend.service.interfaces;

import com.secondhand.backend.entity.User;

public interface CurrentUserService {

    User getCurrentUser();

    User getCurrentUserOrNull();

}