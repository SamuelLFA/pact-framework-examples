package br.com.zup.pact.provider.dto;

import br.com.zup.pact.provider.entity.Account;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BalanceDTO implements Serializable {

    private Integer clientId;
    private Integer accountId;
    private BigDecimal balance;
    private String name;
    private String fantasyName;

    public static BalanceDTO fromAccountToDTO(Account accountFound) {
        if (Objects.nonNull(accountFound)) {
            return BalanceDTO.builder()
                    .name(accountFound.getName())
                    .fantasyName(accountFound.getSocialReason())
                    .accountId(accountFound.getId())
                    .clientId(accountFound.getClientId())
                    .balance(accountFound.getBalance())
                    .build();

        }
        return null;
    }
}
