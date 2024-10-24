package dev.gameheaven.GameHeaven;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "jogos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    @Id
    private ObjectId id;
    private String gameID;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String price;
    private String developer;
    private String distributor;
    private List<String> genres;
    private String poster;
    private List<String> images;
    private List<String> keys;
}
