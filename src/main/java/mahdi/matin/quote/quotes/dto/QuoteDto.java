package mahdi.matin.quote.quotes.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class QuoteDto {
    private UUID id;
    @NotNull(message = "Content is required")
//    private String author;
    private String content;
    private String addedAt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss z").format(new Date());
//    private int likes;
}
