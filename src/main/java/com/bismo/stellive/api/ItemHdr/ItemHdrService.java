package com.bismo.stellive.api.ItemHdr;

import com.bismo.stellive.api.ItemHdr.dto.ItemHdrDto;
import com.bismo.stellive.api.ItemHdr.dto.ItemResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemHdrService {

    private final ItemHdrQueryRepository itemHdrQueryRepository;
    private  final ItemHdrJpaRepository itemHdrJpaRepository;
//    private final ItemHdrMapper itemHdrMapper;

    public List<ItemResponse> read() {

        return itemHdrQueryRepository.read();
    }

    public void save(ItemHdrDto itemHdrDto) {

        ItemHdr itemHdr = new ItemHdr();

        itemHdr.save(itemHdrDto);

        itemHdrJpaRepository.save(itemHdr);
    }
}
