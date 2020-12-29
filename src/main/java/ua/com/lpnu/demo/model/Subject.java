package ua.com.lpnu.demo.model;

import lombok.Data;
import ua.com.lpnu.demo.model.enums.Day;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String audience;
    private String url;
    private Long number;
    @Enumerated(EnumType.STRING)
    private Day day;
    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group groupByGroupId;

}
