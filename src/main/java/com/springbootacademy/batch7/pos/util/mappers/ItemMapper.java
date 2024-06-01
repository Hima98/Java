package com.springbootacademy.batch7.pos.util.mappers;

import com.springbootacademy.batch7.pos.dto.responce.ItemGetResponceDTO;
import com.springbootacademy.batch7.pos.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    List<ItemGetResponceDTO> entityListToDtoList(List<Item> items);

}
