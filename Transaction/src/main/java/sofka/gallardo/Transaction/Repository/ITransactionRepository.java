package sofka.gallardo.Transaction.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sofka.gallardo.Transaction.Entity.TransactionEntity;

import java.time.LocalDateTime;
import java.util.List;


public interface ITransactionRepository extends JpaRepository<TransactionEntity,Long> {

    @Query("SELECT t FROM TransactionEntity t WHERE t.dateTransaction BETWEEN :startDate AND :endDate")
    List<TransactionEntity> reportBeetweenDates(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);


}
