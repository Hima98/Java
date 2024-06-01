package com.springbootacademy.batch7.pos.controller;


import com.springbootacademy.batch7.pos.dto.request.ItemSaveRequestDTO;
import com.springbootacademy.batch7.pos.dto.responce.ItemGetResponceDTO;
import com.springbootacademy.batch7.pos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(
            path = "/save"
    )

    public String saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {
        String message = itemService.saveItem(itemSaveRequestDTO);
        return "saved";
    }

    @GetMapping(
            path="/get-by-name",
            params = "name"
    )

    public List<ItemGetResponceDTO> GetItemByNameAndStatus(@RequestParam(value="name") String itemName){
        List<ItemGetResponceDTO> itemDTOS=itemService.GetItemByNameAndStatus(itemName);
        return itemDTOS;
    }

    @GetMapping(
            path="/get-by-name-with-mapstruct",
            params = "name"
    )

    public List<ItemGetResponceDTO> GetItemByNameAndStatusByMapstruct(@RequestParam(value="name") String itemName){
        List<ItemGetResponceDTO> itemDTOS=itemService.GetItemByNameAndStatusBymapstruct(itemName);
        return itemDTOS;
    }


}
