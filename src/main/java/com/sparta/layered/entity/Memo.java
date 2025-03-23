package com.sparta.layered.entity;

import com.sparta.layered.dto.MemoRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Memo {

    // Repository layer에서 식별자를 생성해주기 위해 Setter 사용
    // 이 경우 클레스 레벨이 아닌 특정 속성 위에 적었으므로 id만 적용된다
    @Setter
    private Long id;
    private String title;
    private String contents;

    // lombok을 통해 생성자가 주입되어 있지만 title과 contents만으로 생성할 수 있는 생성자가 없다!(Service부분에 필요함)
    public Memo(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }


    // 원래는 MemoRequestDto 타입으로 매개변수를 받고, dto.getTiltle()을 this.title로 넘겨줬었는데 수정한다
    // 이렇게 할 경우 재사용성이 높아진다!
    // 왜? -> 매개변수로 Dto타입으로 받을 경우 꼭 Dto타입이 들어와야 하지만 String 등의 기본 타입으로 들어오면 그 타입만 맞으면 누구든지 사용가능하기 때문!
    // 이렇게 기본 타입을 사용하면 이후에 테스트 코드 작성시에도 유용하다
    public void update(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    // 여기도 update와 마찬가지
    public void updateTitle(String title) {
        this.title = title;
    }

}