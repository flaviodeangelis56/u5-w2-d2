package flaviodeangelis.u6w2d2.entities;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BlogPost {
    private long id;
    private String category;
    private String title;
    private String cover;
    private String content;
    private int readingTime;
}
