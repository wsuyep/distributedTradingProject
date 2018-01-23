package seng468project.beans

class QuoteServerTypeBean {
    Long    timestamp
    String  server
    Integer transactionNum
    String  price
    String  stockSymbol
    String  username
    Long    quoteServerTime
    String  cryptoKey

    QuoteServerTypeBean(Long timestamp, String server, Integer transactionNum, String price, String stockSymbol, String username, Long quoteServerTime, String cryptoKey) {
        this.timestamp = timestamp
        this.server = server
        this.transactionNum = transactionNum
        this.price = price
        this.stockSymbol = stockSymbol
        this.username = username
        this.quoteServerTime = quoteServerTime
        this.cryptoKey = cryptoKey
    }

    @Override
    String toString() {
        return "QuoteServerTypeBean{" +
                "timestamp=" + timestamp +
                ", server='" + server + '\'' +
                ", transactionNum=" + transactionNum +
                ", price='" + price + '\'' +
                ", stockSymbol='" + stockSymbol + '\'' +
                ", username='" + username + '\'' +
                ", quoteServerTime=" + quoteServerTime +
                ", cryptoKey='" + cryptoKey + '\'' +
                '}'
    }
}
