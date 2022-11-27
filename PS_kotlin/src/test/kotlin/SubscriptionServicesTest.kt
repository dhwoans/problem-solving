import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.LocalDateTime
import kotlin.test.assertEquals


class SubscriptionServicesTest {
    @Test
    fun 일만원납부() {
        val payData = PayData(
            billingDate = LocalDateTime.of(2022, 2, 28, 0, 0),
            paymentAmount = 10_000
        )
        val service = SubscriptionServices()
        val data = service.calculation(payData)
        assertEquals(LocalDateTime.of(2022, 3, 31, 0, 0), data)
    }

    @Test
    fun 첫납부_만료일_납부일_같지_않을때(){
        val payData = PayData(
            firstBillingDate =   LocalDateTime.of(2022, 2, 28, 0, 0),
            billingDate = LocalDateTime.of(2022, 3, 31, 0, 0),
            paymentAmount = 10_000
        )
        val service = SubscriptionServices()
        val data = service.calculation(payData)
        assertEquals(LocalDateTime.of(2022, 4, 30, 0, 0),data)
    }
    @Test
    fun 이만원납부() {
        val payData = PayData(
            billingDate = LocalDateTime.of(2022, 2, 28, 0, 0),
            paymentAmount = 20_000
        )
        val service = SubscriptionServices()
        val data = service.calculation(payData)
        assertEquals(LocalDateTime.of(2022, 4, 30, 0, 0),data)
    }
    @Test
    fun 삼만원납부() {
        val payData = PayData(
            billingDate = LocalDateTime.of(2022, 3, 1, 0, 0),
            paymentAmount = 30_000
        )
        val service = SubscriptionServices()
        val data = service.calculation(payData)
        assertEquals(LocalDateTime.of(2022, 5, 1, 0, 0),data)
    }
    @Test
    fun 십만원납부() {
        val payData = PayData(
            billingDate = LocalDateTime.of(2022, 3, 1, 0, 0),
            paymentAmount = 100_000
        )
        val service = SubscriptionServices()
        val data = service.calculation(payData)
        assertEquals(LocalDateTime.of(2023, 3, 1, 0, 0),data)
    }

    @Test
    fun 십만원초과납부() {
        val payData = PayData(
            billingDate = LocalDateTime.of(2022, 3, 1, 0, 0),
            paymentAmount = 120_000
        )

        val service = SubscriptionServices()
        val data = service.calculation(payData)
        assertEquals(LocalDateTime.of(2023, 5, 1, 0, 0),data)
    }
    @Test
    fun 윤달에납부() {
        val payData = PayData(
            billingDate = LocalDateTime.of(2020, 2, 29, 0, 0),
            paymentAmount = 100_000
        )

        val service = SubscriptionServices()
        val data = service.calculation(payData)
        assertEquals(LocalDateTime.of(2021, 2, 28, 0, 0),data)
    }
}