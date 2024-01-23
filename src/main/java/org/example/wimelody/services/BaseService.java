package org.example.wimelody.services;

import java.util.List;

public interface BaseService<DTO_RSP, DTO_MINI, F> {
    DTO_RSP save(DTO_MINI dtoMini);

    DTO_RSP update(DTO_MINI dtoMini, F f);

    Boolean delete(F f);

    DTO_RSP findOne(F f);

    List<DTO_RSP> findAll();
}