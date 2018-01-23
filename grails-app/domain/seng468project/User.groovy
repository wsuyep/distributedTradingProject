package seng468project

class User {

    String username
    BigDecimal balance
    BigDecimal reservedBalance
    Map stockShareMap
    static hasMany = [transactionList: Transaction]

    BigDecimal realBalance() {
        return this.balance - this.reservedBalance
    }

    static constraints = {
        username unique: true
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", version=" + version +
                ", transactionList=" + transactionList +
                ", username='" + username + '\'' +
                ", balance=" + balance +
                ", reservedBalance=" + reservedBalance +
                '}'
    }
}
