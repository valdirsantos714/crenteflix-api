package com.valdirsantos714.crenteflix.model.favoritos;

import com.valdirsantos714.crenteflix.model.conteudo.Conteudo;
import com.valdirsantos714.crenteflix.model.security.Users;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "favoritos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Favoritos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_conteudo")
    private Conteudo conteudo;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users user;
}
