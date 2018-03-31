package seng468project

import grails.transaction.Transactional
import seng468project.beans.QuoteServerTypeBean
import seng468project.helpers.CSocket
import seng468project.helpers.JedisDB
import grails.util.Environment

@Transactional
class QuoteService {

    def auditService
//    static transactional = false

//    @Metered(value='QuoteService.getQuote', useClassPrefix = false)
    def getQuote(User user, String symbol, int transactionNum) {
        String res

        CSocket client = new CSocket()
        String ipaddress = "192.168.1.152"
        int port = 4447
        QuoteServerTypeBean record
        if(Environment.current == Environment.PRODUCTION){
            JedisDB jedis = new JedisDB()
            String value = jedis.jedis.get(symbol)
            if(!value){
                client.start( ipaddress, port )
                res = client.sendMessage(symbol +"," + user.username)
                client.stop()
                jedis.addNewEntry(symbol, res)
                List<String> resList = res.split(",")
                record = new QuoteServerTypeBean(System.currentTimeMillis(), "quoteserve.seng:"+ (port as String), transactionNum, resList[0], resList[1], resList[2], resList[3] as Long, resList[4])
                auditService.dispatch( user.username, auditService.getQuoteServerString(record) )
            }else{
                res = value
                List<String> resList = res.split(",")
                record = new QuoteServerTypeBean(System.currentTimeMillis(), "quoteserve.seng:"+ (port as String), transactionNum, resList[0], resList[1], resList[2], resList[3] as Long, resList[4])
            }

        }else{
            record = new QuoteServerTypeBean(
                System.currentTimeMillis(),
                "quoteserve.seng:4447",
                transactionNum,
                "21.4",
                symbol,
                user.username,
                123192 as Long,
                "this is the cryptokey"
            )
            auditService.dispatch( user.username, auditService.getQuoteServerString(record))
        }

        return record
    }
}
