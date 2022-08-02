package br.com.bee.collect.crmmanager.controller;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import br.com.bee.collect.crmmanager.model.State;
import br.com.bee.collect.crmmanager.model.StateItem;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("states")
public class StatesRestController {

    @GetMapping
    public List<StateItem> stateItems(@RequestParam(value = "q", required = false) String query) {
        if (StringUtils.isEmpty(query)) {
            return Arrays.stream(State.values())
                    .limit(15)
                    .map(this::mapToStateItem)
                    .collect(Collectors.toList());
        }

        return Arrays.stream(State.values())
                .filter(state -> state.getLabel()
                        .toLowerCase()
                        .contains(query))
                .limit(15)
                .map(this::mapToStateItem)
                .collect(Collectors.toList());
    }

    private StateItem mapToStateItem(State state) {
        return StateItem.builder()
                .id(state)
                .text(state.getLabel())
                .slug(state.name())
                .build();
    }
}