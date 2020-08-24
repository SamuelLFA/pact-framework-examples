package br.com.zup.pact.consumer.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BalanceDTO implements Serializable {

    private Integer clientId;
    private Integer accountId;
    private String balance;

}
