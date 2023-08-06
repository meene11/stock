package com.zerobase.stock.service;

import com.zerobase.stock.exception.impl.NoCompanyException;
import com.zerobase.stock.model.Company;
import com.zerobase.stock.model.Dividend;
import com.zerobase.stock.model.ScrapedResult;
import com.zerobase.stock.model.constants.CacheKey;
import com.zerobase.stock.persist.CompanyRepository;
import com.zerobase.stock.persist.DividendRepository;
import com.zerobase.stock.persist.entity.CompanyEntity;
import com.zerobase.stock.persist.entity.DividendEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.archive.scan.spi.ScanResult;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class FinanceService {

    private final CompanyRepository companyRepository;
    private final DividendRepository dividendRepository;

    @Cacheable(key = "#companyName", value = CacheKey.KEY_FINANCE)
    public ScrapedResult getDividendByCompanyName(String companyName){
        log.info("search company ->" + companyName);
/*
// (캐싱되어도 되는 값인지.. 조건인지 생각해보긔)
// 요청이 자주 들어오는가?
// 자주 변경되는 데이터 인가?
 */
        //1. 회사명 기준으로 회사 정보를 조회
       CompanyEntity company= this.companyRepository.findByName(companyName)
                                                .orElseThrow(() -> new NoCompanyException());

        //2. 조회된 회사 id로 배당금 정보 조회
        List<DividendEntity> dividendEntities =  this.dividendRepository.findAllByCompanyId(company.getId());


        //3. 결과 조합 후 반환
        /* //방법1 for문이용
        List<Dividend> dividends = new ArrayList<>();
        for(var entity : dividendEntities) {
            dividends.add(
                    Dividend.builder()
                            .date(entity.getDate())
                            .dividend(entity.getDividend())
                            .build());
        } //End for문
         */

        //방법2 stram이용
        List<Dividend> dividends = dividendEntities.stream()
                .map(e -> new Dividend(e.getDate(), e.getDividend()))
                .collect(Collectors.toList());

        return new ScrapedResult(new Company(company.getTicker(), company.getName()),
                                dividends);
    }

}
