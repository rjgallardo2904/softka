package sofka.gallardo.Transaction.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sofka.gallardo.Transaction.Dto.ResponseReport;
import sofka.gallardo.Transaction.Entity.TransactionEntity;
import sofka.gallardo.Transaction.Service.Impl.TransactionServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ReportTransaction {

    @Autowired
    TransactionServiceImpl transactionService;
    @GetMapping(value = "/reporte/{dni}")
    public ResponseEntity<?> getReportTransaction(@PathVariable Long dni, @RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate){
        List<TransactionEntity> listSearch;
        List<ResponseReport> listResponse=new ArrayList<>();
        listSearch=transactionService.reportBeetweenDates(startDate,endDate);

        for (TransactionEntity recortList : listSearch){
            ResponseReport responseRep= new ResponseReport(
                    recortList.getDateTransaction(),
                    recortList.getAccount().getNamePerson(),
                    recortList.getAccount().getAccountNumber(),
                    recortList.getAccount().getTypeAccount().getName(),
                    recortList.getAccount().getIniBalance(),
                    recortList.getAccount().getState(),
                    recortList.getValueTransaction(),
                    recortList.getBalance()
            );
            listResponse.add(responseRep);

        }

        return new ResponseEntity<> (listResponse, HttpStatus.OK);
    }
}
