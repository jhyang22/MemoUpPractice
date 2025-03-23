package com.sparta.layered.repository;

import com.sparta.layered.dto.MemoResponseDto;
import com.sparta.layered.entity.Memo;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Annotation @Repository는 @Component와 같다, Spring Bean으로 등록한다는 뜻.
 * Spring Bean으로 등록되면 다른 클래스에서 주입하여 사용할 수 있다.
 * 명시적으로 Repository Layer 라는것을 나타낸다.
 * DB와 상호작용하여 데이터를 CRUD하는 작업을 수행한다.
 */
@Repository
public class MemoRepositoryImpl implements MemoRepository{
    // Repository가 실제 데이터와 상호작용하는 부분이기 때문에 여기에 DB를 넣어준다!
    private final Map<Long, Memo> memoList = new HashMap<>();


    @Override
    public Memo saveMemo(Memo memo) {

        // 식별자를 여기서 생성해준다
        Long memoId = memoList.isEmpty() ? 1 : Collections.max(memoList.keySet()) + 1;
        memo.setId(memoId);

        memoList.put(memoId, memo);

        return memo;
    }

    @Override
    public List<MemoResponseDto> findAllMemos() {

        // init List
        List<MemoResponseDto> allMemos = new ArrayList<>();

        // HashMap<Memo> -> List<MemoResponseDto>
        for (Memo memo : memoList.values()) {
            MemoResponseDto responseDto = new MemoResponseDto(memo);
            allMemos.add(responseDto);
        }

        return allMemos;
    }

    @Override
    public Memo findMemoById(Long id) {

        return memoList.get(id);
    }

    @Override
    public void deleteMemo(Long id) {
        memoList.remove(id);
    }
}
