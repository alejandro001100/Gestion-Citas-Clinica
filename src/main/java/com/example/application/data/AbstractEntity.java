package com.example.application.data;

import java.util.concurrent.atomic.AtomicLong;

public abstract class AbstractEntity {
    private static final AtomicLong ID_GENERATOR = new AtomicLong(1000);
    private Long id;

    public AbstractEntity() {
        this.id = ID_GENERATOR.getAndIncrement();
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AbstractEntity that = (AbstractEntity) obj;
        return id.equals(that.id);
    }
}
