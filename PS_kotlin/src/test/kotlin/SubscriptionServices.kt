import java.time.LocalDateTime
import java.time.YearMonth

class SubscriptionServices {

    fun calculation(payData:PayData):LocalDateTime{
        println((payData.paymentAmount%100_000L))
        val addMonth:Long = if(payData.paymentAmount>=100_000) (payData.paymentAmount/100_000L)*12+(payData.paymentAmount%100_000L)/10_000L
        else payData.paymentAmount/10_000L


        return if(payData.firstBillingDate!=null){
            check(payData,addMonth)
        }else{
            payData.billingDate.plusMonths(addMonth)
        }
    }
    private fun check(payData:PayData,addMonth:Long):LocalDateTime{
        val condidateExp = payData.billingDate.plusMonths(addMonth)
        if(isSameDayOfMonth(condidateExp, payData)){
            val dayLenOfCandiMon = lastDayOfMonth(condidateExp)
            val dayOfFirstBilling = payData.firstBillingDate!!.dayOfMonth
            if(dayLenOfCandiMon < dayOfFirstBilling){
                return condidateExp.withDayOfMonth(lastDayOfMonth(condidateExp))
            }
            return condidateExp.withDayOfMonth(dayOfFirstBilling)
        }else{
            return condidateExp
        }
    }

    private fun isSameDayOfMonth(condidateExp: LocalDateTime, payData: PayData) =
        condidateExp.dayOfMonth != payData.firstBillingDate!!.dayOfMonth

    private fun lastDayOfMonth(condidateExp: LocalDateTime?) = YearMonth.from(condidateExp).lengthOfMonth()
}

data class PayData(val firstBillingDate:LocalDateTime?=null,
                   val billingDate:LocalDateTime,
                   val paymentAmount:Int){

}
