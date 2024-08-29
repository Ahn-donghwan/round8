package com.sparta.round8.service;

import com.sparta.round8.dto.*;
import com.sparta.round8.entity.Board;
import com.sparta.round8.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public BoardSaveResponseDto saveBoard(BoardSaveRequestDto boardSaveRequestDto) {
        Board newBoard = new Board(boardSaveRequestDto.getTitle(), boardSaveRequestDto.getContents());

        Board savedBoard = boardRepository.save(newBoard);

        return new BoardSaveResponseDto(savedBoard.getId(), savedBoard.getTitle(), savedBoard.getContents()
        );
    }

    public List<BoardSimpleResponseDto> getBoards() {
        List<Board> boardList = boardRepository.findAll();

        List<BoardSimpleResponseDto> dtoList = new ArrayList<>();

        for (Board board : boardList) {
            BoardSimpleResponseDto dto = new BoardSimpleResponseDto(board.getTitle());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public BoardDetailResponseDto getBoard(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new NullPointerException("ㅈㅅ 그런 보드 없슴!"));

        return new BoardDetailResponseDto(
                board.getId(), board.getTitle(), board.getContents()
        );
    }

    public UpdateBoardTitleResponseDto updateBoardTitle(Long boardId, UpdateBoardTitleRequestDto updateBoardTitleRequestdto) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new NullPointerException("ㅈㅅ 그런 보드 없슴!!"));

        board.updateTitle(updateBoardTitleRequestdto.getTitle());

        return new UpdateBoardTitleResponseDto(
                board.getId(), board.getTitle(), board.getContents()
        );
    }

    public UpdateBoardContentsResponseDto updateBoaraTitle(Long boardId, UpdateBoardContentsRequestDto updateBoardContentsRequestDto) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new NullPointerException(" ㅈㅅ 그런 보드 업슴!!"));

        board.updateContents(updateBoardContentsRequestDto.getContents());

        return new UpdateBoardContentsResponseDto(
                board.getId(), board.getTitle(), board.getContents()
        );
    }

    public void deleteBoard(Long boardID) { boardRepository.deleteById(boardID);
    }
}
