package com.example.assignment2.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@Table(name = "subscription_info")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_id")
    private Long subId;
    @NonNull
    @Column(name = "sub_name")
    private String subName;
    @Column(name = "sub_type")
    private String subType;
    private String membership;

}


