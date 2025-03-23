package com.sparta.layered.service;


import com.sparta.layered.dto.MemoRequestDto;
import com.sparta.layered.dto.MemoResponseDto;
import com.sparta.layered.entity.Memo;

import java.util.List;

// 이건 인터페이스!
public interface MemoService {
    MemoResponseDto saveMemo(MemoRequestDto dto);

    List<MemoResponseDto> findAllMemos();

    MemoResponseDto findMemoById(Long id);

    MemoResponseDto updateMemo(Long id, String title, String contents);

    MemoResponseDto updateTitle(Long id, String title, String contents);

    void deleteMemo(Long id);
}
