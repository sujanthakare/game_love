
package com.game_love.demo.controllers.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddLoveRequestDto {

    @NotBlank
    private Long playerId;

    @NotBlank
    private Long gameId;
}