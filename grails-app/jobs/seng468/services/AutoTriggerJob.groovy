package seng468.services

class AutoTriggerJob {

    def TransactionService

    static triggers = {
      simple repeatInterval: 60000 // execute job once in 5 seconds
    }

    def execute() {
        //execute job
        log.info("-----------------------TRIGGER--------------------")
        transactionService.checkTrigger()
    }
}
