package com.vella.URLShortenerRedirectionService.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Getter
@Setter
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String realURL;

    private String shortURL;
}
