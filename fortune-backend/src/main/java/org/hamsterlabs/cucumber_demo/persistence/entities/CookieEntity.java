package org.hamsterlabs.cucumber_demo.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cookies")
public class CookieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10000)
    private String quote;
    private String category;
    private String signature;

    public CookieEntity() {
        }

        public CookieEntity(String quote, String category, String signature) {
            this.quote = quote;
            this.category = category;
            this.signature = signature;
        }

        public String getQuote() {
            return quote;
        }

        public void setQuote(String quote) {
            this.quote = quote;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
