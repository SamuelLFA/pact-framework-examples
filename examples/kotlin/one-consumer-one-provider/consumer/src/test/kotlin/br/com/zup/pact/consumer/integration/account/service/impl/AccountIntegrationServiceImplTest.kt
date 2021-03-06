package br.com.zup.pact.consumer.integration.account.service.impl

import br.com.zup.pact.consumer.dto.BalanceDTO
import br.com.zup.pact.consumer.integration.account.service.AccountIntegrationService
import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate

@ExtendWith(MockKExtension::class)
class AccountIntegrationServiceImplTest {

    private val restTemplate: RestTemplate = mockk()
    private val url: String = "http://localhost:8080/v1/accounts/1/balance/"

    private val accountIntegrationServiceMock: AccountIntegrationService = AccountIntegrationServiceImpl(
            url, restTemplate
    )

    @Test
    fun `Method getBalance by accountId returns a body with BalanceDTO`() {

        every {
            restTemplate.getForEntity(
                    url,
                    BalanceDTO::class.java, 1)
        }.returns(ResponseEntity<BalanceDTO>(BalanceDTO(1, 1, 200.0),
                        HttpStatus.OK))

        val result: BalanceDTO? = accountIntegrationServiceMock.getBalance(1)

        Assertions.assertThat(result).isEqualTo(BalanceDTO(1, 1, 200.0))
    }

    @Test
    fun `Method getBalance by accountId returns empty body`() {

        every {
            restTemplate.getForEntity(
                    url,
                    BalanceDTO::class.java, 2)
        }.returns(ResponseEntity<BalanceDTO>(
                HttpStatus.NOT_FOUND))

        val result: BalanceDTO? = accountIntegrationServiceMock.getBalance(2)

        Assertions.assertThat(result).isNull()
    }
}