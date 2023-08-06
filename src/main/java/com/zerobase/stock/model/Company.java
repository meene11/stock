package com.zerobase.stock.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 자기 역할의 범위에 벗어나기 때문에. entity의 company. 모델의 company 역할이 다름. 재사용과 다른 성격임 재사용은 같은 용도로 사용가능할 코드. 중복피함을 위함들.
@Data // getter, setter, toString 등 여러가지 기능을 @Data 하나로 .
//@Builder //빌더패턴으로 사용가능한 어노테이션@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    private String ticker;
    private String name;
}

/*
@Builder 어노테이션을 사용하게되면, 이런식으로 각각 변수를 지정해주는 코드로 사용하게 되어 직관적인 장점이 있다.
new ScrapedResult(Company.builder()
                    .ticker(company.getTicker())
                    .name(company.getName())
                    .build(),
                dividends);


 */