package mahdi.matin.quote.quotes.service;

import lombok.AllArgsConstructor;
import mahdi.matin.quote.quotes.entity.QuoteEntity;
import mahdi.matin.quote.quotes.exception.NotFoundException;
import mahdi.matin.quote.quotes.repository.QuoteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class QuoteService {
    private final QuoteRepository repo;
    public Iterable<QuoteEntity> findAllQuotes() {
        return repo.findAll();
    }
    public QuoteEntity findQuoteById(UUID id) {
        return findOrThrow(id);
    }
    public void removeQuoteById(UUID id) {
        findOrThrow(id);
        repo.deleteById(id);
    }
    public QuoteEntity addQuote(QuoteEntity quote) {
        return repo.save(quote);
    }
    public void updateQuote(UUID id, QuoteEntity quote) {
        findOrThrow(id);
        repo.save(quote);
    }
    private QuoteEntity findOrThrow(final UUID id) {
        return repo
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundException("Quote by "+ id + "was not found.")
                );

    }
}
