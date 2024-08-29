package com.sparta.round8.controller;

import com.sparta.round8.dto.*;
import com.sparta.round8.entity.Board;
import com.sparta.round8.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.PartitionKey;
import org.hibernate.sql.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/boards")
    public ResponseEntity<BoardSaveResponseDto> saveBoard(@RequestBody BoardSaveRequestDto boardSaveRequestDto){
        return ResponseEntity.ok(boardService.saveBoard(boardSaveRequestDto));
    }

    @GetMapping("/boards")
    public ResponseEntity<List<BoardSimpleResponseDto>> getBoards(){
        return ResponseEntity.ok(boardService.getBoards());
    }

    @GetMapping("/boards/{boardId}")
    public ResponseEntity<BoardDetailResponseDto> getBoard(@PathVariable Long boardId){
        return ResponseEntity.ok(boardService.getBoard(boardId));
    }

    @PutMapping("/boards/{boardId}")
    public ResponseEntity<UpdateBoardTitleResponseDto> updateBoardTitle(@PathVariable Long boardId, @RequestBody UpdateBoardTitleRequestDto updateBoardTitleRequestdto){
        return ResponseEntity.ok(boardService.updateBoardTitle(boardId, updateBoardTitleRequestdto));
    }

    @PutMapping("/boards/{boardId}")
    public ResponseEntity<UpdateBoardContentsResponseDto> updateBoardContents(@PathVariable Long boardId, @RequestBody UpdateBoardContentsRequestDto updateBoardContentsRequestDto){
        return ResponseEntity.ok(boardService.updateBoaraTitle(boardId, updateBoardContentsRequestDto));
    }

    @DeleteMapping("/boards/{boardID}")
    public void deleteBoard(@PathVariable Long boardID) { boardService.deleteBoard(boardID); }

}
