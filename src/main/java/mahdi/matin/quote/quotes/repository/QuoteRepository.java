package mahdi.matin.quote.quotes.repository;

import mahdi.matin.quote.quotes.entity.QuoteEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface QuoteRepository extends CrudRepository<QuoteEntity, UUID> {

}
