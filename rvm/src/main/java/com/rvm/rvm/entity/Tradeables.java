package com.rvm.rvm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "item")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tradeables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String namaitem;
    private String item_description;
    private int points;
    private double harga;
    @Lob
    @Column(name = "image_item", columnDefinition = "BLOB")
    private byte[] image_item;
}
