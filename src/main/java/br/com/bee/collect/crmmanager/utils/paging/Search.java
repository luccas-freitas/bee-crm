package br.com.bee.collect.crmmanager.utils.paging;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Search {
    private String value;
    private String regexp;
}
