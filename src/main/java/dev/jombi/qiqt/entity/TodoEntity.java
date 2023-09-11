package dev.jombi.qiqt.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String content;
    public boolean success;
}
