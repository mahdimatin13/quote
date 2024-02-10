package mahdi.matin.quote.quotes.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import mahdi.matin.quote.quotes.dto.QuoteDto;
import mahdi.matin.quote.quotes.entity.QuoteEntity;
import mahdi.matin.quote.quotes.service.QuoteService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Controller
@RequestMapping("api/v1/quotes")
public class QuoteController {
    private final QuoteService service;
    private final ModelMapper mapper;

    private QuoteDto convertToDto(QuoteEntity entity) {
        return mapper.map(entity, QuoteDto.class);
    }
    private QuoteEntity convertToEntity(QuoteDto dto) {
        return mapper.map(dto, QuoteEntity.class);
    }

    @GetMapping("/{id}")
    public QuoteDto getQuoteById(@PathVariable("id") UUID id) {
        return convertToDto(service.findQuoteById(id));
    }
    @PostMapping
    public QuoteDto postQuote(@Valid @RequestBody QuoteDto quoteDto) {
        var entity = convertToEntity(quoteDto);
        var quote = service.addQuote(entity);
        return convertToDto(quote);
    }

    @PutMapping("/{id}")
    public void putQuote(@PathVariable("id") UUID id, @Valid @RequestBody QuoteDto quoteDto) {
        if (!id.equals(quoteDto.getId())) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id does not match.");

        var quoteEntity = convertToEntity(quoteDto);
        service.updateQuote(id, quoteEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteQuoteById(@PathVariable("id") UUID id) {
        service.removeQuoteById(id);
    }

    @GetMapping
    public String getQuotes(Model model) {

        var quoteList = StreamSupport.stream(service.findAllQuotes().spliterator(), false)
                .toList();
        List<QuoteDto> quote =  quoteList
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        model.addAttribute("quotes", quote);
        return "quotes";

    }
}