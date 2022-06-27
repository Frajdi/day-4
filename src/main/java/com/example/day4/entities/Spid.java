package com.example.day4.entities;


import com.example.day4.entities.enums.Status;
import com.example.day4.entities.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Optional;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "spid")
@Data
public class Spid extends Base{
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Type type;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}