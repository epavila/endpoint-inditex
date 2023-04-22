package com.eavila.endpoint.infraestructure.services;

import com.eavila.endpoint.model.entity.Price;
import com.eavila.endpoint.model.entity.to.PriceTo;
import com.eavila.endpoint.model.response.PriceResponse;
import com.eavila.endpoint.repository.PriceRepository;
import com.eavila.endpoint.utils.DateUtil;
import com.eavila.endpoint.utils.constants.GeneralConstants;
import com.eavila.endpoint.utils.exception.IdNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Transactional
@Service
@Slf4j
@AllArgsConstructor
public class PriceService {

    private PriceRepository priceRepository;


    private PriceResponse entityToResponse(Price price) {
        PriceResponse priceResponse = new PriceResponse();
        PriceTo priceTo = new PriceTo();
        priceTo.setPrdId(price.getProduct().getPrdId());
        priceTo.setBrdId(price.getBrand().getBrdId());
        priceTo.setRtsApply(price.getRate().getRtsApply());
        priceTo.setStartDate(price.getStartDate());
        priceTo.setEndDate(price.getEndDate());
        priceTo.setPrice(price.getPrcPrice());



        return priceResponse;
    }


    public PriceResponse findCurrentPrice(String applicationDate, Long idProduct, Long idBrand) {

        if (applicationDate.length() == 16) {
            applicationDate = applicationDate.concat(":00");
        }

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
