package lotto.domain.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class ManualLottoNumberInputDTO {

    private final List<String> input;
}
