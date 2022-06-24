package com.example.service.springboot.eccomerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "transaksi")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value ={"createdAt","updatedAt"}, allowGetters = true)
public class Transaksi implements Serializable{

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    private Long id;

    private Long idUser;

    @Transient
    private List<Long> idsCart;

    private String idCart;

    private String namaItem;

    private String jenisItem;

    private double jmlTransaksi;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updateAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public List<Long> getIdsCart() {
        return idsCart;
    }

    public void setIdsCart(List<Long> idsCart) {
        this.idsCart = idsCart;
    }

    public String getIdCart() {
        return idCart;
    }

    public void setIdCart(String idCart) {
        this.idCart = idCart;
    }

    public String getNamaItem() {
        return namaItem;
    }

    public void setNamaItem(String namaItem) {
        this.namaItem = namaItem;
    }

    public String getJenisItem() {
        return jenisItem;
    }

    public void setJenisItem(String jenisItem) {
        this.jenisItem = jenisItem;
    }

    public double getJmlTransaksi() {
        return jmlTransaksi;
    }

    public void setJmlTransaksi(double jmlTransaksi) {
        this.jmlTransaksi = jmlTransaksi;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
