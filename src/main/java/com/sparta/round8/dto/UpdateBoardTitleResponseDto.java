package com.sparta.round8.dto;

import lombok.Getter;

@Getter
public class UpdateBoardTitleResponseDto {

    private final Long id;
    private final String title;
    private final String contents;

    public UpdateBoardTitleResponseDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }
}
