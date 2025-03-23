package com.sparta.layered.repository;

import com.sparta.layered.dto.MemoResponseDto;
import com.sparta.layered.entity.Memo;

import java.util.List;

public interface MemoRepository {

    // ServiceImpl에서 생성한 메모 객체가 여기에 들어온다(즉, id가 없는 상태로 전달됨)
    Memo saveMemo(Memo memo);

    List<MemoResponseDto> findAllMemos();

    Memo findMemoById(Long id);

    void deleteMemo(Long id);
}
