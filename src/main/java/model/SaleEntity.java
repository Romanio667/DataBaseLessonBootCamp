package model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "sale", schema = "public", catalog = "postgres")
public class SaleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "sale_id", nullable = false, length = 200)
    private String saleId;
    @Basic
    @Column(name = "amount", nullable = false, precision = 3)
    private BigDecimal amount;
    @Basic
    @Column(name = "date_sale", nullable = true)
    private Timestamp dateSale;
    @Basic
    @Column(name = "product_id", nullable = false)
    private int productId;
    @Basic
    @Column(name = "user_id", nullable = false)
    private int userId;
    @Basic
    @Column(name = "store_id", nullable = false)
    private int storeId;

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Timestamp getDateSale() {
        return dateSale;
    }

    public void setDateSale(Timestamp dateSale) {
        this.dateSale = dateSale;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleEntity that = (SaleEntity) o;
        return productId == that.productId && userId == that.userId && storeId == that.storeId && Objects.equals(saleId, that.saleId) && Objects.equals(amount, that.amount) && Objects.equals(dateSale, that.dateSale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleId, amount, dateSale, productId, userId, storeId);
    }
}
