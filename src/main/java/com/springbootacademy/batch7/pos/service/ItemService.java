package com.springbootacademy.batch7.pos.service;

import com.springbootacademy.batch7.pos.dto.request.ItemSaveRequestDTO;
import com.springbootacademy.batch7.pos.dto.responce.ItemGetResponceDTO;

import java.util.List;

public interface ItemService {

    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemGetResponceDTO> GetItemByNameAndStatus(String itemName);

    List<ItemGetResponceDTO> GetItemByNameAndStatusBymapstruct(String itemName);
}
