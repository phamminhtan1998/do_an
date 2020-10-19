package com.phamtan.do_an.constants;

import lombok.Data;
import lombok.RequiredArgsConstructor;



public enum  BookCoverType {
    HARD_COVER(1,"Bìa cứng"),
    SOFT_COVER(2,"Bìa mềm"),
    PLASTIC_COVER(3,"Bìa nhựa"),
    LEATHER_COVER(4,"Bìa da"),
    SILK_COVER(5,"Bìa vải");

    private long id;
    private String coverType;

    BookCoverType(long id, String coverType) {
        this.id = id;
        this.coverType = coverType;
    }

    public long getId() {
        return id;
    }

    public String getCoverType() {
        return coverType;
    }
}
