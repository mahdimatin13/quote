package mahdi.matin.quote.quotes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "quote_entity")
@AllArgsConstructor
@NoArgsConstructor
public class QuoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @Column(nullable = false, updatable = false)
    private UUID id;
    @NotNull(message = "Content is required")
//    private String author;
//    private String category;
    private String content;
    private String source;
    private String note;
//    private int likes;
    private String addedAt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss z").format(new Date());


}