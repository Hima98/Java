package com.springbootacademy.batch7.pos.service.impl;

import com.springbootacademy.batch7.pos.dto.request.ItemSaveRequestDTO;

import com.springbootacademy.batch7.pos.dto.responce.ItemGetResponceDTO;
import com.springbootacademy.batch7.pos.entity.Item;
import com.springbootacademy.batch7.pos.repo.ItemRepo;
import com.springbootacademy.batch7.pos.service.ItemService;
import com.springbootacademy.batch7.pos.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;
    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
       // Item item=new Item(
       //         1,
       //         itemSaveRequestDTO.getItemName(),
       //         itemSaveRequestDTO.getMeasuringUnitType(),
        //        itemSaveRequestDTO.getBalanceQty(),
        //        itemSaveRequestDTO.getSupplierPrice(),
        //        itemSaveRequestDTO.getSellingPrice(),
         //       true);
      //  itemRepo.save(item);
      //  return item.getItemName();
        Item item=modelMapper.map(itemSaveRequestDTO,Item.class);
        if(!itemRepo.existsById(item.getItemId())){
            itemRepo.save(item);
            return item.getItemId()+ "saved successfully";
        }
        else {
            throw new DuplicateKeyException("Already Added");
        }
    }

    @Override
    public List<ItemGetResponceDTO> GetItemByNameAndStatus(String itemName) {
        boolean b=true;
        List<Item> items= itemRepo.findAllByItemNameEqualsAndActiveEquals(itemName,b);
        if(items.size()>0){
            List<ItemGetResponceDTO> itemGetResponceDTOS = modelMapper.map(items,new TypeToken<List<ItemGetResponceDTO>>(){}.getType());
            return itemGetResponceDTOS;
        }
        else{
            throw new RuntimeException("Not Found");
        }
    }

    @Override
    public List<ItemGetResponceDTO> GetItemByNameAndStatusBymapstruct(String itemName) {
        boolean b=true;
        List<Item> items= itemRepo.findAllByItemNameEqualsAndActiveEquals(itemName,b);
        if(items.size()>0){
            List<ItemGetResponceDTO> itemGetResponceDTOS = itemMapper.entityListToDtoList(items);
            return itemGetResponceDTOS;
        }
        else{
            throw new RuntimeException("Not Found");
        }
    }
}
