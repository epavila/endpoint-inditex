package com.inditex.eavila.infraestructure.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inditex.eavila.api.models.response.PriceResponse;
import com.inditex.eavila.domain.tos.PriceTo;
import com.inditex.eavila.domain.repositories.PriceRepository;
import com.inditex.eavila.infraestructure.abstract_services.ProductService;
import com.inditex.eavila.utils.DateUtil;
import com.inditex.eavila.utils.constants.GeneralConstants;
import com.inditex.eavila.utils.exceptions.IdNotFoundException;

@Transactional
@Service
@Slf4j
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private PriceRepository priceRepository;


    public PriceResponse findCurrentPrice(String applicationDate, Long idProduct, Long idBrand) {
        PriceResponse priceResponse = new PriceResponse();
        Boolean isValidateLocalDateTime = DateUtil.validateLocalDateTime(applicationDate);
        if (Boolean.TRUE.equals(isValidateLocalDateTime)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(GeneralConstants.FORMAT_DATE);
            LocalDateTime date = LocalDateTime.parse(applicationDate, formatter);

            try {
                Optional<PriceTo> priceToOptional = Optional.of(priceRepository
                        .findCurrentPrice(date, idProduct, idBrand, PageRequest.of(0, 1))
                        .getContent().get(0));

                BeanUtils.copyProperties(priceToOptional.get(), priceResponse);
            } catch (IndexOutOfBoundsException ex) {
                throw new IdNotFoundException("price");
            }
        }

        return priceResponse;

    }

}
